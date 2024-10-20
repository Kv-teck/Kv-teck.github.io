package exercise.bai5.Bai2;

public class Time {
    int hour;
    int minute;
    int second;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    //    Ví du: truyền vào: 1721916233763 in ra màn hình 14:03:53
    public void setTimeUnix(long time) {
        // 1 ngày nó mất 1000 * 60 * 60 * 24 miliseconds
        // 1 ngày nó mất 60 * 60 * 24 miliseconds
        long secondsFrom1970 = time / 1000;// số giây tính từ 0h 0p 0s ngày 1/1/1970

        //1000 giây tờ 0 h ngay hôm nay
        // 1 phút có bao nhiều giây = 60s
        this.second = (int) (secondsFrom1970 % 60);

        long minuteFrom1970 = secondsFrom1970 / 60;
        // 1 giờ có bao nhiều phút = 60 phút
        this.minute = (int) (minuteFrom1970 % 60);

        long hourFrom1970 = minuteFrom1970 / 60;
        // 1 ngày có bao nhiều giờ = 24
        this.hour = (int) (hourFrom1970 % 24);


    }


    public void info() {
        System.out.println(hour + ":" + minute + ":" + second);
    }

    public boolean namNhuan(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
