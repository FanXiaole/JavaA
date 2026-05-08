import java.util.Scanner;

public class IfJudgment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0) {
            //month在循环内部定义，故循环之外无法使用month；
            int month = in.nextInt();
            //判断该月份是大月还是小月，1、3、5、7、8、10、12月是31天的；
            if ((month < 8 && month % 2 == 1) || (month > 7 && month % 2 == 0))
                System.out.println("yes");
            else
                System.out.println("no");
            T--;
        }
    }
}
