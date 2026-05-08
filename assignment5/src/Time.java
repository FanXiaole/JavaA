//Time类相当于是一个时间转换器；
public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    //addMinutes方法，得到添加时间更后的hour和minute；
    public void addMinutes(int minutes) {
        int addHour = minutes / 60;
        int addMinute = minutes % 60;
        hour += addHour;
        if (minute + addMinute >= 60) {
            hour += 1;
            minute = (minute + addMinute) % 60;
        } else {
            minute += addMinute;
        }
    }

    //格式控制符%02d表示设置两位空间，若整数填不满则用0填充该整数左侧，直至填满两位的空间；
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    //totalTime方法，用于后续计算时间差；
    public int totalTime() {
        return 60 * hour + minute;
    }
}
