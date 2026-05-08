public class StringValueOf {
    public static void main(String[] args) {

        //由于基本数据类型无法像对象那样调用toString方法；
        //故下面介绍的valueOf方法是String类名下的静态方法；
        //用于将不同类型的变量转换为String类型并返回；

        boolean booleanValue = true;
        char charValue = 'Z';
        int intValue = 7;
        long longValue = 10000000000L;
        float floatValue = 2.5f;
        double doubleValue = 33.3333;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(String.valueOf(booleanValue));//true;
        System.out.println(String.valueOf(charValue));//Z;
        System.out.println(String.valueOf(intValue));//7;
        System.out.println(String.valueOf(longValue));//10000000000;
        System.out.println(String.valueOf(floatValue));//2.5;
        System.out.println(String.valueOf(doubleValue));//33.3333;
        System.out.println(String.valueOf(charArray));//abcdef;
    }
}
