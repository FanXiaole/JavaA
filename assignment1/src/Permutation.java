import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int order = input.nextInt();
        //取出输入数字的个十百位；
        int number1 = number % 10;
        int number2 = (number % 100 - number1) / 10;
        int number3 = (number - number % 100) / 100;
        int first, second, third;
        //将个十百位数从大到小进行排序；
        if (number1 >= number2 && number1 >= number3) {
            first = number1;
            if (number2 >= number3) {
                second = number2;
                third = number3;
            } else {
                second = number3;
                third = number2;
            }
        }
        //number2>=number1始终为“true”，故这里就不用写入了；
        else if (number2 >= number3) {
            first = number2;
            if (number1 >= number3) {
                second = number1;
                third = number3;
            } else {
                second = number3;
                third = number1;
            }
        } else {
            first = number3;
            if (number2 >= number1) {
                second = number2;
                third = number1;
            } else {
                second = number1;
                third = number2;
            }
        }
        //判断输出顺序；
        if (order == 0) {
            System.out.printf("%d%d%d", first, second, third);
        } else {
            System.out.printf("%d%d%d", third, second, first);
        }
    }
}
