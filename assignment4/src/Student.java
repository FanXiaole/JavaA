//ArrayList类名需要提前引入；

import java.util.ArrayList;

//Student类模拟的是学生填写问卷信息的过程；
public class Student {

    //三个实例变量（属性）：学号、实验室、成绩；
    private final String studentNumber;
    private final char lab;
    private final int grade;


    //属性member同时也是类名Student的对象，用于存放“队友”；
    private Student member = null;


    //静态属性是一个“二元数组”，服务于GroupSystem类名下的Group方法；
    //“二元数组”的行数是固定的，为26，代表实验室编号字母‘A’-‘Z’；
    //ArrayList的每一列表示对应实验室的学生（Student类型）名单；
    //注意，studentList的元素是ArrayList类型的，而它元素的元素才是Student类型的；

    //这个构造方法意思是，studentList是ArrayList类型的（因为它的每一个元素均是一个ArrayList）；
    //并且它的长度为26，即总共有26个ArrayList；
    private static final ArrayList<Student>[] studentList = new ArrayList[26];


    //setStudentList1方法，用于对studentList的初始化；
    //这一步非常关键，缺少则会导致“空指针”的错误，即当存储空间尚未开辟时，程序无法对null进行赋值；
    //这里将一元数组的每一个元素均声明成ArrayList，成功开辟存储空间；
    //故虽然它们的内容为null，但是它本身不是null；
    public static void setStudentList1() {
        for (int i = 0; i < 26; i++) {
            //将26个ArrayList全部开辟存储空间；
            studentList[i] = new ArrayList<>();
        }
    }


    //setStudentList2方法，用于给studentList加入学生；
    //形参student表示即将加入名单的学生、position表示他填写实验室编号对应数组的“行”下标；
    //这里不用去管列下表了，因为add方法是可以直接无视列下标无脑往后加元素的，这是ArrayList的优势之一；
    public static void setStudentList2(Student student, int position) {
        studentList[position].add(student);
    }

    public void setMember(Student member) {
        this.member = member;
    }


    //构造方法：
    public Student(String studentNumber, char lab, int grade) {
        this.studentNumber = studentNumber;
        this.lab = lab;
        this.grade = grade;
    }


    //五个get方法，对应五个实例变量；
    public String getStudentNumber() {
        return studentNumber;
    }

    public char getLab() {
        return lab;
    }

    public int getGrade() {
        return grade;
    }

    public Student getMember() {
        return member;
    }

    public static ArrayList<Student>[] getStudentList() {
        return studentList;
    }


    //字符串的格式化，一个对象的不同属性之间用空格隔开；
    public String toString() {
        return String.format("%s %c %d", getStudentNumber(), getLab(), getGrade());
    }
}
