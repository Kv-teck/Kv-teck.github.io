package lesson6;

public class MainPhanSo {
    public static void main(String[] args) {
        Phanso a = new Phanso();
        Phanso b = new Phanso();

        a.nhapPhanso();
        b.nhapPhanso();

        a.cong(b);
        a.nhan(b);
        a.tru(b);
        a.chia(b);
    }
}
