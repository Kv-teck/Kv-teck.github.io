package exercise.Module2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh Sách Chức Năng");
        System.out.println("1. Quản lý tài khoản: ");
        System.out.println("2. Giao dịch tài khoản: ");
        System.out.println("3. Quản lý giao dịch: ");
        System.out.println("4. Quản lý nhân viên: ");
        System.out.println("5. Thoát chương trình: ");
        System.out.print("Chọn chức năng <1/2/3/4/5>_");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("-----------------------");
                System.out.println("1. Thêm tài khoản mới.");
                System.out.println("2. Sửa thông tin tài khoản.");
                System.out.println("3. Xóa tài khoản.");
                System.out.println("4. Tìm kiếm tài khoản.");
                System.out.print("Chọn chức năng <1/2/3/4>_");
                int quanLy = sc.nextInt();
                switch (quanLy) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                break;
            case 2:
                System.out.println("-----------------------");
                System.out.println("1. Nạp tiền vào tài khoản.");
                System.out.println("2. Rút tiền từ tài khoản.");
                System.out.println("3. Chuyển khoản giữa hai tài khoản.");
                System.out.print("Chọn chức năng <1/2/3>_");
                int giaoDich = sc.nextInt();
                switch (giaoDich) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
                break;
            case 3:
                System.out.println("-----------------------");
                System.out.println("1. Hiển thị lịch sử giao dịch của một tài khoản.");
                System.out.println("2. Hiển thị toàn bộ giao dịch trong hệ thống.");
                System.out.print("Chọn chức năng <1/2>_");
                int quanLyGiaoDich = sc.nextInt();
                switch (quanLyGiaoDich) {
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case 4:
                System.out.println("-----------------------");
                System.out.println("1. Thêm nhân viên mới.");
                System.out.println("2. Xem danh sách nhân viên.");
                System.out.println("3. Gán tài khoản cho nhân viên.");
                System.out.print("Chọn chức năng <1/2/3>_");
                break;
            case 5:
                System.out.println("Thoát khỏi hệ thống");
                break;
        }

    }
}
