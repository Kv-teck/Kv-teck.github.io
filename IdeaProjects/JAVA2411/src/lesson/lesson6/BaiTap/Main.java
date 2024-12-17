package lesson.lesson6.BaiTap;

/**
 * Bài tập 1: Áp dụng tính kế thừa Đề bài:
 * Xây dựng chương trình quản lý động vật trong sở thú:
 * 1. Tạo lớp cha Animal với các thuộc tính và phương thức:
 * • Thuộc tính:        name (tên động vật),        age (tuổi).
 * • Phương thức:    method:        eat() (in ra “Animal is eating”).
 * 2. Tạo các lớp con:
 * • Lion: có phương thức riêng roar() (in ra “Lion is roaring”).
 * • Elephant: có phương thức riêng trumpet() (in ra “Elephant is trumpeting”).
 * 3. Tạo đối tượng Lion và Elephant, gọi các phương thức chung (eat()) và phương thức riêng (roar(), trumpet()) của chúng.
 * <p>
 * Bài tập 2: Áp dụng tính kế thừa với lớp trừu tượng và ghi đè Đề bài:
 * Phát triển chương trình quản lý động vật trong sở thú từ bài tập 1:
 * 1. Chuyển lớp cha Animal thành lớp trừu tượng.
 * 2. Thêm phương thức trừu tượng makeSound() trong Animal.
 * 3. Ghi đè phương thức makeSound() ở các lớp con (Lion, Elephant) với nội dung:
 * • Lion: “Lion is roaring.”
 * • Elephant: “Elephant is trumpeting.”
 * 4. Thêm lớp Monkey kế thừa từ Animal, phương thức makeSound() in ra “Monkey is chattering.”
 * 5. Tạo một danh sách chứa các đối tượng Lion, Elephant, và Monkey, sau đó duyệt qua danh sách và gọi phương thức makeSound() cho từng đối tượng.
 * <p>
 * Bài tập 3: Áp dụng tính kế thừa, trừu tượng, và đa hình Đề bài:
 * Phát triển chương trình quản lý động vật trong sở thú từ bài tập 2:
 * 1. Thêm một phương thức action() trong lớp trừu tượng Animal.
 * • Phương thức này sẽ được ghi đè ở từng lớp con để mô tả hành động đặc trưng của mỗi loại động vật:
 * • Lion: in ra “The lion is hunting.”
 * • Elephant: in ra “The elephant is spraying water.”
 * • Monkey: in ra “The monkey is climbing trees.”
 * 2. Thêm phương thức showInfo() để hiện thị thông tin chi tiết của mỗi con vật gồm tên, tuổi
 * 3. Tạo class ManagerAnimal cho phép thực hiện các yêu cầu:
 * a) có 1 danh sách các động vậy Lion,Elephant,Monkey, cho phép người dùng nhập vào n, chính là
 * tổng số lượng các động vật mà sở thú quản lý
 * b) nhập vào danh sách các động vật củ sở thú và cho phép người dùng lựa chọn
 * 1) nhập vào Lion
 * 2) nhập vào Elephant
 * 3) nhập vào Monkey
 * 4) Dừng nhập vào
 * chú ý: nhập vào là bao gồm cả các thông tin tên, tuổi
 * c) Hiển thị danh sách tất cả các động vật trong sở thú
 * d) Thêm 1 con vật nếu danh sách đầy, phải mở rộng danh sách, mặc định mở rộng 10 phần tử
 * e) Cho phép nhập tên con vật, hiển thị thông tin con vật nếu có, không phân biệt hoa thường
 * f) Cho phép xóa con vật theo tên
 */
public class Main {
    public static void main(String[] args) {
//        Bai2();
        Bai3();
    }
    public  static void Bai3(){
        Animal animal = new Lion();


    }
    public static void Bai2() {
        /* 
        Animal[] animals = new Animal[3];
        Animal lion = new Lion();
        animals[0] = lion;
        Animal elephant = new Elephant();
        animals[1] = elephant;
        Animal monkey = new Monkey();
        animals[2] = monkey;

        for (Animal animal: animals){
            animal.makeSound();
        }*/
        Animal[] animals = {
                new Lion(),
                new Elephant(),
                new Monkey()
        };

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
