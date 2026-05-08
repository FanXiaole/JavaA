import java.util.Arrays;
import java.util.Scanner;

public class MatrixMultiply {
    //此方法用处为：输入并记录矩阵并返回该矩阵；
    public static int[][] inputMatrix(Scanner in) {
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] a = new int[row][col];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = in.nextInt();
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //这里用方法调用，优化代码，删去重复赘余部分，使代码看上去更清爽；
        int[][] a = inputMatrix(in);
        int[][] b = inputMatrix(in);
        //c的行数为a的行数，c的列数为b的列数；
        //b的行数可以用b.length来表示，b的列数可以用b[0].length来表示；
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                //这里用b.length或者a[0].length都可以，因为a的列数和b的行数必然相等；
                for (int k = 0; k < b.length; k++) {
                    //矩阵乘法关键代码；
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        //line自身为一个数组，遍历结果矩阵c的每一行，输出结果为:
        //[14,14]
        //[32,32]
        for (int[] line : c) {
            System.out.println(Arrays.toString(line));
        }
        //此方法针对二维数组，用逗号隔开每一行，输出结果为:
        //[[14,14],[32,32]]
        System.out.println(Arrays.deepToString(c));
    }
}
