package exercise.Module1;

import java.util.Scanner;

public class Student {
    private String name;
    private Integer age;
    private String maSV;

    public void showInfo(){
        System.out.println("Mã sinh viên: " + this.maSV);
        System.out.println("Tên: " + this.name);
        System.out.println("Tuổi: " + this.age);
    }

    public void enterInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên: ");
        this.name = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên: ");
        this.age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập mã sinh viên: ");
        this.maSV = scanner.nextLine();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
}
