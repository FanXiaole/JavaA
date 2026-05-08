//类EnumSet须要提前引入（import）；
import java.util.EnumSet;

public class DirectionTest {
    public static void main(String[] args) {
        //values方法，返回一个Direction类型的数组，它的每一个元素都是Direction类的对象；
        Direction[] directions=Direction.values();

        for(Direction d:directions){
            System.out.println(d);
        }
        System.out.println();

        //EnumSet.range方法相当于构建一个新的数组，它的范围设置为从Direction类的NORTH对象到EAST对象；
        for(Direction d: EnumSet.range(Direction.NORTH,Direction.EAST)){
            System.out.println(d);
        }
    }
}
