
final class Lojik {

    public static final int a = 1;

    public static void tes() {
        System.out.println("lojik aih");
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        // int c;
        // for (int i = 2; i <= 100; i++) {
        // c = 0;

        // for (int j = 1; j < i; j++) {
        // if (i % j == 0) {
        // c++;
        // }
        // }
        // if (c < 2) {
        // System.out.println(i);
        // }
        // }
        Lojik asd = new Lojik();
        Lojik.a = 4;
        System.out.println(Lojik.a);
        asd.tes();

    }
}
