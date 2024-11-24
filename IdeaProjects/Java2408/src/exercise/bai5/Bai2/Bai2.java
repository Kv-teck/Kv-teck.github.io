package exercise.bai5.Bai2;

public class Bai2 {
    //    Tạo lớp Time để mô tả thời gian bao gồm 3 thuộc tính int hour, minute, và second
//
//    Viết hàm getter setter cho các thuộc tính
//
//    Viết hàm setTimeUnix(long time) để truyền thời gian
//
//    Viết hàm in ra màn hình giờ phút giây dựa trên thời gian unix truyền vào
//
//    Ví du: truyền vào: 1721916233763 in ra màn hình 14:03:53
//
//    (Timestamp - khái niệm quen thuộc trong hệ thống Unix. Thời gian Unix, là hệ thống nhằm diễn tả một điểm trên trục
//    thời gian, theo trục thời gian nó sử dụng số giây kể để xác định thời điểm,
//    với điểm gốc từ thời điểm 00:00:00 ngày 1/1/1970 (UTC+0).
//
//    Ví dụ lúc 00:00:00 - 1/1/2017 có giá trị timestamp là 1483228800;
//    Có nghĩa là tính từ 00h:00m:00s ngày 1/1/1970 đến 00h:00m:00s ngày 1/1/2017 là 1483228800 giây)
    public static void main(String[] args) {
        Time time = new Time();

        time.setTimeUnix(1721916233763l);
        time.info();
    }
}
