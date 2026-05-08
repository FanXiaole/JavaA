import java.util.Scanner;

public class PairLarger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int pair = 0;
        double aver = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int num = input.nextInt();
            aver += num;
            array[i] = num;
        }
        aver = (double) aver / n;
        //此方法复杂度较高，表较耗时，有待优化；
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] + array[j] > aver * 2) {
                    pair++;
                }
            }
        }
        System.out.print(pair + "\n");
    }
}
