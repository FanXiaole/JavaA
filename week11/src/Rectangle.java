public class Rectangle extends Shape {
    //声明字段：
    private double width;
    private double height;

    //构造方法的重载：
    public Rectangle(double x, double y) {
        super(x, y);
    }
    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    //checkColor方法，通过调用isInBoundary方法，将边界内图形设为绿色，边界外图形设为红色；
    public void checkColor() {
        if (isInBoundary()) {
            setColor(ShapeColor.GREEN);
        } else {
            setColor(ShapeColor.RED);
        }
    }

    //isInBoundary方法，基于坐标以及图形参数（半径、长和宽等）判断该图形是否在边界内；
    public boolean isInBoundary() {
        if (-1 * Rectangle.super.getScreenSize() > this.x - this.width / 2 || Rectangle.getScreenSize() < this.x + this.width / 2) {
            return false;
        }
        if (-1 * Rectangle.super.getScreenSize() > this.y - this.height / 2 || Rectangle.getScreenSize() < this.y + this.height / 2) {
            return false;
        }
        return true;
    }

    //toString方法的重写（override），调用父类的toString方法节省代码量；
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height + super.toString() +
                "}\n";
    }

    //draw方法，还是通过调用StdDraw的方法去实现画图功能；
    public void draw() {
        StdDraw.setPenColor(getColor().getColor());
        StdDraw.filledRectangle(x, y, this.width / 2, this.height / 2);
    }
}
