package exercise.Module2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        int type = 0;
        do {
            System.out.println("Danh Sách Chức Năng");
            System.out.println("1. Quản lý tài khoản: ");
            System.out.println("2. Giao dịch tài khoản: ");
            System.out.println("3. Quản lý giao dịch: ");
            System.out.println("4. Quản lý nhân viên: ");
            System.out.println("5. Thoát chương trình: ");
            System.out.print("Chọn chức năng <1/2/3/4/5>_");
            type = getType();
            try {
                switch (type) {
                    case 1:
                        manager.quanLyTaiKhoan();
                        break;
                    case 2:
                        manager.giaoDichTaiKhoan();
                        break;
                    case 3:
                        manager.quanLyGiaoDich();
                        break;
                    case 4:
                        manager.quanLyNhanVien();
                        break;
                    case 5:
                        System.out.println("Thoát khỏi hệ thống");
                        break;
                    default:
                        System.out.println("Vui lòng chọn lại chức năng");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                type = 0;
            }
        } while (type != 5);
    }

    public static int getType() {
        try {
            int type = new Scanner(System.in).nextInt();
            return type;
        } catch (Exception e) {
            System.out.println("Lỗi");
            return 0;
        }
    }
}
