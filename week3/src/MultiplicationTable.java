import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //区分while,do-while先做再判定，并且循环至少会执行一次；
        do {
            System.out.println("Please input a number between [1,9]:");
            int number = input.nextInt();
            if (number >= 1 && number <= 9) {
                //双重循环，i遍历行，j遍历列；先行后列；
                //for循环用分号隔开三者：初始值、判断条件、自增。分好不能省！
                //说明：其中自增是执行完主体后、在下一次循环之前进行的；
                //注意：i和j仅在循环内部生效，跳出循环无定义；
                for (int i = 1; i <= number; i++) {
                    //j不能超过i；
                    for (int j = 1; j <= i; j++) {
                        //%2d表示整数位不足两位，则用空格直至满两位；
                        //补充：%02d表示整数位不足两位，则补‘0’直至两位；
                        //“\t”为水平制表符，相当于“Tab”，对其；
                        System.out.printf("%2d * %2d = %2d\t", j, i, j * i);
                    }
                    System.out.println();
                }
                //由于循环是不停的，故需要一个特定的输入使跳出循环；
            } else if (number == 0) {
                break;
            } else {
                System.out.println("Your number is not in [1,9]");
            }
            //do-while中while后千万别忘记加分号；
        } while (true);
    }
}
