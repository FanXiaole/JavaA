import java.util.Scanner;

public class MaterialSynthesis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        int k = in.nextInt();
        //创建矩阵A和B，其中A：n行m列，B：m行p列；
        int[][] A = new int[n][m];
        int[][] B = new int[m][p];
        int[][] C = new int[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                B[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                int sum = 0;
                for (int l = 0; l < m; l++) {
                    int e = A[i][l] * B[l][j];
                    //关键步骤：判断乘项l是否为k的倍数；
                    //注意！！！l从0开始，故每个l对应的乘项为（l+1）；
                    if ((l + 1) % k == 0) {
                        sum -= e;
                    } else {
                        sum += e;
                    }
                }
                C[i][j] = sum;
            }
        }
        //矩阵转置输出代码：n行p列->p行n列；
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[j][i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
