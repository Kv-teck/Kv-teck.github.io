package exercise.Buoi2;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Nam");
        int nam = scanner.nextInt();
        System.out.println("Nhap thang");
        int thang = scanner.nextInt();

        int soNgay = 0;
        switch (thang) {
            case 1:
                soNgay = 31;
                break;
            case 2:
                // Kiểm tra năm nhuận
                if ((nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0)) {
                    soNgay = 29; // Năm nhuận
                } else {
                    soNgay = 28; // Năm không nhuận
                }
                break;
            case 3:
                soNgay = 31;
                break;
            case 4:
                soNgay = 30;
                break;
            case 5:
                soNgay = 31;
                break;
            case 6:
                soNgay = 30;
                break;
            case 7:
                soNgay = 31;
                break;
            case 8:
                soNgay = 31;
                break;
            case 9:
                soNgay = 30;
                break;
            case 10:
                soNgay = 31;
                break;
            case 11:
                soNgay = 30;
                break;
            case 12:
                soNgay = 31;
                break;
        }
        System.out.println("Nam" + nam + " thang" + thang + " co " + soNgay + "ngay");
    }
}
