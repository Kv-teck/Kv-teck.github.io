package exercise.bai5.Bai1;

import java.util.Scanner;

public class Rectangle {

    int width;
    int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    void enter() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap width: ");
        width = sc.nextInt();
        System.out.print("Nhap height: ");
        height = sc.nextInt();
        sc.close();
    }

    void chuVi() {
        int chuVi = (width + height) * 2;
        System.out.println("Chu vi " + chuVi);
    }
    void dienTich(){
        int dienTich = width * height;
        System.out.println("Dien tich " + dienTich);
    }

}
