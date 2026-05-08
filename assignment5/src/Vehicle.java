//抽象类Vehicle为父类，其子类为Car和Bus；
public abstract class Vehicle {
    protected String plateNumber;
    protected boolean isInside=false;
    protected Time arriveTime=null;

    //字段previousTime用于记录该车辆累计停车时间；
    protected int previousTime=0;

    public Vehicle(String plateNumber){
        this.plateNumber=plateNumber;
    }

    //检索字符串首字母，若为A，则类名为Car，否则（首字母为B）类名为Bus；
    public String toString(){
        return String.format("%s %s %s",(plateNumber.charAt(0)=='A')?"Car":"Bus",plateNumber,isInside);
    }

    //一旦调用到此方法，说明车停进停车场了，将isInside设置为true；
    public void setArriveTime(Time arriveTime){
        this.arriveTime=arriveTime;
        isInside=true;
    }

    //这里calculateMoney(Time leaveTime)方法为抽象方法，没有方法体和花括号，且需要在后续的子类中被实体化；
    //一旦出现了此抽象方法，所在类Vehicle必须被声明为抽象类，且该类无法创建（实例化）对象；
    public abstract int calculateMoney(Time leaveTime);
}
