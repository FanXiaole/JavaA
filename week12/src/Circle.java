import java.awt.*;

//用extends声明，Circle是Shape的子类；
//implements声明，Circle是Comparable<>的实现类；
//尖括号中的Circle表明该类对象的比较对象是Circle类的对象，即圆和圆依据半径作比较；
//注意！一个子类只能继承一个父类（一个儿子只能有一个父亲），但是一个实现类可以实现多个接口；
public class Circle extends Shape implements Comparable<Circle>, ColorDraw {

    //Circle子类的字段继承了Shape父类的共有属性，同时具备自己特有的属性；
    //故字段省略掉继承的属性的声明，仅保留自身特有属性的声明；
    private final double radius;
    //静态变量，每一个类仅有一个存储空间，该类名下所有对象共享这一个静态变量；
    //final关键词使得变量一旦被赋值就不能被改变了；
    static final int DEFAULT_RADIUS = 5;

    //父类的构造方法无法被子类继承，因为子类一定会有它的特殊的字段需要被构造；
    //子类继承父类时，一定要在构造方法的第一行用super去调用父类的构造方法，因为继承的变量应该首先被构造；
    //倘若第一行无super关键词，子类会自动调用父类的缺省构造方法，倘若缺省构造方法被覆盖掉了，程序会报错；
    public Circle(double radius, double x, double y) {
        super(x, y);
        this.radius = radius;
    }

    //构造方法的重载，调用时根据“方法签名”来决定要跳转进哪一个方法体中去；
    //其中“方法签名”包含方法名、传参个数与类型，不包含返回类型；
    public Circle(double radius) {
        super(0, 0);
        this.radius = radius;
    }
    public Circle(double x, double y) {
        super(x, y);
        this.radius = DEFAULT_RADIUS;
    }

    public void checkColor() {
        //子类中无setColor方法，故写不写super无所谓，默认调用父类的set方法；
        if (isInBoundary()) {
            super.setColor(ShapeColor.GREEN);
        } else {
            setColor(ShapeColor.RED);
        }
    }

    public boolean isInBoundary() {
        //ScreenSize是父类中private类型的，需要调用public的get方法去间接访问；
        //而x和y是protected类型的，在同一个包，或者子类中可以直接访问；
        if (-1 * Circle.getScreenSize() > x - this.radius || Circle.getScreenSize() < x + this.radius) {
            return false;
        }
        return !(-1 * Circle.getScreenSize() > y - this.radius) && !(Circle.getScreenSize() < y + this.radius);
    }

    @Override
    //子类toString方法的重写；
    //类比关键词this，翻译为“我（对象）的某某某（方法或属性）”;
    //通过关键词super，翻译为“我（对象）的父类的某某某（方法或属性）”，这里进入到父类的toString方法中去；
    //倘若去掉super关键词，则会无限套娃“自己调用自己”，最终导致“栈溢出”而运行失败；
    public String toString() {
        return "Circle{" +
                "radius=" + radius + super.toString() +
                "}\n";
    }

    //draw方法，用于设定颜色以及坐标半径，在页面上画图；
    public void draw() {
        //super.getColor()获取ShapeColour类型的对象；
        //super.getColor().getColor()获取该对象的Color类型的属性；
        //这里其实写不写super无所谓，因为在子类没有get方法的情况下，是直接默认调用父类的get方法的；
        StdDraw.setPenColor(super.getColor().getColor());
        StdDraw.filledCircle(x, y, radius);
    }

    //compareTo方法的重写，或者说实现，实体化；
    //这样才能履行完implements合同，使得Circle类能够被声明为实体类；
    @Override
    public int compareTo(Circle o) {
        if(this.radius<o.radius){
            return 1;
        }else if(this.radius>o.radius){
            return -1;
        }
        return 0;
    }

    @Override
    public void customizedColor(ColorScheme colorScheme, int index) {
        //用Color类型的数组colorList去承接传进来的colorScheme
        Color[] colorList = colorScheme.getColorScheme();
        //对index做一定处理；
        if (index < 0){
            index = 0;
        }
        if (index >= colorList.length){
            index = index % colorList.length;
        }
        StdDraw.setPenColor(colorList[index]);
        StdDraw.filledCircle(super.getX(), super.getY(), radius);
    }
}
