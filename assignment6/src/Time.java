public class Time {
    //字段只包含小时数和分钟数；
    private int hour;
    private int minute;

    //Constructor;
    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    //addMinutes方法，实现Time的更新，传参为经过的时间；
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

    //toString方法的重写；
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    //totalTime方法，能够将00:00~24:00的所有时刻转换为int类型的分钟数；
    public int totalTime() {
        return 60 * hour + minute;
    }
}
