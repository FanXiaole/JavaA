import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {
        //命名并允许从命令窗口读取一个随机数
        Random random = new Random();
        //读取一个边界为10的随机数并把它赋值给magicNum；
        int magicNum = random.nextInt(10);
        int inputNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input an integer in{0,1,2...,9}: ");
        inputNum = sc.nextInt();
        while (inputNum != magicNum) {
            if (inputNum > magicNum)
                System.out.println("Too big!Please try again: ");
            else
                System.out.println("Too small!Please try again: ");
            inputNum = sc.nextInt();
        }
        //只有当猜对了才会跳出循环；
        System.out.println("Congratulations!");
        sc.close();
    }
}
