package exercise.bai4;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập 12 chữ số đầu của ISBN-13: ");
        String isbn = scanner.nextLine();


        if (isbn.length() != 12) {
            System.out.println("Chuỗi phải có đúng 12 ký tự.");
            return;
        }
        int digit13 = 0;
        for (int d = 1; d <= isbn.length(); d++) {
            int value = Character.getNumericValue(isbn.charAt(d - 1));

            if (d % 2 == 0) {
                digit13 = digit13 + 3 * value;
            } else {
                digit13 = digit13 + value;
            }
        }
        digit13 = 10 - digit13 % 10;
        if (digit13 == 10) {
            digit13 = 0;
        }

        System.out.println("ISBN-13 đầy đủ là: " + isbn + digit13);
        scanner.close();
    }
}
