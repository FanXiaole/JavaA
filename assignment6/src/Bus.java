public class Bus extends Vehicle {
    //字段全部继承父类，将type构造为1，表示该车辆是“Car”类型的；
    public Bus(String plateNumber) {
        super(plateNumber);
        type = 1;
    }

    //calculateMoney方法，用于计算大车的停车费；
    public int calculateMoney(Time leaveTime) {
        if (arriveTime == null) {
            return 0;
        }
        int timePeriod = leaveTime.totalTime() - arriveTime.totalTime();
        int currentTime = timePeriod + previousTime;
        int currentMoney, previousMoney;
        arriveTime = null;
        isInside = false;
        if (timePeriod < 30) {
            return 0;
        } else {
            currentMoney = Math.min(100, 15 * (1 + (currentTime / 60)));
        }
        if (previousTime < 30) {
            previousMoney = 0;
        } else {
            previousMoney = Math.min(100, 15 * (1 + (previousTime / 60)));
        }
        previousTime += timePeriod;
        return currentMoney - previousMoney;
    }
}
