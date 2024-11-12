
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        bai_3();
    }

    static void bai_1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 1; j--) {
                if (i < j) {
                    System.out.print(" ");
                } else {
                    System.out.print(j);
                }
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    static void bai_2() {
        int n = 99;
        double sum = 0.0;
        for (int i = 1; i < n; i = i + 2) {
            sum = (i / (double) (i + 2)) + sum;
        }
        System.out.println(sum);
    }

    static void bai_3() {
        System.out.println(2013);
        System.out.println("------------------------------");
        System.out.println(" sun mon tue wed thu fri sat");
        int n = 2;
        for (int i = -1; i <= n; i++) {
            System.out.print("  ");
        }
        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                System.out.print("   " + i);
            } else {
                System.out.print("  " + i);
            }
            if ((i + n) % 7 == 0) {
                System.out.println();
            }
        }
    }

    static void bai_4() {
        int n = 625;
        double sum;
        for (int i = 1; i <= n; i++) {
            sum = 1 / (Math.sqrt(i) + Math.sqrt(i + 1));
            System.out.println(sum);
        }
    }

    static void bai_5() {
        double n = 0;
        while (Math.pow(n, 2) <= 12000) {
            n++;
        }
        System.out.println((int) n);

        double m = 0;
        while (Math.pow(m, 3) < 12000) {
            m++;
        }
        System.out.println((int) m);
    }

}