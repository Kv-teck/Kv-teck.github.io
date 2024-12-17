package exercise.Buoi2;

import java.util.Scanner;

public class Bai2 {
    //  Nhập vào chương trình 2 số nguyên dương a,b,c
//    In ra màn hình kết luận về tam giác có 3 cạnh trên
//    (tam giác thường, tam giác vuông, tam giác cân, tam giác vuông cân, tam giác đều hoặc không phải tam giác)
    public static void main(String[] args) {
        kiemTraLoaiTamGiac();
    }

    static void kiemTraLoaiTamGiac() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap canh a");
        int a = scanner.nextInt();
        System.out.println("Nhap canh b");
        int b = scanner.nextInt();
        System.out.println("Nhap canh c");
        int c = scanner.nextInt();


        scanner.close();
    }
}
