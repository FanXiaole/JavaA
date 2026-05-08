import java.util.Scanner;

public class DataType {
    public static void main(String[] args) {
        String name;
        int age;
        float weight;
        char grade;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        //字符串类型的输入next后面直接跟括号；
        name = input.next();
        System.out.print("Enter your age: ");
        age = input.nextInt();
        System.out.print("Enter your weight in KG: ");
        weight = input.nextFloat();
        System.out.print("Enter your highest grade in last semester: ");
        //表示grade取输入的一坨东西的首个字符（可以是数字可以是字母，但不能是空格符）；
        //比如输入字符“A23UYT”中读取的是首字母‘A’；（1）表示第二位，（2）表示第三位，以此类推；
        grade = input.next().charAt(0);
        System.out.printf("You are %s.\nYou are %d years old.\n", name, age);
        //%.2f表示输出为float类型并且保留小数点后两位数字；
        System.out.printf("You weigh %.2f KG.\nThe highest grade you got is %c\n", weight, grade);
    }
}
