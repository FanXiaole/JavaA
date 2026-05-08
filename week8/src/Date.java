public class Date {

    //Date为一个类名，它包含三个属性，分别是month、day、year；
    //注意：这三个属性不是只有一份的，每个Date类名下的对象均具备这三个属性；


    //这里在没赋初值前基本数据类型int、long、double、及它们数组的默认初始值为0，boolean默认值为false，char默认值为空字符；
    private int month;
    private int day;
    private int year;


    //声明构造方法，方法名就是类名（Date），用于直接访问三个private属性并赋值；
    public Date(int theMonth, int theDay, int theYear) {
        //这里嵌套checkMonth、checkDay方法，用于使传入数据生效（validation）；
        month = checkMonth(theMonth);
        day = checkDay(theDay);
        year = theYear;


        //这里this相当于调用“直接方法”toString；
        //返回类型一定要与%s中的s（String）相对应；这也是this能在同一类名下跳转到toString方法的原因；
        System.out.printf("Date object constructor for date is: %s\n", this);
    }


    //注意到方法类型是private的，为了确保方法的隐蔽性；
    //仅同一类名下的方法能够直接访问此方法，其他类名下无法直接访问；
    //若其他类名下想访问此方法，需要先通过调用一个public方法建立一个桥梁；
    //进而进到与private方法同一类名下，再对其进行间接访问；
    private int checkMonth(int testMonth) {
        if (testMonth > 0 && testMonth <= 12) {
            //valid;
            return testMonth;
        } else {
            //invalid;
            System.out.printf("Invalid month (%d), set to 1", testMonth);
            return 1;
        }
    }


    //check方法作用是使数据生效（validation）；
    private int checkDay(int testDay) {
        int[] daysOfMonth = {
                //数组下标0无作用设为0，下标1到12分别代表12个月对应天数；
                //大月为1、3、5、7、8、10、12；
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
        if (testDay > 0 && testDay <= daysOfMonth[month]) {
            return testDay;
        }


        //闰年2月份29天的情况在上一个if语句中被判断为false，故需要一个else if来涵盖
        //闰年的定义是：（能被4整除且不能被100整除）或者（能被400整除）；
        else if (month == 2 && testDay == 29 && (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return 29;
        } else {
            System.out.printf("Invalid day (%d), set to 1", testDay);
            return 1;
        }
    }


    //返回一个格式化、规范化的字符串；
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}
