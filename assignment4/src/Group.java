//Group类模拟的是老师将学生填写好的问卷信息做登记的过程；
public class Group {

    //三个属性：学生1、学生2、实验室编号；
    private final Student student1;
    private Student student2;
    private final char lab;


    //构造方法1：两个学生登记在同一个实验室下面；
    public Group(Student student1, Student student2, char lab) {
        this.student1 = student1;
        this.student2 = student2;
        this.lab = lab;
    }


    //构造方法2：仅有一个学生登记在一个实验室下面；
    public Group(Student student1, char lab) {
        this.student1 = student1;
        this.lab = lab;
    }


    //三个get方法，对应三个实例属性；
    public Student getStudent1() {
        return student1;
    }

    public Student getStudent2() {
        return student2;
    }

    public char getLab() {
        return lab;
    }


    //checkSameLab方法，用于检验老师登记的实验室编号与两个学生填写的实验室编号是否一致？
    public boolean checkSameLab() {
        Student s1 = getStudent1();
        Student s2 = getStudent2();
        return (s1 != null && s2 != null) &&
                (s1.getLab() == getLab() && s2.getLab() == getLab());
    }


    //字符串的格式化，Group类名下的对象的属性之间用下划线_隔开；
    public String toString() {
        Student s1 = getStudent1();
        Student s2 = getStudent2();
        //第一种格式：两个学生均不为空；
        //题目要求按照学号顺序，小的在前，大的在后；
        //故用包装类Integer下面的parseInt方法将纯数字组成的字符串转化为数字形式进行比较；
        if (s2 != null) {
            if (Integer.parseInt(s1.getStudentNumber()) <=
                    Integer.parseInt(s2.getStudentNumber())) {
                return String.format("%c_%s_%s"
                        , getLab(), s1.getStudentNumber(), s2.getStudentNumber());
            } else {
                return String.format("%c_%s_%s"
                        , getLab(), s2.getStudentNumber(), s1.getStudentNumber());
            }
        }
        //第二种格式：一个学生为空；
        else {
            return String.format("%c_%s_null", getLab(), s1.getStudentNumber());
        }
    }
}
