public class App {
    public static void main(String[] args) throws Exception {
        int c;
        for (int i = 2; i <= 100; i++) {
            c = 0;

            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    c++;
                }
            }
            if (c < 2) {
                System.out.println(i);
            }
        }

    }
}
