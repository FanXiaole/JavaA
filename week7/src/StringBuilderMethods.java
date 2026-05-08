public class StringBuilderMethods {
    public static void main(String[] args) {
        //由于String类型的"不可变性"(immutable)，若拼接嵌入循环则会占据大量存储空间；
        //故考虑引入StringBuilder的概念，其最大特点便是"可变性"(mutable)；


        //下面一长串代码是StringBuilder的append方法，用于将特定内容添加在已有字符串的尾巴处：
        String string = "goodbye";
        char[] charArray3 = {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean booleanValue = true;
        char charValue = 'Z';
        int intValue = 7;
        long longValue = 1000000000L;
        float floatValue = 2.5f;
        double doubleValue = 33.3333;
        StringBuilder buffer = new StringBuilder();
        buffer.append(string);
        buffer.append("\n");
        buffer.append(charArray3);
        buffer.append("\n");
        //左闭右开，[0,3),下标分别为0,1,2；
        buffer.append(charArray3, 0, 3);
        buffer.append("\n");
        buffer.append(booleanValue);
        buffer.append("\n");
        buffer.append(charValue);
        buffer.append("\n");
        buffer.append(intValue);
        buffer.append("\n");
        buffer.append(longValue);
        buffer.append("\n");
        buffer.append(floatValue);
        buffer.append("\n");
        buffer.append(doubleValue);
        buffer.append("\n");
        System.out.print(buffer.toString());


        //下面介绍StringBuilder的其他实用方法：

        StringBuilder s = new StringBuilder("hello world");
        //toString方法，返回SB的字符串格式；
        System.out.println(s.toString());
        //capacity方法，返回SB的容量（基础容量为16）；
        System.out.println(s.capacity());
        //charAt方法，返回SB特定下标对应字符；
        System.out.println(s.charAt(0));
        //length方法，返回SB的长度；
        System.out.println(s.length());
        //substring方法，返回SB一串子字符串；左闭右开[0,5);
        System.out.println(s.substring(0, 5));


        s = new StringBuilder("hello world");
        //deleteCharAt方法，将SB特定下标对应字符删去；
        System.out.println(s.deleteCharAt(0));


        s = new StringBuilder("hello world");
        //reverse方法，将SB倒置；
        System.out.println(s.reverse());


        s = new StringBuilder("hello world");
        //setCharAt方法，将SB特定下标对应字符进行更换；
        s.setCharAt(0, 'e');
        System.out.println(s);


        s = new StringBuilder("hello world");
        //replace方法，将SB一串子字符串进行更换；
        System.out.println(s.replace(0, 5, "HELLO"));


        s = new StringBuilder("hello world");
        //insert方法，在SB特定下标前面插入一串字符串；
        System.out.println(s.insert(0, "bro, "));
        s = new StringBuilder("hello world");
        char[] c = {'a', 'b', 'c', ' '};
        //在SB特定下标前插入一段char类型数组；
        System.out.println(s.insert(0, c));


        s = new StringBuilder("hello world");
        //在SB下标0之前插入char类型数组c的一部分：c从下标1开始，读取到长度为3为止；
        System.out.println(s.insert(0, c, 1, 3));
    }
}
