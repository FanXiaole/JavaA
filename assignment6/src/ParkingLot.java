import java.util.List;

//ParkingLot为一个接口，这里用于声明好实现类需要具体实现的全部抽象方法；
//相当于核心方法的提炼，方便程序编写者明确代码框架；
//用不着关键词public和abstract，因为接口中方法声明默认是公共和抽象的；
public interface ParkingLot {
    Time getTime();

    void minutesPassed(int minutes);

    String parkingLotStatus();

    void driveInto(int type, String... plateNumbers);

    void driveOut(String... plateNumbers);

    Vehicle getVehicleByPlateNumber(String plateNumber);

    List<Vehicle> getVehiclesByNumber();

    List<String> getParkingRecordByArriveTime(Time start, Time end);

    int currentIncome();
}
