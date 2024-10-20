package exercise.bai3;

public class Bai6 {
    //    Cần có tổng 200.000đ từ 3 loại giấy bạc 1000đ, 2000đ, và 5000đ. Lập
//    chương tình để tìm tất cả các phương án có thể.
    public static void main(String[] args) {
        int tien1k, tien2k, tien5k;
        int phuongan = 0;
        for (tien1k = 0; tien1k <= 200; tien1k++) {
            for (tien2k = 0; tien2k <= 100; tien2k++) {
                for (tien5k = 0; tien5k <= 40; tien5k++) {

                    int sum = tien1k * 1000 + tien2k * 2000 + tien5k * 5000;
                    if (sum == 200000) {
                        phuongan++;
                        System.out.println(phuongan + " " + "Tiền1k:" + tien1k + " " + "Tiền2k:" + tien2k + " " + "Tiền5k:" + tien5k);
                    }
                }
            }
        }
    }
}
