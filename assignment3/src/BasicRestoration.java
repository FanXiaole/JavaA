import java.util.Scanner;

public class BasicRestoration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//n表示行数
        int m = in.nextInt();//m表示列数
        char[][] M = new char[n + 2][m + 2];
        //由于M数组在接下来会被大幅度更改；
        //故这里用Origin数组拷贝一个M数组的最初状态；
        char[][] Origin = new char[n + 2][m + 2];
        //在原数组四周打上一圈‘#’墙，代表越界；
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                if (i == 0 || j == 0 || i == n + 1 || j == m + 1) {
                    M[i][j] = '#';
                    Origin[i][j] = '#';
                } else {
                    M[i][j] = in.next().charAt(0);
                    Origin[i][j] = M[i][j];
                }
            }
        }
        String oldstring = in.next();
        String newstring = in.next();

        StringBuilder line1 = new StringBuilder();
        String line2;
        int x = 1, y = 1;
        int index = 0;
        //构建4行2列的位移矩阵，4行分别表示右、下、左、上(呈顺时针旋转顺序)，2列表示横坐标位移、纵坐标位移；
        int[][] movement = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < n * m; i++) {

            //首先，记录当前位置的字符，并将当前字符重设为‘#’，表示曾经走过，后面不能再走了；
            line1.append(M[x][y]);
            M[x][y] = '#';

            //其次，更新index,表示转向或继续往前走；
            if (M[x + movement[index][0]][y + movement[index][1]] == '#') {
                index += 1;
                //3+1==0(在朝上方向顺时针转体90度会到朝右方向)；
                if (index == 4) {
                    index = 0;
                }
            }

            //最后，更新位置坐标；
            x += movement[index][0];
            y += movement[index][1];
        }

        //这段代码实现替换特定字符串的功能；
        //尤其注意的是，replaceAll方法是有返回值的，返回一个替换完成后字符串的新地址，故需要将其复制给到line2；
        line2 = line1.toString();
        line2 = line2.replaceAll(oldstring, newstring);

        //接下来将line2字符串重新按照蛇形顺序进行存储；
        x = 1;
        y = 1;
        index = 0;
        char[][] N = new char[n + 2][m + 2];
        for (int i = 0; i < n * m; i++) {

            //将当前下标i对应line2字符给到数字对应位置上去；
            N[x][y] = line2.charAt(i);
            Origin[x][y] = '#';

            //更新index，表示转向或继续往前走；；
            if (Origin[x + movement[index][0]][y + movement[index][1]] == '#') {
                index += 1;
                if (index == 4) {
                    index = 0;
                }
            }

            //更新位置坐标；
            x += movement[index][0];
            y += movement[index][1];
        }

        //接下来将蛇形数组N进行输出；
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.print(N[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
