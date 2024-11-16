import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Bai1();
    }

    private static void Bai1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the file: ");
        String name = sc.nextLine();
        System.out.println("Please enter the size of the file: ");
        int size = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the path of the file: ");
        String path = sc.nextLine();
        System.out.println("Please enter the extension of the file: ");
        String ext = sc.nextLine();


        sc.close();
    }
}