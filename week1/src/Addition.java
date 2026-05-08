import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        //println在打印完字符串后自动换行；
        System.out.println("Welcome to CS109!");
        //创建一个Scanner对象input，用于从标准输入读取数据；
        Scanner input = new Scanner(System.in);
        int number1, number2, sum;
        System.out.print("Enter the first integer: ");
        number1 = input.nextInt();
        System.out.print("Enter the second integer: ");
        number2 = input.nextInt();
        sum = number1 + number2;
        //printf代表格式化输出，\n为换行符；
        System.out.printf("Sum is %d\n", sum);
    }
}
