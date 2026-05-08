import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        //先访问Date类名下两个对象的属性并赋值；
        Date birth = new Date(5, 16, 2006);
        Date hire = new Date(in.nextInt(), in.nextInt(), in.nextInt());


        //employee为类名Employee下的对象，它具有四个属性，分别为：firstName、lastName、birthDate、hireDate;
        //将Date类名下两个对象作为实参传递给employee的构造方法中去；
        Employee employee = new Employee("Fan", "Justin", birth, hire);
        //注意！这里employee就相当于employee.toString();
        System.out.println(employee);
    }
}
