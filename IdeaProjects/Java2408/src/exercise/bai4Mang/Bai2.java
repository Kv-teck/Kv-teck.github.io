package exercise.bai4Mang;

import java.util.Scanner;

public class Bai2 {
    //    Viết chương trình nhập 2 mảng họ tên và điểm của sinh viên.
//        Xuất 2 mảng đã nhập, mỗi sinh viên có thêm học lực
//            Yếu: điểm < 5
//            Trung bình: 5 <= điểm < 6.5
//            Khá: 6.5 <= điểm < 7.5
//            Giỏi: 7.5<= điểm < 9
//            Xuất sắc: điểm >= 9
//        Sắp xếp danh sách sinh viên đã nhập tăng dần theo điểm
    public static void main(String[] args) {
        Bai_2();
    }

    static void Bai_2() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so luong:");
        int a = sc.nextInt();

        String[] name = new String[a];
        float[] diem = new float[a];

        for (int i = 0; i < a; i++) {
            System.out.println("nhập tên " + "STT " + i);
            name[i] = sc.next();

            System.out.println("Nhập diem: ");
            diem[i] = sc.nextFloat();

            while (diem[i] < 0 || diem[i] > 10) {
                System.out.println("Điểm không hợp lệ. Vui lòng nhập lại điểm (0-10): ");
                diem[i] = sc.nextFloat();
            }
        }

        String[] xl = new String[]{"Yeu", "Trung Binh", "Kha", "Gioi", "Xuat Sac"};
        for (int i = 0; i < a; i++) {
            if (diem[i] < 5) {
                System.out.println(name[i] + ": " + xl[0]);
            } else if (diem[i] >= 5 && diem[i] < 6.5) {
                System.out.println(name[i] + ": " + xl[1]);
            } else if (diem[i] >= 6.5 && diem[i] < 7.5) {
                System.out.println(name[i] + ": " + xl[2]);
            } else if (diem[i] >= 7.5 && diem[i] < 9) {
                System.out.println(name[i] + ": " + xl[3]);
            } else {
                System.out.println(name[i] + ": " + xl[4]);
            }
        }

        for (int i = 0; i < a - 1; i++) {
            for (int j = i + 1; j < a; j++) {
                if (diem[i] > diem[j]) {

                    float tempDiem = diem[i];
                    diem[i] = diem[j];
                    diem[j] = tempDiem;

                    String tempName = name[i];
                    name[i] = name[j];
                    name[j] = tempName;
                }
            }
        }

        System.out.println("Danh sách sắp xếp theo điểm:");
        for (int i = 0; i < a; i++) {
            String xepLoai;
            if (diem[i] < 5) {
                xepLoai = xl[0];
            } else if (diem[i] >= 5 && diem[i] < 6.5) {
                xepLoai = xl[1];
            } else if (diem[i] >= 6.5 && diem[i] < 7.5) {
                xepLoai = xl[2];
            } else if (diem[i] >= 7.5 && diem[i] < 9) {
                xepLoai = xl[3];
            } else {
                xepLoai = xl[4];
            }

            System.out.println(name[i] + ": " + diem[i] + ": " + xepLoai);
        }
        sc.close();
    }
}
