package lesson6;

public class Main {
    public static void main(String[] args) {
        Oto honda = new Oto();// dùng toán tử new để tạo đối tượng

        honda.brand = "HONDA";
        honda.model = "CITY";
        honda.color = "black";
        honda.year = 2020;


        honda.running(100);
        honda.breaking(150);

//         Tạo 1 class PhanSo trong đó có 2 thuộc tính kiểu int tuso và mauso
//         Viết
//         1) Phương thức void input() nhập tử só và mẫu số tư bàn phím (mẫu số không dduocj nhập = 0)
//         2) phương thức void add(PhanSo a) -> cộng 2 phân số
//         2) phương thức void sub(PhanSo a) -> trừ 2 phân số
//         3) phương thức void devide(PhanSo a) -> chia 2 phân số
//         4) phương thức void multi(PhanSo a) -> nhân 2 phân số
        MyTime myTime = new MyTime();
        myTime.setTimeUnix(1721916233763l);
        myTime.info();


    }
}
