import java.util.Scanner;

public class MatrixTranspose {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        //要算平均数，所以数组类型为double；
        //行不变，列扩展一例，即每一行的最后一个数是该行前所有数的平均值；
        double[][] matrix = new double[r][c + 1];
        for (int i = 0; i < r; i++) {
            //大循环（行）每循环一次，sum自动更新为0；
            double sum = 0;
            for (int j = 0; j < c; j++) {
                matrix[i][j] = in.nextInt();
                sum += matrix[i][j];
            }
            //这里的sum为double类型，故无需在sum之前再加上（double）了；
            //若sum为int类型，则需要在sum前加上（double），否则赋值为整数类型；
            matrix[i][c] = sum / c;
        }
        //转置矩阵的行、列均扩一个；
        double[][] transMatrix = new double[c + 1][r + 1];
        for (int i = 0; i < c + 1; i++) {
            double sum = 0;
            //注意边界，若这里为j<r+1，那么当j=r时，matrix数组越界了；
            for (int j = 0; j < r; j++) {
                //实现矩阵转置的关键代码；
                transMatrix[i][j] = matrix[j][i];
                sum += transMatrix[i][j];
            }
            //每一行最后一个元素记录该行前面元素的平均值；
            transMatrix[i][r] = sum / r;
        }
        //这里先输出前c行；
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r + 1; j++) {
                System.out.printf("%.2f\t", transMatrix[i][j]);
            }
            System.out.println();
        }
        //最后第c+1行单独输出，记得抠去最后一个元素；
        for (int i = 0; i < r; i++) {
            System.out.printf("%.2f\t", transMatrix[c][i]);
        }
    }
}
