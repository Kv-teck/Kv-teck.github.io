package lesson.lesson3;

public class LoopFor {
    public static void main(String[] args) {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(i);
        }
        i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        i=0;
        do {
            System.out.println(i);
            i++;
        }while (i < 10);
    }
}
