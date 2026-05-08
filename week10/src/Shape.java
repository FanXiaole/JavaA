//这里用到了继承的思想：
//创建父类Shape，使得当子类创建对象时，父类中的成员属性会在子类对象的存储空间中被分配空间；
//故能大大地减少代码的重复和冗余；

public class Shape {
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
}
