//Bus是父类Vehicle的另一个子类，与Car属于兄弟关系（平行关系）；
public class Bus extends Vehicle {
    public Bus(String plateNumber){
        super(plateNumber);
    }

    public int calculateMoney(Time leaveTime){
        //特殊情况：
        if(arriveTime==null){
            return 0;
        }
        //声明一些后续要用到的变量；
        int timePeriod =leaveTime.totalTime()-arriveTime.totalTime();
        int currentTime= timePeriod +previousTime;
        int currentMoney,previousMoney;
        //字段的更新（初始化）；
        arriveTime=null;
        isInside=false;

        //与Car子类唯一不同的一点是车费的具体计算算法；
        if(timePeriod <30){
            return 0;
        }else{
            currentMoney=Math.min(100,15*(1+(currentTime/60)));
        }
        if(previousTime<30){
            previousMoney=0;
        }else{
            previousMoney=Math.min(100,15*(1+(previousTime/60)));
        }

        //字段的迭代；
        previousTime+= timePeriod;
        //差价的计算与返回；
        return currentMoney-previousMoney;
    }
}
