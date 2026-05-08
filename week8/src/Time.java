public class Time {

    //创建三个private类型的属性，分别代表时间中的时、分、秒；
    private int hour;
    private int minute;
    private int second;


    //以下为一系列针对不同传参的构造方法，利用方法重载：
    public Time(int h, int m, int s) {
        //“直接方法"setTime前无需声明对象，因为其对象默认为调用“间接方法”Time1的对象；
        setTime(h, m, s);
    }

    public Time(int h, int m) {
        //this用于调用位于同一类名下另一个构造方法，这使得用于初始化的代码得以充分利用；
        //注意到调用的方法要符合传参数量和类型的；
        this(h, m, 0);
    }

    public Time(int h) {
        //仅传入一个参数h，其余默认为0；
        this(h, 0, 0);
    }

    public Time() {
        //无传参，全部默认为0；
        this(0, 0, 0);
    }

    public Time(Time time) {
        //注意到这里传入的参数为一个对象；
        //分别获取该对象的三个属性作为参数传递给this调用的构造方法中去；
        this(time.getHour(), time.getMinute(), time.getSecond());
    }


    //set方法：用于访问属性并对其设初值或更新（modify）；
    public void setTime(int h, int m, int s) {
        //相当于方法嵌套概念：
        //setTime方法是“间接方法”，它用于援引并执行“直接方法”；
        //setHour、setMinute、setSecond是“直接方法”，它用于直接访问private属性；
        setHour(h);
        setMinute(m);
        setSecond(s);
    }

    public void setHour(int h) {
        //这里局部变量和全局变量不重叠，故无需使用关键词this来找到全局变量；
        hour = ((h >= 0 && h < 24) ? h : 0);
    }

    public void setMinute(int m) {
        //“if-else”语句的简易版形式；
        minute = ((m >= 0 && m < 60) ? m : 0);
    }

    public void setSecond(int s) {
        //若内部括号内语句判断为true，则返回冒号（:）左边的值，为false返回冒号右边的值；
        second = ((s >= 0 && s < 60) ? s : 0);
    }


    //get方法：用于检索（retrieving）字段（field）并返回；
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }


    //toUniversalString方法，将时间转换为通用时间格式并返回；
    public String toUniversalString() {
        //String.format类似于printf，将字符串格式化、规范化；
        //%02d为“格式控制符”，设置俩整数位，若实际整数位仅一位，则在该数前补0填满两个整数位；
        //同一类名下方法能够直接访问private类型的成员变量；
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }


    //程序会自带一个toString方法，但是这里我们要修改（modify）toString方法，将时间转换为标准时间格式并返回；
    public String toString() {
        //区分String.format和printf：
        //String.format用于生成一串字符串用于后续返回（无输出功能）；
        //而printf则是生成一串字符串并且进行输出；
        return String.format("%d:%02d:%02d %s",
                (getHour() == 0 || getHour() == 12) ? 12 : getHour() / 12, getMinute(), getSecond(), (getHour() < 12) ? "AM" : "PM");
    }


    //对比“直接方法”和“间接方法”：
    //注意到，纵使三个属性在方法内是可以直接访问的，我们还是用了get方法：
    //先搞清楚，get方法和set方法均为“直接方法”，而toUniversalString和toString方法为“间接方法”；
    //“直接方法”能够直接访问同一类名下的private属性，而“间接方法”则是通过调用“直接方法”间接访问private属性；
    //当private属性被更改数据类型时（例如int->数组），只用修改“直接方法”即可，而”间接方法“可以不做更改；
    //这就是在“间接方法”中使用“直接方法”而不去直接访问private变量的原因：
    //一是可以充分利用已有代码，二是大大节省方法修改的幅度；
}

