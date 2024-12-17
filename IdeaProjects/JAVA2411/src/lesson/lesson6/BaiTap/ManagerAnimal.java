package lesson.lesson6.BaiTap;


import java.util.Scanner;

public class ManagerAnimal {

    private Animal[] animals;
    private int size;
    private Scanner scanner;

    public ManagerAnimal(int initialSize) {
        this.animals = new Animal[initialSize];
        this.size = 0;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int n = inputNumberAnimal();
        inputAnimal(n);
    }

    private int inputNumberAnimal() {
        System.out.print("Nhập số lượng động vật: ");
        return scanner.nextInt();
    }

    private void inputAnimal(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("1. Nhập vào Lion");
            System.out.println("2. Nhập vào Elephant");
            System.out.println("3. Nhập vào Monkey");
            System.out.println("4. Dừng nhập vào");
            System.out.println("Chọn (1/2/3/4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputLion();
                    break;
                case 2:
                    inputElephant();
                    break;
                case 3:
                    inputMonkey();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    public void inputLion(){
        System.out.print("Nhập tên Lion: ");
        String lionName = scanner.nextLine();
        System.out.print("Nhập tuổi Lion: ");
        int lionAge = scanner.nextInt();
    }    public void inputElephant(){
        System.out.print("Nhập tên Elephant: ");
        String elephantName = scanner.nextLine();
        System.out.print("Nhập tuổi Elephant: ");
        int elephantAge = scanner.nextInt();
    }    public void inputMonkey(){
        System.out.print("Nhập tên Monkey: ");
        String monkeyName = scanner.nextLine();
        System.out.print("Nhập tuổi Monkey: ");
        int monkeyAge = scanner.nextInt();
    }

}

