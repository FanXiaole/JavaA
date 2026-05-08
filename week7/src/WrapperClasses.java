public class WrapperClasses {
    public static void main(String[] args) {

        //java中有八个基本数据类型：boolean，char，double，float，byte，short，int，long；
        //其中int的包装类名为Integer，char的包装类名为Character；
        //其余六个的包装类名均为首字母大写形式；

        //包装的效果是可将类名后变量视为“对象”，如此便可以引用方法对其进行一系列操作；
        //方法调用规则为类名（包装类）+方法名：

        //下面为一些包装类的方法：
        //其中Character.isJavaIdentifierStart指判断是否能作为java标识符的开头？（仅字母，下划线和￥能判断为true）；
        //其中数字转大小写仍然是其本身；

        char c1 = 'A';
        System.out.println(Character.isDigit(c1));
        System.out.println(Character.isJavaIdentifierStart(c1));
        System.out.println(Character.isLetter(c1));
        System.out.println(Character.isLowerCase(c1));
        System.out.println(Character.isUpperCase(c1));
        System.out.println(Character.toLowerCase(c1));
        System.out.println(Character.toUpperCase(c1));
        //输出为：
        //false；
        //true；
        //true；
        //false；
        //true；
        //a；
        //A；
        System.out.println();


        char c2 = '7';
        System.out.println(Character.isDigit(c2));
        System.out.println(Character.isJavaIdentifierStart(c2));
        System.out.println(Character.isLetter(c2));
        System.out.println(Character.isLowerCase(c2));
        System.out.println(Character.isUpperCase(c2));
        System.out.println(Character.toLowerCase(c2));
        System.out.println(Character.toUpperCase(c2));
        //输出为：
        //true；
        //false；
        //false；
        //false；
        //false；
        //7；
        //7；


        //包装类Integer的方法parseInt能够将括号内的字符串解析为数字并返回；
        //倘若括号内字符串含有非数字字符，则程序将会报错；
        int n = Integer.parseInt("123456789");
        System.out.println(n);
    }
}
