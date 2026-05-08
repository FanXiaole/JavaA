public class TimeTest {
    public static void main(String[] args) {

        //创建一个Time1的对象（存储在栈里），并指向一个包含三个属性的存储空间（存储在堆里）；
        Time time = new Time();


        //在不同类名下访问其他类名下private属性的工作原理：
        //先调用一个public类型的方法（这里是setTime）；
        //该方法和想访问的private属性（hour、minute、second）处于同一类名下面；
        //故进入方法体中便可以访问位于同一类名的private属性了；
        //总结其本质就是间接调用而非直接调用，public方法在其中充当“桥梁”的作用；
        time.setTime(13, 27, 6);


        //利用对象time调用不同方法；
        System.out.print("Universal time after setTime is: ");
        System.out.println(time.toUniversalString());
        System.out.print("Standard time after astTime is: ");
        //这里默认time.toString方法；
        System.out.println(time);


        //针对不同传参方式进到不同的间接构造方法中；
        Time t1 = new Time(13, 27, 6);
        Time t2 = new Time(21, 34);
        Time t3 = new Time(2);
        Time t4 = new Time();
        Time t5 = new Time(t4);


        System.out.println(t1.toUniversalString());//13:27:06
        System.out.println(t2.toUniversalString());//21:34:00
        System.out.println(t3.toUniversalString());//02:00:00
        System.out.println(t4.toUniversalString());//00:00:00
        System.out.println(t5.toUniversalString());//00:00:00
    }
}
