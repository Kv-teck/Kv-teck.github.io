package lesson6;

import java.util.Scanner;

public class Phanso {

    // Các thuộc tính
    int tuso;
    int mauso = 1;

    public int getTuso() {
        return tuso;
    }

    public void setTuso(int tuso) {
        this.tuso = tuso;
    }

    public int getMauso() {
        return mauso;
    }

    public void setMauso(int mauso) {
        if (mauso == 0) return;
        this.mauso = mauso;
    }

    public void nhapPhanso() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhap tu so:");
                this.tuso = Integer.parseInt(sc.nextLine());
                while (true) {
                    System.out.println("Nhap mau so:");
                    this.mauso = Integer.parseInt(sc.nextLine());
                    if (this.mauso == 0) {
                        System.out.println("mau so phai !=0");
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("nhap chu cai???");
            }
        }
        System.out.println("Phan so da nhap la: " + this.tuso + "/" + this.mauso);
    }

    public void cong(Phanso a) {
        int k = this.getMauso() * a.getMauso();
        int t = a.getTuso() * this.mauso + this.tuso * a.getMauso();
        int u = this.gcd(t, k);
        int tu = t / u;
        int mau = k / u;
        System.out.println("Tong la: " + tu + "/" + mau);
    }

    public void tru(Phanso a) {
        int k = this.getMauso() * a.getMauso();
        int t = -a.getTuso() * this.mauso + this.tuso * a.getMauso();
        int u = this.gcd(t, k);
        int tu = t / u;
        int mau = k / u;
        System.out.println("Hieu la: " + tu + "/" + mau);
    }

    public void nhan(Phanso a) {
        int t = this.tuso * a.getTuso();
        int k = this.mauso * a.getMauso();
        int u = this.gcd(t, k);
        int tu = t / u;
        int mau = k / u;
        System.out.println("Tich la: " + tu + "/" + mau);
    }


    public void chia(Phanso a) {
        int t = this.tuso * a.getMauso();
        int k = this.mauso * a.getTuso();
        int u = this.gcd(t, k);
        int tu = t / u;
        int mau = k / u;
        System.out.println("Thuong la: " + tu + "/" + mau);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
