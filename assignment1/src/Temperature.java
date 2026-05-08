import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //首字母小写的表示第一行标准值，大写的表示后续几行循环输入值；
        char type = input.next().charAt(0), Type;
        float tem = input.nextFloat(), Tem;
        //10000f中10000是使初始值足够大，f提醒程序是float类型；
        float transfer, distance, last = 10000f;
        int into = input.nextInt(), n = 1, N = 1;
        while (N <= into) {
            Type = input.next().charAt(0);
            Tem = input.nextFloat();
            //将后几行输入跟第一行标准值进行统一；
            //注意单个字符需要用‘’，而非“”；
            if (type == 'C') {
                if (Type == 'C') {
                    transfer = Tem;
                } else if (Type == 'F') {
                    transfer = (Tem - 32) * 5 / 9;
                } else {
                    //273.15本身为double类型，数字后面加一个f表示float类型；
                    transfer = Tem - 273.15f;
                }
            } else if (type == 'F') {
                if (Type == 'F') {
                    transfer = Tem;
                } else if (Type == 'C') {
                    transfer = Tem * 9 / 5 + 32;
                } else {
                    transfer = (Tem - 273.15f) * 9 / 5 + 32;
                }
            } else {
                if (Type == 'C') {
                    transfer = Tem + 273.15f;
                } else if (Type == 'F') {
                    transfer = (Tem - 32) * 5 / 9 + 273.15f;
                } else {
                    transfer = Tem;
                }
            }
            //将统一后的值和标准值作差取绝对值；
            if (transfer >= tem) {
                distance = transfer - tem;
            } else {
                distance = tem - transfer;
            }
            //取差值较小者进行更新，并记录下此时对应门牌号；
            if (distance < last) {
                last = distance;
                n = N;
            }
            //自增过程别漏；
            N++;
        }
        System.out.printf("%d", n);
    }
}
