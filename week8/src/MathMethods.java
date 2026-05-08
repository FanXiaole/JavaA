public class MathMethods {
    public static void main(String[] args) {
        //类名Math下面的方法都是public且static的；
        //意味着你可以在不同的类名下对这些方法进行调用；
        //调用方式为：类名.方法名；


        //一下为一些Math类的常用方法：

        System.out.println(Math.PI);//取π，输出3.141592653589793；
        System.out.println(Math.E);//取e，输出2.718281828459045；


        System.out.println(Math.sqrt(9));//开平方根，输出3.0；
        System.out.println(Math.abs(-23));//取绝对值（absolute），输出23；
        System.out.println(Math.ceil(9.2));//向上取整（ceiling天花板），输出10.0
        System.out.println(Math.ceil(-9.8));//输出-9.0；
        System.out.println(Math.floor(9.2));//向下取整（floor地板），输出9.0；
        System.out.println(Math.floor(-9.8));//输出-10.0；


        System.out.println(Math.exp(2));//取e指数，输出7.38905609893065；
        System.out.println(Math.log(Math.E * Math.E));//取e对数，输出2.0；
        System.out.println(Math.pow(2, 7));//取左边作为底数，右边作为指数，输出128.0（2的7次方）；


        System.out.println(Math.max(1, 2));//取出两者中较大者，输出2；
        System.out.println(Math.min(1, 2));//取出两者中较小者，输出1；


        System.out.println(Math.sin(0));//取sin值，输出0.0；
        System.out.println(Math.cos(0));//取cos值，输出1.0；
        System.out.println(Math.tan(0));//取tan值，输出0.0；
    }
}
