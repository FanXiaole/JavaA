public class ParkingRecord {
    //字段直接照搬toString中的四个%s中的内容，方便toString方法的书写；
    public String recordType;
    public String recordPlateNumber;
    public Time recordArriveTime;
    public Time recordLeaveTime;

    //Constructor;
    public ParkingRecord(int recordType, String recordPlateNumber, Time recordArriveTime, Time recordLeaveTime) {
        this.recordType=(recordType==0)?"Car":"Bus";
        this.recordPlateNumber = recordPlateNumber;
        this.recordArriveTime = recordArriveTime;
        this.recordLeaveTime = recordLeaveTime;
    }

    //toString方法重写；
    public String toString() {
        return String.format("%s %s %s %s", recordType, recordPlateNumber, recordArriveTime, recordLeaveTime);
    }
}
