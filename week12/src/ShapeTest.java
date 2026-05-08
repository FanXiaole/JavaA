import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeTest {
    public static void main(String[] args) {
        //这里的List本身是一个接口类型；
        //ArrayList是它的实现类，基于数组连续存储；
        //LinkedList也是它的实现类，基于链式结构存储；，
        List<Circle> circleList = new ArrayList<>();

        //创建屏幕大小；
        Circle.setScreenSize(14);
        //将屏幕大小同步到StdDraw中去；
        StdDraw.setScale(-Shape.getScreenSize(), Shape.getScreenSize());

        //实例化Circle类型的对象，并填充进List类型的circleList，作为它的每一个元素；
        //原本是按照按照半径大小升序排序；
        for (int i = 0; i < Shape.getScreenSize(); i += 2) {
            circleList.add(new Circle(i, 0, -Shape.getScreenSize()));
        }
        //将circleList变成有序的，实现按照半径大小降序排列；
        Collections.sort(circleList);

        //分别用三套主题颜色绘制同心圆，但由于后者覆盖前者的原因，最后只展现第三套主题颜色的同心圆；
        for(int i=0;i<circleList.size();i++){
            circleList.get(i).customizedColor(ColorScheme.GRAY,i);
        }
        for(int i=0;i<circleList.size();i++){
            circleList.get(i).customizedColor(ColorScheme.SKY,i);
        }
        for(int i=0;i<circleList.size();i++){
            circleList.get(i).customizedColor(ColorScheme.RAINBOW,i);
        }
    }
}