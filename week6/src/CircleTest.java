//一个文件里只能写一个public class，并且文件名要与public class的名字保持一致；
public class CircleTest {
    //main方法本身就是一个静态方法；
    public static void main(String[] args) {

        //其中c1和c2均为Circle的对象（object），可类比Scanner in=...；in.next()... ;
        //其中new为一个keyword，表示对象是新创造的，Circle为类名（class name）；
        //此构造方法作用为在堆里开辟一个存储空间，用于存放对象的属性值，对象指向各自的存储空间；
        //如下，对象c1和c2（储存在栈stack里）分别指向一个同时包含radius和x和y三个属性的存储空间（储存在堆heap里）；
        Circle c1 = new Circle(1, 2, 3);
        Circle c2 = new Circle(4, 5, 6);
        //说明！在Circle类中构造方法已被声明，故缺省构造方法被覆盖，这里创建对象时必须传递参数，否则程序会报错；


        //由于属性radius是private的，在不同类名下，代码c1.radius=3因无法获取访问权限而失效；
        //故用public方法setRadius给c1和c2中的radius属性赋值或更新；
        c1.setRadius(-1);
        c2.setRadius(3);


        //由于属性radius是private的，在不同类名下，代码c1.radius无法获取访问权限失效；
        //故用public方法getRadius读取并返回属性radius的值；
        System.out.println(c1.getRadius());
        System.out.println(c2.getRadius());
    }
}

