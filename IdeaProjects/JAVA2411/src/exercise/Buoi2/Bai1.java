package exercise.Buoi2;

import java.util.Scanner;

public class Bai1 {
    //    Viết chương trình Java tính điểm của sinh viên.
//  Chương trình này sẽ đọc vào các loại điểm của sinh viên (điểm chuyên cần, điểm giữa kỳ, và điểm cuối kỳ)
//  và xếp loại điểm theo quy luật sau:
//– if điểm trung bình >=9 =>loại=A
//– if điểm trung bình >= 7 và <9 => loại=B
//– if điểm trung bình>=5 and <7 =>loại=C
//– if điểm trung bình<5 =>loại=D
    public static void main(String[] args) {
        tinhDiemSinhVien();
    }

    static void tinhDiemSinhVien() {
        Scanner scanner = new Scanner(System.in);

        final double loaiA = 9;
        final double loaiB = 7;
        final double loaiC = 4;

        System.out.println("Nhap tem sinh vien");
        String name = scanner.nextLine();
        System.out.println("Nhap diem chuyen can cua sinh vien");
        double diemChuyenCan = scanner.nextDouble();
        System.out.println("Nhap diem giua ky cua sinh vien");
        double diemGiuaKy = scanner.nextDouble();
        System.out.println("Nhap diem cuoi ky cua sinh vien");
        double diemCuoiKy = scanner.nextDouble();

        double diemTrungBinh = (diemChuyenCan + diemGiuaKy + diemCuoiKy) / 3;

        if (diemTrungBinh >= loaiA) {
            System.out.println("Sinh Vien: " + name + " diem trung binh: " + diemTrungBinh + " xep loai A");
        } else if (loaiB <= diemTrungBinh) {
            System.out.println("Sinh Vien: " + name + " diem trung binh: " + diemTrungBinh + " xep loai B");
        } else if (loaiC < diemTrungBinh) {
            System.out.println("Sinh Vien: " + name + " diem trung binh: " + diemTrungBinh + " xep loai C");
        } else System.out.println("Sinh Vien: " + name + " diem trung binh:" + diemTrungBinh + " xep loai D");
        scanner.close();
    }
}
