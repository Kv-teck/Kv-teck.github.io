package exercise.Buoi3;

import java.util.Scanner;

public class Bai2 {
    //    Đổi sang số nhị phân của 1 số nguyên dương n
//    Ví dụ nhập sao số dương 8 in ra màn hình số nhị phân của nó là 1000
//            7 -> 111
//            9 -> 1001
//            16 -> 10000
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap n");
        int n = scanner.nextInt();

        String soNhiPhan = "";
        while (n != 0) {
            soNhiPhan = soNhiPhan + (n % 2);
            n = n / 2;
        }
        System.out.println(soNhiPhan);
        scanner.close();
    }
}
