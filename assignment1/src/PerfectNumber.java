import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int l = input.nextInt(), r = input.nextInt(), t = 1, sum = 0, n = 0;
        while (l <= r) {
            //验证该数是否符合PerfectNumber的条件；
            while (t < l) {
                if (l % t == 0) {
                    sum = sum + t;
                }
                t++;
            }
            if (sum == l) {
                n++;
                System.out.printf("%d", l);
            }
            l++;
            //对下一个数进行验证前，需要重置sum和t的值；
            sum = 0;
            t = 1;
        }
        //没找到符合条件的数；
        if (n == 0) {
            System.out.print("-1");
        }
    }
}