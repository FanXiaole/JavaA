import java.util.Scanner;

public class Pai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the precision:");
        double precision = input.nextDouble();
        double pi = 0, add;
        int i = 0;
        //while循环永久进行，除非满足特定条件break掉跳出循环；
        do {
            ++i;
            //两个int类型相处结果处理为int类型，而add本应该为double类型；
            //法1：将（double）加在4前或者加在（2*i-1）前；
            //法2：将4改成4.0；
            add = 4 / (double) (2 * i - 1);
            //pi=4-4/3+4/5-4/7......；
            if (i % 2 == 1) {
                pi += add;
            } else {
                pi -= add;
            }
        } while (!(add < precision));
        //输出结果保留小数点后六位小数；
        System.out.printf("The estimation of Pi is %.6f\n", pi);
        System.out.printf("It computed %d times", i);
    }
}
