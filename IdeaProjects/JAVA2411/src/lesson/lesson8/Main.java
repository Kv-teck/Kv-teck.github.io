package lesson.lesson8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Các chức năng");
        System.out.println("1.Nhập thông tin công ty");
        System.out.println("2.Phân bổ nhân viên vào trưởng phòng");
        System.out.println("3.Thêm, xóa thông tin một nhân sự");
        System.out.println("12.Thoat");
        System.out.print("Chon chức năng: ");
        int n = scanner.nextInt();
        switch (n){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 12:

                break;

        }
    }
     public static void thongTinCty(){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Nhap ten Cty");
         String nameCty = scanner.nextLine();
         System.out.println("Nhap Mã số thuế của công ty");
         int maSoThueCty = scanner.nextInt();
         System.out.println("Nhap doanh thu của công ty trong tháng hiện tại");
         double doanhThuCty = scanner.nextDouble();

    }
}
