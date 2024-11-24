package exercise.Buoi2;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        tinhTienDien();
    }

    static void tinhTienDien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so dien su dung cua thang");
        int soDien = scanner.nextInt();

        int kWhBac1 = 50;
        int kWhBac2 = 100;
        int kWhBac3 = 200;
        int kWhBac4 = 300;
        int kWhBac5 = 400;

        int bac1 = 1678;
        int bac2 = 1734;
        int bac3 = 2014;
        int bac4 = 2536;
        int bac5 = 2834;
        int bac6 = 2927;

        int tienDien = 0;
        if (soDien <= kWhBac1) {
            tienDien = soDien * bac1;
        } else if (soDien <= kWhBac2) {
            tienDien = kWhBac1 * bac1 + (soDien - kWhBac1) * bac2;
        } else if (soDien <= kWhBac3) {
            tienDien = kWhBac1 * bac1 + kWhBac1 * bac2 + (soDien - kWhBac2) * bac3;
        } else if (soDien <= kWhBac4) {
            tienDien = kWhBac1 * bac1 + kWhBac1 * bac2 + kWhBac2 * bac3 + (soDien - kWhBac3) * bac4;
        } else if (soDien <= kWhBac5) {
            tienDien = kWhBac1 * bac1 + kWhBac1 * bac2 + kWhBac2 * bac3 + kWhBac3 * bac4 + (soDien - kWhBac4) * bac5;
        } else tienDien = kWhBac1 * bac1 + kWhBac1 * bac2 + kWhBac2 * bac3 + kWhBac3 * bac4 + kWhBac4 * bac5 + (soDien - kWhBac5) * bac6;

        System.out.println("Tien dien thang " + tienDien);
        scanner.close();
    }
}
