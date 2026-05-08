//方法体中要用到ArrayList的相关方法，故提前引入；

import java.util.ArrayList;

//类名GroupSystem模拟的是教务系统分别根据老师登记结果和学生填写结果进行分组的过程；
public class GroupSystem {

    //静态check方法，用于检查核对名单信息并返回未组队成功的学生名单；
    //形参为两个数组，分别代表学生填写信息和老师登记信息；
    //此静态方法由类名GroupSystem去调用，方法体内部由对象去调用其他实例方法；

    //返回类型为Student类型的数组，表示未组队成功的学生名单，老师登记信息满足以下三个要求：
    //一、1.一个组仅一个学生 2.一个学生在多个组里同时出现，则在这些组里的学生全部无效 3.俩学生填写的实验室与老师登记的不一致；
    //二、学生填写了信息，却没能被老师登记上；
    //三、若所有学生均组队成功，则返回null；
    public static Student[] check(Student[] students, Group[] groups) {
        //创建一个快捷循环，用Group类型的迭代变量e去遍历groups数组的每一个元素；
        //e表示一次的登记信息，包含俩学生和登记的实验室编号；
        for (Group e : groups) {
            //这里先把俩学生分别提取出来，方便后续在同一个方法内使用；
            Student s1 = e.getStudent1();
            Student s2 = e.getStudent2();


            //如果登记信息中仅有一个学生，那么将他的组员属性为他自己；
            //这里考虑的是情况一的1；
            if (s2 == null) {
                s1.setMember(s1);
                //后续代码是针对两个学生的，故不用执行了，直接进入下一轮循环；
                continue;
            }


            //所有人的member属性里的内容均默认为初值null，表示尚未组队；
            //当检测到登记的俩人均尚未组队，且他俩填写的实验室与登记的实验室是一致的，那么他们组队成功；
            //分别给俩人的队友属性赋值上对方；
            if (s1.getMember() == null && s2.getMember() == null && e.checkSameLab()) {
                s1.setMember(s2);
                s2.setMember(s1);
            }


            //进到else循环中表示不符合组队成功的标准：
            else {
                //情况一的2：一个学生在多个组里面出现，这些组里的所有学生全部无效；
                //当s1的队友属性已被赋值时，说明他要么已经组队成功了，要么就是已经被判定无效了的；
                //无论如何，这些学生都重复出现了，符合情况一的3判定；
                if (s1.getMember() != null) {
                    Student s1Member = s1.getMember();
                    s1.setMember(s1);
                    s1Member.setMember(s1Member);
                    s2.setMember(s2);
                }


                //s2同理，不仅他自己会无效，他曾经成功匹配的队友也会被无效；
                //故先用Student类型s2Member提取他的前队友；
                //出现情况一的3，会导致s2自己，s2的前队友，与s1三个学生同时无效；
                //故这里要将他们的队友属性均赋值为他们自己；
                if (s2.getMember() != null) {
                    Student s2Member = s2.getMember();
                    s2.setMember(s2);
                    s2Member.setMember(s2Member);
                    s1.setMember(s1);
                }


                //情况一的3；俩学生填写的实验室编号与老师登记的不一致；
                //那么将自己的队友属性填上自己，表示无效；
                if (!e.checkSameLab()) {
                    s1.setMember(s1);
                    s2.setMember(s2);
                }
            }
        }
        //遍历老师登记信息的循环结束，此时已经默认考虑到了情况二：学生填写了信息但是老师没登记上；
        //这部分无效学生的队友属性始终保持着初始默认状态，即null；


        //创建Student类型的ArrayList：nullGroups1，它用于添加未组队成功的学生；
        ArrayList<Student> nullGroupsList = new ArrayList<>();
        for (Student e : students) {
            Student eMember = e.getMember();
            //无效学生的队友属性要不是null，要不是自己；
            if (eMember == null || eMember == e) {
                nullGroupsList.add(e);
            }
        }


        //考虑情况三：无效学生学生名单为空，返回null；
        if (nullGroupsList.isEmpty()) {
            return null;
        }


        //由于方法要求返回类型为Student类型的数组；
        //故这里要将ArrayList的nullGroups1转换为数组的nullGroups2；
        int length = nullGroupsList.size();
        Student[] nullGroupsArray = new Student[length];
        for (int i = 0; i < length; i++) {
            nullGroupsArray[i] = nullGroupsList.get(i);
        }
        return nullGroupsArray;
    }


    //静态方法group：用于根据学生填写的信息给出分组名单，具体规则为：
    //一、不能跨实验室组队，即仅能填写同一实验室编号的学生之间进行组队；
    //二、若多个学生填写了同一个实验室编号，那么现将他们按照成绩下降顺序两两组队；
    //三、倘若同一实验室下总人数为奇数，那么成绩最差的那个人单独成队；
    public static Group[] group(Student[] students) {
        //这一部非常关键！由于ArrayList类型的studentList是静态的，故在连续测试样例下会导致交叉干扰现象；
        //即，残留元素未能被删去，而是被直接运用到了下一次的测试中导致结果错误；
        //故咱们在这里使用setStudentList1方法，给26个ArrayList重新开辟存储空间，用于将studentList重新初始化；
        Student.setStudentList1();


        //依次遍历学生填写的信息；
        for (Student e : students) {
            //创建position作为下一行方法调用的实参；
            //position实现了学生填写实验室编号和数组下标之间的对应；
            //（int）‘A’为65，‘A’对应studentList数组的下标0，‘Z’对应该数组下标25；
            int position = (int) e.getLab() - 65;
            //利用类名调用静态方法setStudentList2，将学生加到对应实验室下面；
            Student.setStudentList2(e, position);
        }


        //用studentList接收Student类名下的静态属性StudentList；
        ArrayList<Student>[] studentList = Student.getStudentList();


        //这段代码实现“冒泡排序”，按照学生成绩高低排序，高的在前，低的往后；
        for (int i = 0; i < 26; i++) {
            //labList是studentList的元素，它本身是ArrayList类型的，它的元素为Student类型；
            //labList表示同一实验室编号下的学生名单；
            ArrayList<Student> labList = studentList[i];
            int length = labList.size();
            //j循环走一次，成绩最低到尾巴处；走两次，成绩次低到倒数第二位置......；
            //故走length-1次，便能实现从大到小排序；
            for (int j = 0; j < length - 1; j++) {
                //当j=0时，需要比较length-1次；j=1时，比较length-2次（它肯定比不过最小的，这点毋庸置疑）......；
                //故对于一个特定的j，比较次数为length-j-1；
                for (int k = 0; k < length - j - 1; k++) {
                    //s1提取出labList下标为k处的学生；
                    Student s1 = labList.get(k);
                    //s2提取出labList下标为k+1处的学生；
                    Student s2 = labList.get(k + 1);
                    if (s1.getGrade() < s2.getGrade()) {
                        //即，交换s1和s2所处的位置；
                        labList.set(k, s2);
                        labList.set(k + 1, s1);
                    }
                }
            }
        }


        //创建一个ArrayList类型的groupsList用于存放组队名单；
        ArrayList<Group> groupsList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            //labList表示同一实验室下学生名单（已经按照成绩的降序排列好）；
            ArrayList<Student> labList = studentList[i];
            //length表示该labList名单下学生的总个数；
            int length = labList.size();
            //lab将labList位于studentList的下标转换为对应实验室编号；
            char lab = (char) (i + 65);
            for (int j = 1; j < length; j += 2) {
                //用j-1而不是j+1主要是预防越界问题；
                Student s1 = labList.get(j - 1);
                Student s2 = labList.get(j);
                //group用于创建组队信息，并将组队信息添加到groupsList上；
                Group group = new Group(s1, s2, lab);
                groupsList.add(group);
            }
            //考虑当同一个实验室下总人数为奇数的情况；
            //这时候还差最后一个人没有遍历，上一个循环便结束了；
            //故这里将最后一个人单独组队；
            if (length % 2 == 1) {
                Student s1 = labList.get(length - 1);
                Group group = new Group(s1, lab);
                groupsList.add(group);
            }
        }


        //由于返回类型为数组，故要用一个数组groupsArray去接住ArrayList的groupList；
        int length = groupsList.size();
        Group[] groupsArray = new Group[length];
        for (int i = 0; i < length; i++) {
            groupsArray[i] = groupsList.get(i);
        }

        return groupsArray;
    }
}
