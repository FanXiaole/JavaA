public class Employee {

    //同样创建四个属性，其中两个String类型，两个Date类型；
    //其中birthDate和hireDate既是大类名Employee的属性，又是小类名Date的对象；
    //即体现出组合（Composition）的思想：一个类的属性也可以是另一个类的对象；


    //这里非基本数据类型，故在没赋初值的情况下默认值为null；
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date hireDate;


    //声明构造方法；
    public Employee(String first, String last, Date dateOfBirth, Date dateOfHire) {
        firstName = first;
        lastName = last;
        birthDate = dateOfBirth;
        hireDate = dateOfHire;
    }


    //重新改写自带的toString方法；
    //用于让类名Employee下的对象来调用，返回一个格式化的字符串；
    public String toString() {
        //这里属性birthDate和hireDate也是对象来着，他俩均指向一个具有三个属性值的存储空间；
        //相当于birthDate.toString和hireDate.toString,分别获取一串格式化字符串；
        return String.format("%s, %s Birthday: %s Hired: %s", lastName, firstName, birthDate, hireDate);
    }
}
