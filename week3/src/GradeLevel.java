import java.util.Scanner;

public class GradeLevel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int grade, T;
        //用于记录相应成绩个数；
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        while (true) {
            grade = input.nextInt();
            //循环结束条件；
            if (grade == -1) {
                break;
            }
            //很妙！90-99分之间/10的结果均为9，故将它们统一起来了；
            T = grade / 10;
            //switch的应用，case后面只能是一个特定的常量值，值后面记得带上冒号：
            //记得break！否则满足一个case后其他case会被“击穿”：
            //直接执行case主体语句，直到再次遇到break结束switch；
            switch (T) {
                //case语句末尾是冒号；
                case 10:
                    a++;
                    break;
                case 9:
                    a++;
                    break;
                case 8:
                    b++;
                    break;
                case 7:
                    c++;
                    break;
                case 6:
                    d++;
                    break;
                //上述case均未能被满足的剩余情况进入default的主体中执行语句；
                default:
                    e++;
                    break;
            }
        }
        System.out.printf("A: %d\nB: %d\nC: %d\nD: %d\nE: %d\n", a, b, c, d, e);
    }
}
