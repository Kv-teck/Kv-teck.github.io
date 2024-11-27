package exercise.Buoi3;

public class Bai1 {
    public static void main(String[] args) {
//Cần có tổng 200.000đ từ 3 loại giấy bạc 1000đ, 2000đ, và 5000đ.
//Lập chương tình để tìm tất cả các phương án có thể sử dụng
// các mệnh giá trên để tạo ra tổng 200.000đ
        int motK = 1000;
        int haiK = 2000;
        int namK = 5000;

        int tong1k = 200;
        int tong2k = 100;
        int tong5k = 40;
        int tong3Loai = 200000;

        int phuongAn = 0;
        for (int giayBac1k = 0; giayBac1k <= tong1k; giayBac1k++) {
            for (int giayBac2k = 0; giayBac2k <= tong2k; giayBac2k++) {
                for (int giayBac5k = 0; giayBac5k <= tong5k; giayBac5k++) {
                    int tong = giayBac1k * motK + giayBac2k * haiK + giayBac5k * namK;
                    if (tong == tong3Loai) {
                        phuongAn++;
                    }
                }
            }
        }
        System.out.println(phuongAn);
    }
}
