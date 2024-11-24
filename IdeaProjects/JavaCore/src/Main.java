import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Xin chao");
//        bai1();
//        bai2();
//        bai3();
//        bai4();
        bai5();
    }

    private static void bai5() {

    }

    private static void bai4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so tien thue");
        int sotienthue = scanner.nextInt();
        if (sotienthue < 10) {
            System.out.println("ko dong thue");
        } else if (10 <= sotienthue && sotienthue < 15) {
            System.out.println("thue 10%");
        } else if (15 <= sotienthue && sotienthue < 30) {
            System.out.println("thue 20%");
        } else {
            System.out.println("thue 50%");
        }
        scanner.close();
    }

    private static void bai3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap canh khoi lap phuong");
        int canh = scanner.nextInt();
        int thetich = (int) Math.pow(canh, 3);
        System.out.println("the tich khoi lap phuong " + thetich);
        scanner.close();
    }

    private static void bai2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chieu dai");
        int dai = scanner.nextInt();
        System.out.println("Nhap chieu rong");
        int rong = scanner.nextInt();

        int chuvi = (dai + rong) * 2;
        int dientich = dai * rong;
        System.out.println("chu vi hcn " + chuvi + "dien tich hcn " + dientich);

        int canhnhonhat = Math.min(dai, rong);
        System.out.println("canh nho nhat " + canhnhonhat);
        scanner.close();
    }

    private static void bai1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten sinh vien");
        String name = sc.next();
        System.out.println("Nhap diem");
        int diem = sc.nextInt();

        System.out.println(name + " co diem la = " + diem);
        sc.close();
    }
}