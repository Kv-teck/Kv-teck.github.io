package exercise.Module2;

import java.util.Scanner;

public class Manager {
    private final AccountManager am = new AccountManager();

    public void quanLyTaiKhoan() {
        int type = 0;
        do {
            System.out.println("-----------------------");
            System.out.println("1. Thêm tài khoản mới.");
            System.out.println("2. Sửa thông tin tài khoản.");
            System.out.println("3. Xóa tài khoản.");
            System.out.println("4. Tìm kiếm tài khoản.");
            System.out.println("5. Thoát quản lý tài khoản: ");
            System.out.print("Chọn chức năng <1/2/3/4/5>_");
            type = getType();
            try {

                switch (type) {
                    case 1:
                        am.addAccount();
                        break;
                    case 2:
                        am.updateAccount();
                        break;
                    case 3:
                        am.deleteAccount();
                        break;
                    case 4:
                        am.searchAccount();
                        break;
                    case 5:
                        System.out.println("Thoát");
                        break;
                    default:
                        System.out.println("Vui lòng chọn lại chức năng");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                type = 1;
            }
        } while (type != 5);
    }

    public void giaoDichTaiKhoan() {
        int type = 0;
        do {
            System.out.println("-----------------------");
            System.out.println("1. Nạp tiền vào tài khoản.");
            System.out.println("2. Rút tiền từ tài khoản.");
            System.out.println("3. Chuyển khoản giữa hai tài khoản.");
            System.out.println("4. Thoát giao dịch tài khoản.");
            System.out.print("Chọn chức năng <1/2/3/4>_");
            type = getType();
            try {
                switch (type) {
                    case 1:
                        am.deposit();
                        break;
                    case 2:
                        am.withdraw();
                        break;
                    case 3:
                        am.transfer();
                        break;
                    case 4:
                        System.out.println("Thoát");
                        break;
                    default:
                        System.out.println("Vui lòng chọn lại chức năng");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                type = 1;
            }
        } while (type != 4);

    }

    public void quanLyGiaoDich() {
        int type = 0;
        do {
            System.out.println("-----------------------");
            System.out.println("1. Hiển thị lịch sử giao dịch của một tài khoản.");
            System.out.println("2. Hiển thị toàn bộ giao dịch trong hệ thống.");
            System.out.println("3. Thoát quản lý giao dịch");
            System.out.print("Chọn chức năng <1/2/3>_");
            type = getType();
            try {
                switch (type) {
                    case 1:
                        am.showTransactionHistory();
                        break;
                    case 2:
                        am.showAllTransactions();
                        break;
                    case 3:
                        System.out.println("Thoát");
                        break;
                    default:
                        System.out.println("Vui lòng chọn lại chức năng");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                type = 1;
            }
        } while (type != 3);

    }

    public void quanLyNhanVien() {
        int type = 0;
        do {
            System.out.println("-----------------------");
            System.out.println("1. Thêm nhân viên mới.");
            System.out.println("2. Xem danh sách nhân viên.");
            System.out.println("3. Gán tài khoản cho nhân viên.");
            System.out.println("4. Thoát quản lý nhân viên");
            System.out.print("Chọn chức năng <1/2/3/4>_");
            type = getType();
            try {
                switch (type) {
                    case 1:
                        am.addEmployee();
                        break;
                    case 2:
                        am.showEmployee();
                        break;
                    case 3:
                        am.assignAccount();
                        break;
                    case 4:
                        System.out.println("Thoát");
                        break;
                    default:
                        System.out.println("Vui lòng chọn lại chức năng");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                type = 0;
            }
        } while (type != 4);

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
