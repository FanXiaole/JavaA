import java.util.Scanner;

public class MyList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] list1 = new double[n];
        double[] list2 = new double[n];
        for (int i = 0; i < n; i++) {
            list1[i] = input.nextDouble();
        }
        //这里如果写i<n的话i=n-1时i+1就会=n，越界！；
        for (int i = 0; i < n - 1; i++) {
            list2[i] = list1[i + 1];
        }
        list2[n - 1] = list1[0];
        //注意：这里e后面跟的是一个冒号“：”；
        for (double e : list2) {
            System.out.print(e + "\t");
        }
    }
}
