//枚举类的特征：类的所有对象在声明类的时候就已经确定了；
//即枚举具有它的有限性和确定性；
//枚举类的应用：类与类之间的组合（composition），即一个类的属性也可以是另一个类的对象；
public enum Direction {
    //枚举类的实例要求以全部大写形式命名，不同实例之间用逗号隔开；

    //注意！这里对象的声明中需要对构造方法进行传参
    NORTH(-1,0),SOUTH(1,0),EAST(0,1),WEST(0,-1);

    //Direction类下对象的属性；
    private int row;
    private int col;

    //构造方法：
    Direction(int row, int col){
        this.row=row;
        this.col=col;
    }

    public String toString(){
        //name()表示调用该方法的枚举类下的对象名字，它为String类型；
        return String.format("%s (%d, %d)",this.name(),this.row,this.col);
    }
}
