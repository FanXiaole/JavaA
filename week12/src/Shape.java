//这里用到了继承的思想：
//创建父类Shape，使得当子类创建对象时，父类中的成员属性会在子类对象的存储空间中被分配空间；
//故能大大地减少代码的重复和冗余；

//这里父类Shape为抽象类，可以包含字段声明、构造方法、抽象方法和实体方法，但不能用于创建对象；
//原因：倘若通过抽象创建的对象调用了抽象方法，则将不会有任何效果（方法体为空），java程序为了在源头上规避这一点，在创建对象时就会报错；
//注意！非抽象类不能有抽象方法，也就是说一旦一个类中声明了抽象方法，该类就必须被定义为抽象类，原因同上；
public abstract class Shape {
    protected double x;
    protected double y;
    private static int screenSize = 10;
    private ShapeColor color = ShapeColor.GRAY;

    //用手动定义的构造方法去覆盖掉缺省构造方法public Shape(){}
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "x=" + x + ", y=" + y + ", color=" + color;
    }

    //在当前类中，有些方法只需要声明而不需要实现，而下推到子类中再去实现，而这种方法就叫“抽象方法”；
    //抽象方法用关键词“abstract”去声明，书写规则为：只保留方法签名，去除花括号{}和方法体；
    public abstract void checkColor();
    public abstract void draw();

    //一下是字段的get方法和set方法；
    public static int getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(int screenSize) {
        Shape.screenSize = screenSize;
    }

    public ShapeColor getColor() {
        return color;
    }

    public void setColor(ShapeColor color) {
        this.color = color;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}
