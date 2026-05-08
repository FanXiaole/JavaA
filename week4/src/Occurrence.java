import java.util.Scanner;

public class Occurrence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[10000];
        while (true) {
            int num = in.nextInt();
            if (num == 0) {
                break;
            }
            array[num]++;
        }
        //如此实现了一个数组，该数组元素的值=元素下标对应的数出现次数；
        for (int i = 0; i < array.length; i++) {
            //将没出现（初始值仍为0）的元素剔除掉，无需输出；
            if (array[i] != 0) {
                System.out.print(i + " occurs " + array[i] + " times\n");
            }
        }
    }
}
