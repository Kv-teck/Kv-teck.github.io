package exercise.Buoi6.bai1;

import lesson.lesson6.BaiTap.ManagerAnimal;

public class Bai1 {
    /*
    Bài tập 1: Áp dụng tính kế thừa, trừu tượng, và đa hình
    Đề bài:
    Phát triển chương trình quản lý động vật trong sở thú từ bài tập trong buổi học:
    1. Thêm một phương thức action() trong lớp trừu tượng Animal.
      • Phương thức này sẽ được ghi đè ở từng lớp con để mô tả hành động đặc trưng của mỗi loại động vật:
        o	Lion: in ra “The lion is hunting.”
        o	Elephant: in ra “The elephant is spraying water.”
        o	Monkey: in ra “The monkey is climbing trees.”
    2. Thêm phương thức showInfo() để hiện thị thông tin chi tiết của mỗi con vật gồm tên, tuổi
    3. Tạo class ManagerAnimal cho phép thực hiện các yêu cầu:
        a)	có 1 danh sách các động vậy Lion,Elephant,Monkey, cho phép người dùng nhập vào n, chính là
        b)	tổng số lượng các động vật mà sở thú quản lý
        c)	nhập vào danh sách các động vật củ sở thú và cho phép người dùng lựa chọn
    1.	nhập vào Lion
    2.	nhập vào Elephant
    3.	nhập vào Monkey
    4.	Dừng nhập vào
        d)	chú ý: nhập vào là bao gồm cả các thông tin tên, tuổi
        e)	Hiển thị danh sách tất cả các động vật trong sở thú
        f)	Thêm 1 con vật nếu danh sách đầy, phải mở rộng danh sách, mặc định mở rộng 10 phần tử
        g)	Cho phép nhập tên con vật, hiển thị thông tin con vật nếu có, không phân biệt hoa thường
        h)	Cho phép xóa con vật theo tên
    */
    public static void main(String[] args) {
        Animal[] animals = {
                new Lion(),
                new Elephant(),
                new Monkey(),
        };
        for (Animal animal : animals) {
            animal.action();
        }
        Animal animal =new Lion();
        animal.showInfo("loo",20);

        ManagerAnimal.danhSachAnimal();
    }


}
