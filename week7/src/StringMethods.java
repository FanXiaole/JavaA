public class StringMethods {
    public static void main(String[] args) {

        //下面为栈和堆以及String这一个参考类型（reference type）的基本概念：
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String("Java");
        //s1和s2指向堆里同一个存储空间，两者的地址一致，故输出true；
        System.out.println(s1 == s2);
        //s3和s4分别在堆里开辟了一个存储空间，两者虽然内容一致，但是地址不同，故输出false；
        System.out.println(s3 == s4);

        //length方法，获取字符串的长度：
        //String类型具有其不变性，即s1只是指向了另一个堆里的存储空间，其地址更新了，但原存储空间不变；
        s1 = "hello world";
        //这里俩引号之间的任何空格也会被算进长度里面去；
        System.out.printf("%d\n", s1.length());

        //此构造方法，能够将数组转化为字符串：
        char[] charArray = {'h', 'e', 'l', 'l', 'o'};
        //offset表示开始检索（retrieving）的下标，count表示字符的个数；
        //这里会输出：lo；
        String s5 = new String(charArray, 3, 2);
        System.out.println(s5);


        //以下四种方法为对针对字符串的提取方法：

        //charAt方法，锁定、读取并返回特定下标对应的字符：
        for (int count = s1.length() - 1; count >= 0; count--) {
            System.out.printf("%c", s1.charAt(count));
        }
        //这里将倒序输出字符串；
        System.out.println();


        //substring方法，提取一段子字符串：
        String s = "absdefghijklmabcdefghijklm";
        //取出下标20处开始往后一直到结尾的字符串，输出：hijklm；
        System.out.println(s.substring(20));
        //注意左闭右开，[3,6)即取出从下标3到下标5的字符串，输出：def；
        System.out.println(s.substring(3, 6));


        //getChars方法，为取出字符串中一连串字符组成char类型数组：
        char[] charArray1 = new char[6];
        //括号里依次为：字符串开始检索下标，结束检索下标，装载数组，数组起始赋值位置；
        //注意是左闭右开：即[0,5)，检索下标0,1,2,3,4对应字符：即为‘h'，‘e’，‘l’，‘l’，‘o’；
        s1.getChars(0, 5, charArray1, 1);
        for (char e : charArray1) {
            System.out.print(e);
        }
        //数组下标为0的位置未被赋值，故该位置输出一个类似于长方形加一斜杠的东西；
        System.out.println();


        //toCharArray方法，同样能够将字符串转化为数组：
        s1 = "hello";
        //先将字符串拆分为多个字符，再将字符赋值到对应下标的数组元素头上去；
        char[] charArray2 = s1.toCharArray();
        for (char e : charArray2) {
            System.out.print(e);
        }
        System.out.println();


        //接下来介绍字符串之间进行比较的方法：

        //equals方法，用于判断俩字符串的地址是否相同；
        //与原始数据类型例如int不同，参考类型String的衡量标准为“地址”而非“具体内容”；
        //即纵使s1和s2的具体内容相同，它们俩的地址不同，这里仍然会被判断为false；
        s1 = "Hello World";
        s2 = s1 + "";
        if (s1.equals(s2)) {
            System.out.println("s1=s2");
        }


        //equalsIgnoreCase方法，相当于不区分大小写的equals方法；
        s1 = "hello";
        s2 = "HELLO";
        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("s1=s2");
        }


        //compareTo方法，对字符串的差值进行返回，体现两者大小；
        //实际上比较的是字符在“Unicode Table”（十六进制）中对应的编号，并转换为十进制作差；
        //通常上讲，针对同一个字母而言它大写的编号<小写的编号；

        //具体规则（优先级）如下：
        //先比较首字母，若不同则直接出结果；
        //若相同则比较下一个字母，以此类推；
        //若俩字符串为包含关系，则长度更长者更大；

        //针对s1.compareTo(s2)：
        //若返回的差值大于0，则说明s1对比s2要更大；
        //若返回差值<0,则说明s1<s2；
        s1 = "hello";
        s2 = "HELLO";
        System.out.println(s1.compareTo(s2));
        //输出32（十进制）=0068（十六进制）-0048（十六进制）；
        s1 = "HE";
        s2 = "HELLO";
        System.out.println(s1.compareTo(s2));
        //输出-3，表示s2比s1多出三个字符的长度；


        //接下来是对字符串中特定字符的检索方法：

        //startsWith和endsWith方法，判断前缀（prefix）或者后缀（postfix）：
        s1 = "Hello World";
        //下标0处（最开始）向右检索；输出true
        if (s1.startsWith("He")) {
            System.out.println("true");
        }
        //下标2处向右检索；输出true；
        if (s1.startsWith("llo", 2)) {
            System.out.println("true");
        }
        //下标s1.length-1（尾巴）处向左检索；输出true；
        if (s1.endsWith("ld")) {
            System.out.println("true");
        }


        //indexOf和lastIndexOf方法，找寻特定字符或字符串出现的下标：
        s = "absdefghijklmabcdefghijklm";
        //从头（下标0处）开始检索，找到第一次出现该字符的下标，输出2；
        System.out.println(s.indexOf('c'));
        //检索完整个字符串没找到该字符，故输出-1；
        System.out.println(s.indexOf('$'));
        //从下标1处开始检索，输出13；
        System.out.println(s.indexOf('a', 1));
        //从尾巴处往前检索，找到第一次遇见该字符的下标，输出15；
        System.out.println(s.lastIndexOf('c'));
        //找不到该字符，故输出-1；
        System.out.println(s.lastIndexOf('$'));
        //从下标8处开始往左检索，输出0；
        System.out.println(s.lastIndexOf('a', 8));
        //从头开始向右检索，找到相同字符串，返回首字符d的下标，输出3；
        System.out.println(s.indexOf("def"));
        //从下标7处开始向右检索，找到相同字符串，返回首字符d的下标，输出16；
        System.out.println(s.indexOf("def", 7));
        //检索完整仍然找不到该字符串，输出-1；
        System.out.println(s.indexOf("hello"));
        //从尾巴处开始想左检索，找到一致字符串，返回首字符d对应下标，故输出16；
        System.out.println(s.lastIndexOf("def"));
        //从下标7处开始向左检索，输出3；
        System.out.println(s.lastIndexOf("def", 7));
        //找不到输出-1；
        System.out.println(s.lastIndexOf("hello"));


        //下面三个方法是针对字符串的修饰与更改：

        //replace方法，实现对特定字符或字符串的替换：
        s1 = "Hello";
        //括号内左侧为原字符或字符串，右侧为现字符或字符串；
        //可以将“原”和“现”之间的逗号理解为向右的箭头，意思是“指向”“替换成”；
        //注意！该方法将检索一整个大字符串，将每一处原字符或字符串均替换为现字符或字符串；
        System.out.println(s1.replace('l', 'L'));
        System.out.println(s1.replace("ll", "LL"));


        //toUpperCase和toLowerCase方法，用于大小写转换：
        //全部升大写：输出HELLO；
        System.out.println(s1.toUpperCase());
        //全部降小写：输出hello；
        System.out.println(s1.toLowerCase());


        //trim方法用于去空格，使精简化：
        s1 = " spaces ";
        //将双引号之间的空格全部抹去，输出spaces；
        System.out.println(s1.trim());


        //下面两个方法能够在不修改原有字符串基础上对其进行分割或拼接：

        //split方法能够识别空格并将不同单词分隔开来，并给到数组中去：
        String sentence = "You are pretty";
        //一旦识别到“ ”即空格符，就分割开来，数组每个元素之间都是分隔开来的；
        String[] tokens = sentence.split(" ");
        for (String e : tokens) {
            System.out.println(e);
        }


        //concat方法用于将两个字符串进行拼接：
        s1 = "Happy";
        s2 = "Birthday";
        //这里指将s2拼接到s1右边上去，输出：HappyBirthday；
        System.out.println(s1.concat(s2));
        //这里需要说明，s1和s2并未被修改，仅是拼接出一个全新的s=s1+s2；
    }
}
