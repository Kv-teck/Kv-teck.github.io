package exercise.bai3;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
//        Tính S(n) = 1^3 + 2^3 + 3^3 + … + n^3  n nhập từ bàn phím
        TinhS();
    }

    static void TinhS() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        long s = 0;
        for (int i = 1; i <= n; i++) {
            s +=(long) Math.pow(i, 3);

        }
        System.out.println("Tổng S: " + s);
        sc.close();
    }
}
