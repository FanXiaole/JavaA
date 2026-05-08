public class EscapeCharacter {
    public static void main(String[] args) {
        float x;
        x = (float) 4 / 3;
        //其中 \" 打出一个双引号；
        System.out.printf("\"%f\"\n", x);
        //其中 \\ 打出一个反斜杠；
        System.out.printf("\\%f\\\n", x);
        //其中 %% 打出一个百分号；
        System.out.printf("%%%f%%\n", x);
    }
}