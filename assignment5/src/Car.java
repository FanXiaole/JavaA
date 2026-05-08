//Car为父类Vehicle的其中一个子类；
public class Car extends Vehicle {
    //注意构造方法进需要一个传参“车牌号”，记得在第一行调用父类的构造方法；
    public Car(String plateNumber) {
        super(plateNumber);
    }

    //calculateMoney(Time leaveTime)方法，通过到来时间和离开时间，结合一定算法，计算出车费；
    public int calculateMoney(Time leaveTime) {
        //特殊情况考虑：当还没设置到来时间就要离开时，直接返回0，并结束方法；
        if (arriveTime == null) {
            return 0;
        }
        //timePeriod得到到来时间和离开时间之间的时间间隔，即“停车时长”，单位是分钟；
        int timePeriod = leaveTime.totalTime() - arriveTime.totalTime();
        //currentTime是指当前的总时间；
        int currentTime = timePeriod + previousTime;
        //currentMoney和previousMoney分别表示当前总时间和之前总时间对应的车费；
        int currentMoney, previousMoney;
        //字段的更新（初始化)，倘若此方法被调用，则说明车已经离开停车场，将arriveTime设置为null，isInside设置为false；
        arriveTime = null;
        isInside = false;

        //计算当前总时间对应车费：
        //停车时长小于30分钟不收费，直接返回0，结束方法；
        if (timePeriod < 30) {
            return 0;
        }
        //其余情况的具体算法见下面代码，需要用到Math类的取小方法；
        else {
            currentMoney = Math.min(60, 15 + 5 * (currentTime / 60));
        }
        //同样的，将之间总时间对应车费用同一套代码再写一遍；
        if (previousTime < 30) {
            previousMoney = 0;
        } else {
            previousMoney = Math.min(60, 15 + 5 * (previousTime / 60));
        }

        //字段previousTime的迭代，注意到当timePeriod<30时直接返回0并结束方法，故能够执行此语句的timePeriod一定是大于等于30的；
        previousTime += timePeriod;
        //计算两者差价，作为本次停车的停车费进行返回；
        return currentMoney - previousMoney;
    }
}
