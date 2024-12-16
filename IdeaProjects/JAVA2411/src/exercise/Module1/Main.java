package exercise.Module1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager(0);
        Scanner sc = new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Quản Lý Danh Sách Sinh Viên");
            System.out.println("1. Thêm sinh viên vào danh sách.");
            System.out.println("2. Sửa thông tin sinh viên.");
            System.out.println("3. Xóa sinh viên khỏi danh sách.");
            System.out.println("4. Tìm kiếm sinh viên theo tên.");
            System.out.println("5. Hiển thị danh sách sinh viên.");
            System.out.println("6. Thoát.");
            System.out.print("Chọn chức năng: ");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    studentManager.addStudent();
                    break;
                case 2:
                    studentManager.editStudent();
                    break;
                case 3:
                    studentManager.delete();
                    break;
                case 4:
                    studentManager.search();
                    break;
                case 5:
                    studentManager.showAllStudents();
                    break;
                case 6:
                    System.out.println("Đã thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Vui lòng chọn lại chức năng");
            }
        } while (menu != 6);

        sc.close();
    }
}
