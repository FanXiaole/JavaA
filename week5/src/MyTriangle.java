public class MyTriangle {
    //命名规则：修饰符+回传类型+方法名+形式参数；
    //方法签名：方法名+形参类型；
    //方法重载：要求方法签名必须有所差异，否则会报错编译错误；

    //法1：海伦公式；
    public static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    //法2：正弦定理；
    public static double area(double a, double b, int angleOfAB) {
        //Math用于引用键盘上没有的所需计算方法；
        double sin = Math.sin(angleOfAB / 180.0 * Math.PI);
        return a * b * sin / 2;
    }

    //法3：底乘高除2；
    public static double area(double bottom, double height) {
        return bottom * height / 2;
    }

    public static void main(String[] args) {
        //3,4,5为实参arguments，分别于形参对应；
        //这里不同实参类型对应不同方法签名中形参类型，故跳转至不同方法中去；
        double num1 = area(3, 4, 90);
        double num2 = area(3.0, 4.0, 5.0);
        double num3 = area(4, 5);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}
