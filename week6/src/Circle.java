//一个类里面包含多种属性；
//比方说对于一辆车而言，“colour""size""speed"就是它的属性；
public class Circle {

    //区分public和private两种访问修饰符（access modifier）：
    //public定义的变量能在不同类名下直接访问；
    //private定义的变量仅能在同一类名下直接访问，在不同类名下访问会失效（用于保护信息安全）；

    //区分静态属性（static variable，也叫静态变量）和实例属性（instance variable，也叫成员变量）；
    //静态变量在同一个类名下只有一个存储空间，故它的改变会导致所有对象的该静态属性改变；
    //实例变量每创建一个对象都可以有一个存储空间，更改某一对象的实例变量对其他对象的实例变量没有影响；

    //静态变量对比实例变量的优势在于其寿命更长；
    //静态变量随着类的存活而存活；
    //实例变量随着对象的存活而存活；
    //故当无对象时，静态变量仍存活，而实例变量却死了；

    private static int count = 0;

    private double radius;
    private double x;
    private double y;
    private int id;


    //方法由head和body构成；
    //head的（）中为形参（parameter），类似于完成body部分所需要提前准备的“材料”；
    //body用{}来框起来；

    //radius这一变量无非就两种形式：一是属性radius，二是参数radius；
    //属性radius是全局变量（local variable），同一个类名下的成员方法均可以直接访问；
    //参数radius是局部变量（instance variable），仅在该方法内可以使用；

    //Constructor的特点为1.无返回值，2.方法名与类名完全一致（这里为Circle）；
    //当一个类（这里是Circle）没有声明构造方法时，它会自带一个缺省构造方法：public Circle(){}；
    //而一旦声明了构造方法后，缺省构造方法会被覆盖掉；
    public Circle(double radius, double x, double y) {
        count++;
        this.id = count;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }


    //区分以下两种类型的方法：
    //静态方法：由类名去调用，只能访问静态属性，不能直接访问成员属性，能够调用静态方法，但无法直接调用成员方法；
    //成员方法：由对象去调用，可以访问静态属性，也可以调用静态方法，当然也可以访问和调用成员属性和成员方法；

    //静态方法无法直接访问成员变量和方法的原因是：
    //静态方法由类名去调用（即使无对象也可以调用），故此时程序不知道其访问的成员属性是属于哪个对象的，产生歧义；

    //在静态方法中是可以通过对象来调用成员方法的！必须要有对象才能进行调用！！！
    public static void setCount(int count) {
        //注意！这里用类名去赋值而不用对象去赋值，因为静态属性count对于同一类名下的所有对象均是一致的；
        Circle.count = count;
    }


    //get方法作用是读取并且返回属性radius的值；
    public double getRadius() {
        return radius;
    }

    //方法名setRadius首字母小写，后续用大写字母区分不同单词；
    //set方法作用是通过方法调用给属性radius赋初值或更新值；
    public void setRadius(double radius) {
        //当全局变量与局部变量重名时，在局部作用范围内，该重名变量均表示局部变量；
        //即此时全局变量被局部变量给覆盖掉了，称为“Shadowing”；
        //那我们该如何从在局部作用范围内找到（凸显）属性变量呢？
        //我们需要用到关键词this来实现这一需求；

        //给属性（成员变量）的赋值设置条件，使得属性的值是合情合理的；
        //例如，属性radius的值不能为-1，因为世界上不存在半径为-1的圆；
        if (radius > 0) {
            //通过颜色观察到：
            //等号右边的radius与方法head括号里的radius均为白色，它们都是局部变量；
            //而等号左边的radius和创建属性（成员变量）时的radius均标紫色，它们都是全局变量；
            this.radius = radius;
        }
        //body结束后，局部radius的值会被释放；
    }

    //即使属性radius、x和y都是private的，同一个类名（class name）下成员方法都是具有访问权限的，可以直接使用；
    public double area() {
        return radius * radius * Math.PI;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    //void表示该方法不用返回任何值；
    public void position() {
        System.out.printf("Position of the circle is (%.1f,%.1f)\n", x, y);
    }
}
