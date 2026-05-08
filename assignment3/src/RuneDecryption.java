import java.util.Scanner;

public class RuneDecryption {
    public static void main(String[] args) {

        int sum = 0;

        //先创建一个StringBuilder，其最大特点就是“可变性”（mutable）；
        Scanner in = new Scanner(System.in);
        StringBuilder s = new StringBuilder(in.next());

        //下面尝试把数字和字母区分开来；故再创建俩StringBuilder，一个数字一个字母；
        StringBuilder s1 = new StringBuilder();//数字
        StringBuilder s2 = new StringBuilder();//字母
        for (int i = 0; i < s.length(); i++) {
            char e = s.charAt(i);
            //‘1’的ASCll为49，‘9’的ASCll为57；
            //判断为数字；
            if ((int) e < 58) {
                s1.append(e);
                //若奇，删中间项；
                if (s2.length() % 2 == 1) {
                    s2.deleteCharAt((s2.length() - 1) / 2);
                }
                for (int l = 0; l < s2.length(); l++) {
                    sum += s2.charAt(l);
                }
                //s2的清空；
                s2 = new StringBuilder();
                //判断为字母；
            } else {
                s2.append(e);
                //若奇，删中间项；
                if (s1.length() % 2 == 1) {
                    s1.deleteCharAt((s1.length() - 1) / 2);
                }
                for (int j = 0; j < s1.length(); j++) {
                    //这里T代表10的j次方的值；
                    int T = 1;
                    for (int k = 0; k < j; k++) {
                        T *= 10;
                    }
                    sum += (s1.charAt(j) - 48) * T;
                }
                //s1的清空；
                s1 = new StringBuilder();
            }
        }

        //非常关键！！！debug出来的错误：
        //因为s遍历到最后没有数或者字母了，像是123abc这种情况abc还在s2中没被算进sun里面；
        //故需要再次复制粘贴一下算sum的代码，确保sum计算无漏；
        if (s2.length() % 2 == 1) {
            s2.deleteCharAt((s2.length() - 1) / 2);
        }
        for (int l = 0; l < s2.length(); l++) {
            sum += s2.charAt(l);
        }
        if (s1.length() % 2 == 1) {
            s1.deleteCharAt((s1.length() - 1) / 2);
        }
        for (int j = 0; j < s1.length(); j++) {
            int T = 1;
            for (int k = 0; k < j; k++) {
                T *= 10;
            }
            sum += (s1.charAt(j) - 48) * T;
        }
        System.out.println(sum);
    }
}

