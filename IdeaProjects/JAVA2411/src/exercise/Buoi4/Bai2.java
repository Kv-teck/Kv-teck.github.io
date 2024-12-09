package exercise.Buoi4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai2 {
    /*
        Viết Hàm hiểm tra 1 chuỗi String nhập vào có phải 1 số điện thoại hay không?
        Với các yêu cầu như sau:
      •	Số điện thoại có 9 số (không bao gồm số 0 ở đầu tức là có thể là +84xxxxxxxxx hoặc 0xxxxxxxxx hoặc 84xxxxxxxxx)
      •	Số điện thoại có thể chứa các ký tự như – hoặc .( Ví dụ 0xxx.xxx.xxx hoặc 0xxx-xxx-xxx)
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so de kiem tra có phải so dien thoai không");
        String n = scanner.nextLine();
        if (!isValidPhoneNumber(n)) {
            System.out.println(n + " Khong phai so dien thoai");
        } else {
            System.out.println(n + " La so dien thoai");
        }

    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Biểu thức chính quy kiểm tra số điện thoại hợp lệ
        String regex = "^(\\+84|84|0)(\\d{9}|\\d{3}[\\.\\-]?\\d{3}[\\.\\-]?\\d{3})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
