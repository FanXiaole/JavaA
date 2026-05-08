public class ExportType {
    public static void main(String[] args) {
        int number1 = 4;
        int number2 = 3;
        //println和print括号内可以是字符串也可以是数字，它们之间用+来连接；
        System.out.println("number1+number2=" + number2 + number1);
        System.out.println("number1+number2=" + (number2 + number1));
        System.out.print("number1+number2=" + number2 + number1);
        System.out.println();
        System.out.print("number1+number2=" + (number2 + number1));
        System.out.println();
    }
}
