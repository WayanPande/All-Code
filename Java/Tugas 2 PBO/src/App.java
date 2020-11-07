class ContohPerhitungan {

    public byte a = 1;
    public short b = 2;
    public int c = 3, d;

    public ContohPerhitungan() {

        this.d = this.a + this.b + this.c;
        System.out.println("Hasil = " + this.d);
    }
}

class KelilingLingkaran {

    public double pi = 3.1416, r = 2.12, keliling;

    public KelilingLingkaran() {
        this.keliling = 2 * this.pi * this.r;
        System.out.println("Keliling Lingkaran = " + this.keliling);
    }
}

class DemoKarakter {
    public char ch1 = 65, ch2 = 'B';

    public DemoKarakter() {
        System.out.println("ch1 = " + this.ch1);
        System.out.println("ch2 = " + this.ch2);
    }

    public void ubah() {
        char ch = 'A';
        System.out.println("ch = " + ch);
        ch++;
        System.out.println("ch = " + ch);
    }
}

class DemoBoolean {
    public boolean b;

    DemoBoolean() {
        this.b = true;
        System.out.println("Nilai b = " + b);

        if (b) {a
            System.out.println("Statemen ke-1 dieksekusi");
        }

        this.b = false;
        System.out.println("Nilai b = " + b);

        if (b) {
            System.out.println("Statemen ke-2 tidak akan dieksekusi");
        }
        if (!b) {
            System.out.println("Statemen ke-3 dieksekusi");
        }
        System.out.println("5 <= 10 mengembalikan nilai " + (5 <= 10));
        System.out.println("4 > 6 mengembalikan nilai " + (4 > 6));
    }
}

public class App {
    public static void main(String[] args) throws Exception {

        ContohPerhitungan coba = new ContohPerhitungan();
        System.out.println("\n\n");
        KelilingLingkaran tes = new KelilingLingkaran();
        System.out.println("\n\n");
        DemoKarakter lol = new DemoKarakter();
        System.out.println("\n\n");
        lol.ubah();
        System.out.println("\n\n");
        DemoBoolean kocak = new DemoBoolean();

    }

}
