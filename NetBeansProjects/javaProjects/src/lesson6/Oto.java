package lesson6;

// 1 lớp - class: 1 kiểu dữ liệu trong code
public class Oto {
    // Các đặc điểm - Các thuộc tính
    // Danh từ - mô tả đặc điểm của đối tượng đó
    int year;// năm sản xuất
    String color;// Màu xe
    String model; // Phiên bản xe
    String brand;// Thương hiệu xe

    // Các hành động - Các phương thức
    // Các hàm, danh động từ
    void running(int speed) {
        System.out.println(brand + " " + model + " car is running with " +speed + "km/h" );
    }

    void breaking(int speed) {
        System.out.println(brand + " " + model + " car is breaking with " +speed + "km/h" );
    }

}
