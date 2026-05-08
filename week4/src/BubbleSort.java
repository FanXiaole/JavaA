import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            array[i] = num;
        }
        //外循环第一次，能实现最大数放置于最右边；
        //外循环第二次，能实现第二大数放置在从右往左数第二个位置；
        //故总共只需要（n-1）个大循环便可以从小到大排好序；
        for (int i = 0; i < n - 1; i++) {
            //内层循环负责依次比较和交换；
            //注意到i=0时，j需要比较n-1次；
            //而当i=1时，说明最大的数已经摆在最右边了；此时j只用比较n-2次；
            //如此类推，j应该比n-1-i次，即j应当从0~n-2-i，即j<n-1-i；
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        //记得Arrays中A大写且末尾要加s；
        System.out.println(Arrays.toString(array));
    }
}
