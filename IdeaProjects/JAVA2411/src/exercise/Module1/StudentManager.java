package exercise.Module1;

import java.util.Scanner;

public class StudentManager extends Student {

    private Student[] students;
    private int currentStudent;
    private int totalStudents;
    private final int DEFAULT_NEW_SIZE = 10;

    public StudentManager(int totalStudents) {
        this.totalStudents = totalStudents;
        students = new Student[this.totalStudents];
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < currentStudent; i++) {

            if (!name.equalsIgnoreCase(students[i].getName())) {
                continue;
            }
            System.out.println("Kết quả tìm kiếm:");
            students[i].showInfo();
        }
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên cần xóa: ");
        String maSinhVienCanXoa = scanner.nextLine();
        for (int i = 0; i < currentStudent; i++) {
            if (students[i] == null) {
                continue;
            }
            if (!maSinhVienCanXoa.equalsIgnoreCase(students[i].getMaSV())) {
                continue;
            }
            for (int j = i; j < currentStudent; j++) {
                if (j == currentStudent - 1) {
                    students[j] = null;
                } else {
                    students[j] = students[j + 1];
                }
                System.out.println("Sinh viên đã được xóa khỏi danh sách.");
            }
            this.currentStudent--;
        }
    }

    public void editStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String maSinhVienCanSua = scanner.nextLine();

        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getMaSV().equals(maSinhVienCanSua)) {
                System.out.println("Thông tin sinh viên hiện tại:");
                System.out.println("------------------------------------");
                System.out.println("Mã sinh viên: " + students[i].getMaSV());
                System.out.println("Tên: " + students[i].getName());
                System.out.println("Tuổi: " + students[i].getAge());

                System.out.print("Nhập tên sinh viên chỉnh sửa: ");
                String newStudentName = scanner.nextLine();
                System.out.print("Nhập tuổi sinh viên chỉnh sửa: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                students[i].setName(newStudentName);
                students[i].setAge(newAge);

                System.out.println("Thông tin sinh viên đã được cập nhật");
                System.out.println("------------------------------------");
                System.out.println("Tên sinh viên chỉnh sửa: " + newStudentName);
                System.out.println("Tuổi sinh viên chỉnh sửa: " + newAge);
                System.out.println("Mã sinh viên: " + students[i].getMaSV());
                System.out.println("------------------------------------");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với mã " + maSinhVienCanSua);
    }

    public void showAllStudents() {
        for (int i = 0; i < currentStudent; i++) {
            if (students[i] == null) {
                continue;
            }
            System.out.println("Danh sách sinh viên hiện tại:");
            students[i].showInfo();
        }
    }


    public void addStudent() {
        System.out.println("Thêm sinh viên vào danh sách");
        int type = 0;
        boolean isAdded = false;
        do {
            System.out.println("1: Nhập sinh viên");
            System.out.println("2: Dừng nhập");
            type = new Scanner(System.in).nextInt();
            Student student = null;
            switch (type) {
                case 1:
                    student = new Student();
                    isAdded = false;
                    break;
                case 2:
                    System.out.println("Dừng nhập!");
                    break;
                default:
                    System.out.println("Nhập sai định dạng, đề nghị nhập lại");
                    type = 1;
            }
            if (student != null) {
                student.enterInfo();
                for (int i = 0; i < currentStudent; i++) {
                    if (students[i].getMaSV().equals(student.getMaSV())) {
                        System.out.println("Mã sinh viên đã tồn tại, không thể thêm sinh viên.");
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) {
                    reSizeArrayStudent();
                    this.students[currentStudent] = student;
                    this.currentStudent++;
                    System.out.println("Sinh viên thứ :" + currentStudent + " đã được thêm vào danh sách");
                    isAdded = true;
                }
            }
        } while (type != 2 || !isAdded);
    }

    public void reSizeArrayStudent() {
        if (currentStudent == totalStudents) {
            this.totalStudents = this.totalStudents + DEFAULT_NEW_SIZE;
            this.students = copyArray(totalStudents, this.students);
        }
    }

    public Student[] copyArray(int newSize, Student[] oldArray) {
        Student[] newArray = new Student[newSize];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }
}
