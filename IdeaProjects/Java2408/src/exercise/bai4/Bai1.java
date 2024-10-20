package exercise.bai4;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập năm:");
        int nam = sc.nextInt();
        System.out.println("Nhập tháng:");
        int thang = sc.nextInt();
        String tenthang = "";
        int n = 0;
        int m = 0;

        switch (nam) {
            case 2013:
                switch (thang) {
                    case 1:
                        tenthang = "January";
                        n = 2;
                        m = 31;
                        break;
                    case 2:
                        tenthang = "January";
                        n = 2;
                        m = 28;
                        break;
                    default:
                        System.out.println("Tháng không có trong dữ liệu");
                    return;
                }
                break;
            case 2014:
                switch (thang) {
                    case 1:
                        tenthang = "January";
                        n = 2;
                        m = 31;
                        break;
                    case 2:
                        tenthang = "January";
                        n = 2;
                        m = 28;
                        break;
                    default:
                        System.out.println("Tháng không có trong dữ liệu");
                    return;
                }
                break;
            default:
                System.out.println("Năm không có trong dữ liệu");
            return;
        }

        System.out.println("       " + tenthang + " " + nam);
        System.out.println(" ---------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
        for (int j = 1; j <= m; j++) {
            if (j < 10) {
                System.out.print("   " + j);
            } else {
                System.out.print("  " + j);
            }
            if ((j + n) % 7 == 0) {
                System.out.println();
            }
        }

    }
}

