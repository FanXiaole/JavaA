import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        //of为天数计数器；
        int of = 0;
        //判断输入年份是否为闰年；
        //闰年的判断规则：能被4整除且不能被100整除，或者能被400整除；
        //优先级：&& > ||，故这里等式右边第一个括号可以加可以不加，不影响结果；
        boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        for (int i = 1; i < month; i++) {
            //大月；
            if ((i < 8 && i % 2 == 1) || (i > 7 && i % 2 == 0))
                of += 31;
                //2月特殊考虑；
            else if (i == 2)
                //闰年的2月有29天，而平年的2月只有28天；
                if (leap)
                    of += 29;
                else
                    of += 28;
                //小月；
            else
                of += 30;
        }
        //最后别忘了把天数给加上；
        of += day;
        System.out.println(of);
    }
}