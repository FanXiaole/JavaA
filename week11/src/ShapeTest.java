import java.util.ArrayList;

public class ShapeTest {
    public static void main(String[] args) {
        Shape.setScreenSize(9);
        StdDraw.setXscale(-Shape.getScreenSize(), Shape.getScreenSize());
        StdDraw.setYscale(-Shape.getScreenSize(), Shape.getScreenSize());

        //若用两个for循环分别实现对每一个圆形或矩形的遍历，并对它们实行check方法和draw方法；
        //如果再来一个“三角形”的list，则还要写一个for循环，这样的话代码量会直线型上升；
        //于是我们考虑引入“多态”；

        //核心概念：叫做“由子类去实例化父类的引用”或“由父类去引用子类的实例化”；
        //左边为声明类型，为父类Shape；而右边为实际类型，为子类Circle或Rectangle；
        //顺序不能搞反，因为：子类一定也是父类，而父类不一定是子类；

        //shapes为ArrayList类型，而它的每一个元素均为均为父类Shape类型；
        //如此，我们不用每一种图形（例如圆、矩形、三角形）都创建一个元素为子类类型的list，而是所有图形都涵盖在元素为父类类型的list中；
        ArrayList<Shape> shapes=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            //直接由子类去创建对象并加入到ArrayList中去；
            shapes.add(new Circle(1, 4 * i + 1, 1));
            shapes.add(new Rectangle(4 * i + 1, -1, 1,1));
        }

        //遍历每一个图形，并对它们实行check方法和draw方法；
        for(Shape s:shapes){
            //这里check方法和draw方法均在子类中有重写（要求方法签名一致），故利用“动态绑定”，基于实际类型执行方法；
            s.checkColor();
            System.out.print(s);
            s.draw();
        }
    }
}
