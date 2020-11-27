
class Komik {

    String judul, penulis;
    int harga;

    Komik(String judul, String penulis, int harga) {
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
    }

    Komik() {
        judul = "Unknown";
        penulis = "Unknown";
        harga = 0;
    }

    void cetak() {
        System.out.println("\n\nData Input Komik Anda: ");
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Harga: Rp " + harga);
    }

    void cetak(int bayar) {
        System.out.println("\nUang anda: Rp " + bayar);
        System.out.println("Harga Komik: Rp " + harga);
        System.out.println("Kembalian anda: Rp " + (bayar - harga));
    }

}

public class App {
    public static void main(String[] args) throws Exception {

        // Komik komik1 = new Komik("Naruto", "Masashi Kisihimoto", 20000);
        Komik komik1 = new Komik();
        komik1.cetak();
        komik1.cetak(50000);
    }
}
