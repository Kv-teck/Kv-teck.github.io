package lesson.lesson1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Bai1();
        Bai2();
    }

    private static void Bai2() {
        Scanner sc = new Scanner(System.in);
    }

    private static void Bai1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ho va ten");
        String name = scanner.nextLine();
        System.out.println("Nhap ngay");
        int day = scanner.nextInt();
        System.out.println("Nhap thang");
        int month = scanner.nextInt();
        System.out.println("Nhap nam sinh");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap que quan");
        String hometown = scanner.nextLine();
        System.out.println("Nhap truong hoc");
        String school = scanner.nextLine();
        System.out.println("Xin chao " + name + " den tu " + hometown + " sinh ngay " + day + "/" + month + "/" + year + " hoc tai truong " + school);
        scanner.close();
    }

}
