package lesson.lesson6.BaiTap;


import java.util.Scanner;

public class ManagerAnimal {


    public static void danhSachAnimal() {
        Scanner scanner = new Scanner(System.in);
        int danhSach;
        do {
            System.out.println("chon");
            System.out.println("1. Lion");
            System.out.println("2. Elephant");
            System.out.println("3. Monkey");
            System.out.println("4. Dừng nhập vào");
            System.out.print("chon (1/2/3/4): ");
            danhSach = scanner.nextInt();
            switch (danhSach) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Exit!!!");
                    break;
                default:
                    System.out.println("nhập lại");
                    break;
            }

        } while (danhSach != 4);
    }
}
