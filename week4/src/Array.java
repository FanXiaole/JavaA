import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};//在内存里开辟存储空间，并给予初始值，让array1指向该空间；
        int[] array2 = new int[5];//每个元素初始值为0；
        //array1和2指向了各自的存储空间；
        array2[0] = 6;//array2找到数组储存空间，通过下标0锁定该数组中具体元素，并将6赋值给它；
        array2[1] = 7;
        array2[2] = 8;
        array2[3] = 9;
        array2[4] = 10;
        //遍历数组元素；
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        System.out.println();
        //每一轮循环，将array1中元素依次赋值给e；
        //int保证e和array2中元素的数据类型一致；
        for (int e : array2) {
            System.out.print(e + "\t");//"\t"相当于打出一个tap；
        }
        System.out.println();
        int[] array3 = null;
        //此输出方法将会输出一个 null；
        System.out.println(array3);
        //将array2的地址赋值给array3，即两者共享一个地址；
        array3 = array2;
        //此输出方法将会输出一个类似 [I@58372a00 的哈希密码，每台电脑都不一样；
        //原因是数组是一个非原始类型的变量，不像int等原始类型可以直接输出；
        System.out.println(array3);
        //这段代码没啥鸟用，只是改变e的值，而不改变数组的值
        for (int e : array3) {
            e = 1;
        }
        System.out.println("array3: " + Arrays.toString(array3));
        //这段代码才是正解，它成功将array3中元素进行重赋值；
        //由于array2和3共享一个地址，故array2的值也更跟着改变；
        for (int i = 0; i < array3.length; i++) {
            array3[i] = 1;
        }
        System.out.println("array3: " + Arrays.toString(array3));
        System.out.println("array2: " + Arrays.toString(array2));
        char[] array4 = {'a', 'b', 'c'};
        //这里比较特殊，println可以将元素类型为char的数组直接输出；
        System.out.println(array4);
    }
}
