package lesson.lesson6;

import java.util.Scanner;

public class PhanSo {
    int tuso;

    int mauso;

    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu so");
        tuso = sc.nextInt();

        do {
            System.out.print("Nhap mau so ");
            mauso = sc.nextInt();

            if (mauso < 0) {
                System.out.println("Vui long nhap lai so lon hon 0");
            }
        } while (mauso < 0);
    }

    void add(PhanSo a){
        tuso += a.tuso;
        mauso += a.mauso;
        System.out.println(tuso + " " + mauso);
    }
}
