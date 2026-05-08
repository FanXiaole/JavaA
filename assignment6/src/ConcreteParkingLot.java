import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//实体类ConcreteParkingLot作为接口ParkingLot的实现类，需要实体化接口中声明过的所有抽象方法；
public class ConcreteParkingLot implements ParkingLot {
    //字段为：停车名单、当前显示屏时间、小车容量、大车容量、当前小车数量、当前大车数量、总车费、停车记录1，停车记录2；
    //其中CAR_CAPACITY和BUS_CAPACITY都是final类型的，一旦声明不能更改，因为大小车容量是停车场修建时就确定好了的；
    private List<Vehicle> vehicles;
    private Time currentTime;
    private final int CAR_CAPACITY;
    private final int BUS_CAPACITY;
    private int CAR_COUNT;
    private int BUS_COUNT;
    private int totalIncome;
    List<ParkingRecord> parkingRecords1 = new ArrayList<>();
    List<String> parkingRecords2 = new ArrayList<>();

    //Constructor；
    public ConcreteParkingLot(int carCapacity, int busCapacity) {
        vehicles = new ArrayList<>();
        currentTime = new Time(0, 0);
        CAR_CAPACITY = carCapacity;
        BUS_CAPACITY = busCapacity;
        CAR_COUNT = 0;
        BUS_COUNT = 0;
        totalIncome = 0;
    }

    //getTime方法，“显示屏系统”，标明当前时间；
    public Time getTime() {
        return currentTime;
    }

    //minutesPassed方法，“快进系统”，用于更新显示屏上的当前时间；
    public void minutesPassed(int minutes) {
        currentTime.addMinutes(minutes);
    }

    //parkingLotStatus方法，“显示屏系统”，标明当前状态下：小车数/小车容量、大车数/大车容量；
    public String parkingLotStatus() {
        return String.format("%s:%d/%d %s:%d/%d", "car", CAR_COUNT, CAR_CAPACITY, "bus", BUS_COUNT, BUS_CAPACITY);
    }

    //currentIncome方法，“收银台系统”，用于返回当前的总停车费；
    public int currentIncome() {
        return totalIncome;
    }

    //driveInto方法，“进入系统”，用于更新停车名单，实现进入车辆信息的录入；
    public void driveInto(int type, String... plateNumbers) {
        //vehicleNumber是想要进入的车辆数量；
        int vehicleNumber = plateNumbers.length;
        //allowNumber指当前状态下最多能够允许进入的小车或大车数量；
        int allowNumber = (type == 0) ? CAR_CAPACITY - CAR_COUNT : BUS_CAPACITY - BUS_COUNT;
        //最终实际进入数量realNumber是想要进入数量和允许进入数量中较小者；
        int realNumber = Math.min(vehicleNumber, allowNumber);
        //遍历数组中最终能够进入停车场的车辆，注意范围realNumber，传入数组中超出范围部分会被舍弃；
        for (int i = 0; i < realNumber; i++) {
            //提炼出当前遍历元素的车牌号currentPlateNumber；
            String currentPlateNumber = plateNumbers[i];
            //接下来分成两种情况：
            //情况一，在停车名单中没找到该车辆，说明其第一次进入停车场，需要将其信息新添到停车名单中；
            if (getVehicleByPlateNumber(currentPlateNumber) == null) {
                //利用父类引用声明子类对象，这里currentVehicle实际类型是Car还是Bus,取决于传参type的数值是0还是1；
                Vehicle currentVehicle = (type == 0) ? new Car(currentPlateNumber) : new Bus(currentPlateNumber);
                //通过调用recordCurrentTime方法，获得当前时间并作为该车辆的进入时间；
                //注意这里的大坑！不能直接将字段currentTime的引用设置为进入时间；
                //因为它本质上是currentTime的地址，指向的具体内容随currentTime的改变而改变，如是便不是一个常值了；
                currentVehicle.setArriveTime(recordCurrentTime());
                vehicles.add(currentVehicle);
            }
            //情况二，在停车名单中找到历史记录，说明它是多次进入，无需重复录入停车名单，仅需更新其信息即可；
            else {
                //通过调用getVehicleByPlateNumber方法，返回车牌号对应的停车名单中的车辆；
                Vehicle currentVehicle = getVehicleByPlateNumber(currentPlateNumber);
                currentVehicle.setArriveTime(recordCurrentTime());
                //这里就不用再重复录入停车名单了；
            }
            //相当于一辆车进入停车场的过程需要耗时1分钟；
            //但是根据题目要求，最后一辆车进入停车场不需要耗时1分钟；
            if (i != realNumber - 1) {
                currentTime.addMinutes(1);
            }
        }
        //当前车辆数量的更新；
        if (type == 0) {
            CAR_COUNT += realNumber;
        } else {
            BUS_COUNT += realNumber;
        }
    }

    //recordCurrentTime方法，将当前时间转化为总时间，再将总时间转化回来；
    //该方法最大的特点就是保证了返回的时间是一个常值，不会随着字段currentTime的更新而改变；
    public Time recordCurrentTime() {
        int totalMinutes = currentTime.totalTime();
        Time currentArriveTime = new Time(0, 0);
        currentArriveTime.addMinutes(totalMinutes);
        return currentArriveTime;
    }

    //driveOut方法，“离开系统”，更新停车名单中车辆信息，同时更新停车记录系统；
    public void driveOut(String... plateNumbers) {
        for (String currentPlateNumber : plateNumbers) {
            //用currentVehicle提炼出当前离开的车辆；
            Vehicle currentVehicle = getVehicleByPlateNumber(currentPlateNumber);
            //这里与以往的坑同理，需要调用recordCurrentTime方法获取一个常值，而非字段currentTime的引用这样一个内容在变的地址；
            //将离开车辆信息加入到停车记录中；
            parkingRecords1.add(new ParkingRecord(currentVehicle.type, currentVehicle.plateNumber,
                    currentVehicle.arriveTime, recordCurrentTime()));
            //将本次停车费加到总停车费中去；
            totalIncome += currentVehicle.calculateMoney(currentTime);
            //字段的更新，表示该车辆已经离开停车场；
            currentVehicle.arriveTime = null;
            currentVehicle.isInside = false;
            //根据离开车辆的类型更新当前数量；
            if (currentVehicle.type == 0) {
                CAR_COUNT--;
            } else {
                BUS_COUNT--;
            }
        }
    }

    //getVehicleByPlateNumber方法，遍历停车名单中的所有车辆，通过车牌号找到对应车辆并返回；
    public Vehicle getVehicleByPlateNumber(String plateNumber) {
        for (Vehicle currentVehicle : vehicles) {
            String currentPlateNumber = currentVehicle.plateNumber;
            if (Objects.equals(currentPlateNumber, plateNumber)) {
                return currentVehicle;
            }
        }
        return null;
    }

    //getVehiclesByNumber方法，通过冒泡排序将数组vehicles按照车牌号从小到大的顺序进行排序；
    public List<Vehicle> getVehiclesByNumber() {
        //n用于提炼当前vehicles数组的长度；
        int n = vehicles.size();
        //外循环遍历n-1次，依次实现最大的放最右边、第二大的放次右边、...；
        for (int i = 0; i < n - 1; i++) {
            //内循环遍历n-1-i次，依次实现相邻元素之间的比较和换位；
            //比如说，当i=0时，需要比较n-1次，i=1时无需跟最右边的（已经确认为最大）进行比较了，故只用比较n-2次，以此类推；
            for (int j = 0; j < n - 1 - i; j++) {
                //firstVehicle提炼左边的元素，secondVehicle提炼右边的元素；
                Vehicle firstVehicle = vehicles.get(j);
                Vehicle secondVehicle = vehicles.get(j + 1);
                //firstPlateNumber提炼左边元素对应的车牌号，secondPlateNumber提炼右边元素对应的车牌号；
                String firstPlateNumber = firstVehicle.plateNumber;
                String secondPlateNumber = secondVehicle.plateNumber;
                //倘若比较结果大于0，说明左边车牌号比右边大，利用set方法交换两者对应车辆在停车名单中的位置；
                if (firstPlateNumber.compareTo(secondPlateNumber) > 0) {
                    vehicles.set(j, secondVehicle);
                    vehicles.set(j + 1, firstVehicle);
                }
            }
        }
        return vehicles;
    }

    //getParkingRecordByArriveTime方法，用于获取一段时间区间内的根据进入时间排好序的停车记录；
    public List<String> getParkingRecordByArriveTime(Time start, Time end) {
        //用startTime和endTime提炼区间左右端点的总时间；
        int startTime = start.totalTime();
        int endTime = end.totalTime();
        //将当前时间仍停留在停车场中还未离开的车辆加入停车记录中，它们的离开时间设置为null；
        for (Vehicle currentVehicle : vehicles) {
            if (currentVehicle.isInside) {
                parkingRecords1.add(new ParkingRecord(currentVehicle.type, currentVehicle.plateNumber,
                        currentVehicle.arriveTime, null));
            }
        }
        //用n提炼停车名单的长度；
        int n = parkingRecords1.size();
        //仍然是冒泡排序，遇上一个方法唯一不同是排序标准是按照进入时间从小到大排；
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                ParkingRecord firstParkingRecord = parkingRecords1.get(j);
                ParkingRecord secondParkingRecord = parkingRecords1.get(j + 1);
                int firstArriveTime = firstParkingRecord.recordArriveTime.totalTime();
                int secondArriveTime = secondParkingRecord.recordArriveTime.totalTime();
                if (firstArriveTime > secondArriveTime) {
                    parkingRecords1.set(j, secondParkingRecord);
                    parkingRecords1.set(j + 1, firstParkingRecord);
                }
            }
        }
        //筛选掉进入时间超出时间区间的停车记录，得到想要的最终版停车记录；
        for (int i = 0; i < n; i++) {
            int testTime = parkingRecords1.get(i).recordArriveTime.totalTime();
            if (testTime >= startTime && testTime <= endTime) {
                parkingRecords2.add(parkingRecords1.get(i).toString());
            }
        }
        return parkingRecords2;
    }
}
