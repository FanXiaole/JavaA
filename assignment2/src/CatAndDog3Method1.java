import java.util.Scanner;

//作业自己的写法，if-else语句的堆叠进行分类讨论，很繁琐；
public class CatAndDog3Method1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] cat = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int num = in.nextInt();
                cat[i][j] = num;
            }
        }

        int mon = in.nextInt();
        int dis = in.nextInt();
        if (cat[mon - 1][dis - 1] != -1) {
            System.out.println(cat[mon - 1][dis - 1]);
            System.exit(0);
        }

        if (m == 1 || n == 1) {
            if ((mon != 1 || dis != 1) && (mon != 1 || dis != n) && (mon != m || dis != 1)) {
                if (mon == 1) {
                    if (cat[mon - 1][dis - 2] != -1 && cat[mon - 1][dis] != -1) {
                        System.out.println((cat[mon - 1][dis - 2] * 2 + cat[mon - 1][dis] * 3) / 5);
                    } else {
                        System.out.println("DATA CANNOT BE REPAIRED");
                    }
                } else if (cat[mon - 2][dis - 1] != -1 && cat[mon][dis - 1] != -1) {
                    System.out.println((cat[mon - 2][dis - 1] + cat[mon][dis - 1]) / 2);
                } else {
                    System.out.println("DATA CANNOT BE REPAIRED");
                }
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }

            System.exit(0);
        }

        if (mon == 1 && dis == 1) {
            if (cat[0][1] != -1 && cat[1][0] != -1) {
                System.out.println((cat[0][1] * 3 + cat[1][0] * 2) / 5);
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }

        if (mon == m && dis == n) {
            if (cat[mon - 1][dis - 2] != -1 && cat[mon - 2][dis - 1] != -1) {
                System.out.println((cat[mon - 1][dis - 2] * 3 + cat[mon - 2][dis - 1] * 2) / 5);
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }

        if (mon == 1 && dis == n) {
            if (cat[0][dis - 2] != -1 && cat[1][dis - 1] != -1) {
                System.out.println((cat[0][dis - 2] * 3 + cat[1][dis - 2] * 2) / 5);
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }

        if (mon == m && dis == 1) {
            if (cat[mon - 1][1] != -1 && cat[mon - 2][0] != -1) {
                System.out.println((cat[mon - 1][1] * 3 + cat[mon - 2][0] * 2) / 5);
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }

        if (mon == 1 && dis >= 2 && dis <= n - 1) {
            if ((cat[0][dis - 2] != -1 || cat[0][dis] != -1) && (cat[0][dis - 2] != -1 || cat[1][dis - 1] != -1) && (cat[0][dis] != -1 || cat[1][dis - 1] != -1)) {
                if (cat[0][dis - 2] == -1) {
                    System.out.println((cat[0][dis] * 3 + cat[1][dis - 1] * 2) / 5);
                } else if (cat[0][dis] == -1) {
                    System.out.println((cat[0][dis - 2] * 3 + cat[1][dis - 1] * 2) / 5);
                } else if (cat[1][dis - 1] == -1) {
                    System.out.println((cat[0][dis - 2] * 2 + cat[0][dis] * 3) / 5);
                } else {
                    System.out.println((cat[0][dis - 2] * 2 + cat[0][dis] * 2 + cat[1][dis - 1]) / 5);
                }
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }

        if (mon == m && dis >= 2 && dis <= n - 1) {
            if ((cat[mon - 1][dis - 2] != -1 || cat[mon - 1][dis] != -1) && (cat[mon - 1][dis - 2] != -1 || cat[mon - 2][dis - 1] != -1) && (cat[mon - 1][dis] != -1 || cat[mon - 2][dis - 1] != -1)) {
                if (cat[mon - 1][dis - 2] == -1) {
                    System.out.println((cat[mon - 1][dis] * 3 + cat[mon - 2][dis - 1] * 2) / 5);
                } else if (cat[mon - 1][dis] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 3 + cat[mon - 2][dis - 1] * 2) / 5);
                } else if (cat[mon - 2][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 2 + cat[mon - 1][dis] * 3) / 5);
                } else {
                    System.out.println((cat[mon - 1][dis - 2] * 2 + cat[mon - 1][dis] * 2 + cat[mon - 2][dis - 1]) / 5);
                }
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }

        if (dis == 1 && mon >= 2 && mon <= m - 1) {
            if ((cat[mon - 2][0] != -1 || cat[mon][0] != -1) && (cat[mon - 2][0] != -1 || cat[mon - 1][1] != -1) && (cat[mon][0] != -1 || cat[mon - 1][1] != -1)) {
                if (cat[mon - 2][0] == -1) {
                    System.out.println((cat[mon - 1][1] * 3 + cat[mon][0] * 2) / 5);
                } else if (cat[mon][0] == -1) {
                    System.out.println((cat[mon - 1][1] * 3 + cat[mon - 2][0] * 2) / 5);
                } else if (cat[mon - 1][1] == -1) {
                    System.out.println((cat[mon - 2][0] + cat[mon][0]) / 2);
                } else {
                    System.out.println((cat[mon - 1][1] * 6 + cat[mon - 2][0] * 7 + cat[mon][0] * 7) / 20);
                }
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }

        if (dis == n && mon >= 2 && mon <= m - 1) {
            if ((cat[mon - 2][dis - 1] != -1 || cat[mon][dis - 1] != -1) && (cat[mon - 2][dis - 1] != -1 || cat[mon - 1][dis - 2] != -1) && (cat[mon][dis - 1] != -1 || cat[mon - 1][dis - 2] != -1)) {
                if (cat[mon - 2][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 3 + cat[mon][dis - 1] * 2) / 5);
                } else if (cat[mon][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 3 + cat[mon - 2][dis - 1] * 2) / 5);
                } else if (cat[mon - 1][dis - 2] == -1) {
                    System.out.println((cat[mon - 2][dis - 1] + cat[mon][dis - 1]) / 2);
                } else {
                    System.out.println((cat[mon - 1][dis - 2] * 6 + cat[mon - 2][dis - 1] * 7 + cat[mon][dis - 1] * 7) / 20);
                }
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }

        if (mon >= 2 && mon <= m - 1 && dis >= 2 && dis <= n - 1) {
            if ((cat[mon - 1][dis - 2] != -1 || cat[mon - 1][dis] != -1 || cat[mon - 2][dis - 1] != -1) && (cat[mon - 1][dis - 2] != -1 || cat[mon - 1][dis] != -1 || cat[mon][dis - 1] != -1) && (cat[mon - 1][dis - 2] != -1 || cat[mon - 2][dis - 1] != -1 || cat[mon][dis - 1] != -1) && (cat[mon - 1][dis] != -1 || cat[mon - 2][dis - 1] != -1 || cat[mon][dis - 1] != -1)) {
                if (cat[mon - 1][dis - 2] == -1 && cat[mon - 1][dis] == -1) {
                    System.out.println((cat[mon - 2][dis - 1] + cat[mon][dis - 1]) / 2);
                } else if (cat[mon - 1][dis - 2] == -1 && cat[mon - 2][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis] * 3 + cat[mon][dis - 1] * 2) / 5);
                } else if (cat[mon - 1][dis - 2] == -1 && cat[mon][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis] * 3 + cat[mon - 2][dis - 1] * 2) / 5);
                } else if (cat[mon - 1][dis] == -1 && cat[mon - 2][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 3 + cat[mon][dis - 1] * 2) / 5);
                } else if (cat[mon - 1][dis] == -1 && cat[mon][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 3 + cat[mon - 2][dis - 1] * 2) / 5);
                } else if (cat[mon - 2][dis - 1] == -1 && cat[mon][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 2 + cat[mon - 1][dis] * 3) / 5);
                } else if (cat[mon - 1][dis - 2] == -1) {
                    System.out.println((cat[mon - 1][dis] * 6 + cat[mon - 2][dis - 1] * 7 + cat[mon][dis - 1] * 7) / 20);
                } else if (cat[mon - 1][dis] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 6 + cat[mon - 2][dis - 1] * 7 + cat[mon][dis - 1] * 7) / 20);
                } else if (cat[mon - 2][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 2 + cat[mon - 1][dis] * 2 + cat[mon][dis - 1]) / 5);
                } else if (cat[mon][dis - 1] == -1) {
                    System.out.println((cat[mon - 1][dis - 2] * 2 + cat[mon - 1][dis] * 2 + cat[mon - 2][dis - 1]) / 5);
                } else {
                    System.out.println((cat[mon - 1][dis - 2] * 3 + cat[mon - 1][dis] * 3 + cat[mon - 2][dis - 1] * 2 + cat[mon][dis - 1] * 2) / 10);
                }
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }
    }
}