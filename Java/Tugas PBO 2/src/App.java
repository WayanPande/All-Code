public class App {
    public static void main(String[] args) {

        keliling();
        hitung();
    }

    public void keliling() {
        double pi = 3.1416, r = 2.12, keliling;

        keliling = 2 * pi * r;
        System.out.println("Keliling Lingkaran = " + keliling);
    }

    static void hitung() {
        byte a = 1;
        short b = 2;
        int c = 3, d;

        d = a + b + c;
        System.out.println("Hasil = " + d);
    }

}
