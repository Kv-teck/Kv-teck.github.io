package exercise.bai4;

public class Bai4 {
    public static void main(String[] args) {
        int limit = 10000;

        for (int num = 1; num < limit; num++) {
            int sum = 0;

            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }

            if (sum == num) {
                System.out.println(num);
            }
        }
    }
}
