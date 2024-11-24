package exercise.bai4;

public class Bai2 {
    public static void main(String[] args) {
        int n = 625;
        for (int i = 1; i <= n; i++) {
            double sum = 1 / (Math.sqrt(i) + Math.sqrt(i + 1));
            System.out.println(sum);
        }
    }
}
