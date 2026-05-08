public abstract class Vehicle {
    //字段包含车牌号、车辆类型、是否在停车场里？、进入时间、离开时间、累计时间；
    protected String plateNumber;
    protected int type;
    protected boolean isInside;
    protected Time arriveTime;
    protected Time leaveTime;
    protected int previousTime;

    //Constructor；
    public Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
        isInside = false;
        arriveTime = null;
        leaveTime = null;
        previousTime = 0;
    }

    //toString方法重写；
    public String toString() {
        return String.format("%s %s %s", (type == 0) ? "Car" : "Bus", plateNumber, isInside);
    }

    //setArriveTime方法，用于设定进入时间；
    //一旦进入停车场，立马将isInside字段改为true，表示此时正处于停车场内；
    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
        isInside = true;
    }

    //getArriveTime方法，用于返回进入时间；
    public Time getArriveTime() {
        return arriveTime;
    }

    //声明的抽象方法，下放到两个子类中去实现，且两个子类实现方法体的内容有较大差异；
    public abstract int calculateMoney(Time leaveTime);
}
