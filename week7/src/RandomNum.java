import java.util.Random;

public class RandomNum {
    public static void main(String[] args) {

        //如何实现在[5,10)中随机生成一个整数？


        //方法一：利用Math.random能生成一个[0,1)之间的任意一个数；
        //在此基础上乘上5再强制转成int类型，生成了一个[0,5)之间的整数；
        //最后再加上5，生成一个[5,10)之间的整数，完成任务；
        int m = (int) (Math.random() * 5) + 5;


        //方法二：利用方法的调用；
        //先生成一个[0,5)的随机整数；
        //在此基础上加上5，生成一个[5,10)之间的随机整数；
        Random random = new Random();
        int n = random.nextInt(5) + 5;


        System.out.println(m);
        System.out.println(n);
    }
}
