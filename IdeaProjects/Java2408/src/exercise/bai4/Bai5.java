package exercise.bai4;

public class Bai5 {
    public static void main(String[] args) {
        int n = 7;
        double e =0;
        for (int i = 1; i <= n; i++) {
            e = e + (1.0 / (getFactorial(i)));
            System.out.println(e);
        }
    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}
