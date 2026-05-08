import java.util.Scanner;

//作业老师的写法，在矩阵周围打上一圈“-1”墙，大大简化分类讨论过程，简单明了；
public class CatAndDog3Method2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] cat = new int[m + 2][n + 2];

        for (int i = 0; i < m + 2; ++i) {
            for (int j = 0; j < n + 2; ++j) {
                if (i != 0 && i != m + 1 && j != 0 && j != n + 1) {
                    cat[i][j] = in.nextInt();
                } else {
                    cat[i][j] = -1;
                }
            }
        }

        int mon = in.nextInt();
        int dis = in.nextInt();
        if (cat[mon][dis] != -1) {
            System.out.println(cat[mon][dis]);
            System.exit(0);
        }

        int left = cat[mon][dis - 1];
        int right = cat[mon][dis + 1];
        int up = cat[mon - 1][dis];
        int down = cat[mon + 1][dis];
        if (left != -1 && right != -1 && up != -1 && down != -1) {
            System.out.println((left * 3 + right * 3 + up * 2 + down * 2) / 10);
        }

        if (left == -1 ^ right == -1 && up != -1 && down != -1) {
            int second;
            if (left == -1) {
                second = right;
            } else {
                second = left;
            }
            System.out.println((second * 6 + up * 7 + down * 7) / 20);
        }

        if (left != -1 && right != -1 && up == -1 ^ down == -1) {
            int third;
            if (up == -1) {
                third = down;
            } else {
                third = up;
            }
            System.out.println((left * 2 + right * 2 + third) / 5);
        }

        if (left == -1 ^ right == -1 && up == -1 ^ down == -1) {
            int fourth1;
            if (left == -1) {
                fourth1 = right;
            } else {
                fourth1 = left;
            }

            int fourth2;
            if (up == -1) {
                fourth2 = down;
            } else {
                fourth2 = up;
            }
            System.out.println((fourth1 * 3 + fourth2 * 2) / 5);
        }

        if (left == -1 && right == -1 && up != -1 && down != -1) {
            System.out.println((up + down) / 2);
        }

        if (left != -1 && right != -1 && up == -1 && down == -1) {
            System.out.println((left * 2 + right * 3) / 5);
        }

        if (left == -1 && right == -1 && up == -1 && down == -1) {
            System.out.println("DATA CANNOT BE REPAIRED");
        }
    }
}