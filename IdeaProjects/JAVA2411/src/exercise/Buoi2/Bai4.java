package exercise.Buoi2;

import java.util.Scanner;

import static exercise.Buoi2.Bai1.tinhDiemSinhVien;
import static exercise.Buoi2.Bai2.kiemTraLoaiTamGiac;
import static exercise.Buoi2.Bai3.tinhTienDien;

public class Bai4 {
    //    Viết chương trình tổ chức 1 menu gồm 3 chức năng để gọi 3 bài trên và một chức
//    năng để thoát khỏi ứng dụng.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu chuc nang");
        System.out.println("+...................+");
        System.out.println("1.Tính điểm sinh viên");
        System.out.println("2.Kiểm tra loại tam giác");
        System.out.println("3.Tính tiền điện");
        System.out.println("4.Kết thúc");
        System.out.print("+ Chọn chức năng: ");
        int soChucNang = scanner.nextInt();

        switch (soChucNang) {
            case 1:
                tinhDiemSinhVien();
                break;
            case 2:
                kiemTraLoaiTamGiac();
                break;
            case 3:
                tinhTienDien();
                break;
            case 4:
                break;
            default:
                System.out.println("chuc nang khong ton tai");
        }

    }
}
