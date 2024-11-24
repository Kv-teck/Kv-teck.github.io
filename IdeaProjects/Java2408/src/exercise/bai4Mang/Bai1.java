package exercise.bai4Mang;

import java.util.Arrays;
import java.util.Scanner;

public class Bai1 {
    //   Viết chương trình nhập mảng số nguyên từ bàn phím.
//       Sắp xếp và xuất mảng vừa nhập ra màn hình.
//       Xuất phần tử có giá trị nhỏ nhất ra màn hình
//       Tính và xuất ra màn hình trung bình cộng các phần tử chia hết cho 3
    public static void main(String[] args) {
        Bai_1();
    }

    static void Bai_1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong");
        int n = sc.nextInt();
        System.out.println("---------");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap so nguyen");
            arr[i] = sc.nextInt();

        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Phần tử có giá trị nhỏ nhất: " + min);

        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0) {
                sum += arr[i];
                count++;
            }
        }

        if (count > 0) {
            double avg = (double) sum / count;
            System.out.println("Trung bình cộng các phần tử chia hết cho 3: " + avg);
        } else {
            System.out.println("Không có phần tử nào chia hết cho 3.");
        }
        sc.close();
    }
}
