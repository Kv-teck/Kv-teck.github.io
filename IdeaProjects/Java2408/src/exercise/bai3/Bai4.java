package exercise.bai3;

public class Bai4 {
    //    Viết lại chữ số đảo ngược
//    Ví dụ nhập vào số 1357 thì in ra số đảo ngược là 7531
//            (Không sử dụng nhập vào chuỗi số là String)
    public static void main(String[] args) {
        int n = 1357;
        System.out.println("Giá trị ban đầu của n là: " + n);
        int sum = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            sum = sum * 10 + lastDigit;
            n /= 10;
        }
        System.out.println("Số đảo ngược là: " + sum);
    }

}
