package exercise.bai3;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
//        Công thức của dãy fibonacci có dạng: f(n) = f(n-1) + f(n-2) .
//                Với f(1) = 1;  f(2) =1;
//        Nhập n từ bàn phím (n dương, bắt nhập lại nếu n âm, chỉ được phép sử dụng vòng for) và in ra màn hình dãy f(n)
        fibonacci();
//        fibonacci2();
    }

    static void fibonacci() {
        Scanner sc = new Scanner(System.in);
        int n;
        for (; ; ) {
            System.out.print("Nhập n (n > 0): ");
            n = sc.nextInt();
            if (n > 0) {
                break; // Thoát khỏi vòng lặp nếu n hợp lệ
            }
            System.out.println("Vui lòng nhập n dương.");
        }

        int f1 = 1;
        System.out.println("f1: " + f1);
        int f2 = 1;
        System.out.println("f2: " + f2);
        int fn;
        for (int i = 3; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
            System.out.println("f" + i + ": " + fn);
        }
        sc.close();
    }

    static void fibonacci2() {
        int fn = 13;

        int f1 = 1;
        int f2 = 1;

        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);

        int i = 3;
        int f3 = f1 + f2;

        while (f3 < fn) {
            System.out.println("f" + i + ": " + f3);
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
            i++;
        }

    }


}