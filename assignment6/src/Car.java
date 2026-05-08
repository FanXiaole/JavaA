public class Car extends Vehicle {
    //字段全部继承父类，将type构造为0，表示该车辆是“Car”类型的；
    public Car(String plateNumber) {
        super(plateNumber);
        type = 0;
    }

    //calculateMoney方法，用于计算小车的停车费；
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
            currentMoney = Math.min(60, 15 + 5 * (currentTime / 60));
        }
        if (previousTime < 30) {
            previousMoney = 0;
        } else {
            previousMoney = Math.min(60, 15 + 5 * (previousTime / 60));
        }
        previousTime += timePeriod;
        return currentMoney - previousMoney;
    }
}
