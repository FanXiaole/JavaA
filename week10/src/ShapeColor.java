import java.awt.*;

public enum ShapeColor {
    //枚举类名下的三个常量对象，运用构造方法进行声明，他们之间用逗号隔开；
    GREEN("The circle is in the Screen", Color.GREEN),//在屏幕内用绿色表示；
    RED("The circle is not in the Screen", Color.RED),//在屏幕外用红色表示；
    GRAY("Haven't tested", Color.GRAY);//未用check方法测试则用灰色表示；

    //俩属性分别为The description of instance以及The color of instance；
    //用于表述三个常量对象的“指示说明”和“颜色”；
    private String desc;
    private Color color;

    //构造方法，无访问修饰符，为package-private；
    ShapeColor(String desc, Color color) {
        this.desc = desc;
        this.color = color;
    }

    //枚举类名下俩属性的get方法；
    public String getDesc() {
        return this.desc;
    }

    public Color getColor() {
        return this.color;
    }
}

