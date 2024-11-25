package lesson.lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Bai1();
//        Bai2();
        Bai3();
    }

    static void Bai3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = scanner.nextInt();
        int giaiThua = 1;
        for(int i=n;i>0;i--){
            giaiThua*=i;

        }
        System.out.println(giaiThua);
    }

    static void Bai2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so");

    }

    static void Bai1() {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhap n > 0");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Vui lòng nhập một số lớn hơn 0.");
            }
        } while (n <= 0);

        int i;
        double s = 0;
        System.out.print("day S(n) = ");
        for (i = 1; i <= n; i++) {
            s += (int) Math.pow(i, 3);
            System.out.print(i + "^3 + ");
        }
        System.out.println();
        System.out.println("tong " + s);
    }
}
