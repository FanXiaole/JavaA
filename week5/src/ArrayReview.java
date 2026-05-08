import java.util.Arrays;

public class ArrayReview {
    public static void main(String[] args) {
        //必须至少声明行数，否则程序报错；
        int[][] arr = new int[3][];
        //这里arr[0]本身就是一个数组的地址；
        arr[0] = new int[]{1, 2, 3};
        //arr[0]和arr[1]共享一个地址；
        //想象地址相当于一个购物链接网址，你点进去便能跳转到网页上去访问商铺；
        arr[1] = arr[0];
        //注意到，二维数组每一行元素个数可以不同！
        arr[2] = new int[]{3, 4, 5, 6};
        //将数组中元素转换成String类型；
        //输出：[1,2,3]
        System.out.println(Arrays.toString(arr[1]));
        //arr的三个元素并非是int类型的数，而分别是另外数组的地址；
        //故输出：[[I@776ec8df, [I@776ec8df, [I@4eec7777]
        //注意到：前两个地址是一样的，因为他们都指向同一个数组；
        System.out.println(Arrays.toString(arr));
        //“deep"表示进一步深入，将多维数组的元素转化为String类型输出，每一行之间用逗号隔开；
        //输出为：[[1, 2, 3], [1, 2, 3], [3, 4, 5, 6]]
        System.out.println(Arrays.deepToString(arr));
        //将arr[1]中的元素依次赋值给e,但是并不影响原来数组的值；
        for (int e : arr[1]) {
            System.out.println(e);
            e = 0;
            System.out.println(e);
        }
        //将arr的元素依次赋值给a，而arr的元素恰好是其他数组的地址；
        for (int[] a : arr) {
            //这里将输出一个地址，而非一个数！
            System.out.println(a);
        }
        //a被赋值为一维数组的地址；
        for (int[] a : arr) {
            //通过地址，找到数组，通过index锁定数组中对应元素位置并进行改变；
            for (int i = 0; i < a.length; i++) {
                a[i]++;
            }
        }
        //记住！多维数组的String类型输出一定要用Arrays.deepToString!
        System.out.println(Arrays.deepToString(arr));
    }
}
