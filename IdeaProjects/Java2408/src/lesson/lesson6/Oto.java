package lesson.lesson6;

//1 lớp - class: 1 kiểu dữ liệu trong code
public class Oto {
    //Các đặc điểm
    int year; // năm sản xuất
    //Danh từ - mô tả đặc điểm của đối tượng đó

    String color;//Màu xe

    String model;//Phiên bản xe

    String brand;//Thương hiệu xe

    //Các hành động
    void running(int speed){
        System.out.println(brand + " " + model + " car í running with " + speed + "km/h");
    }

}
