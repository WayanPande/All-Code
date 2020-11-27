
import javafundamental.basic.Gitar;


public class App {
    public static void main(String[] args) throws Exception {
        tower(3, 'A', 'C', 'B');
    System.out.println();
        Gitar.bunyi();
    }

    public static void tower(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("(" + from + "-" + to + ")");
            return;
        }
        tower(n - 1, from, aux, to);
        System.out.println("(" + from + "-" + to + ")");
        tower(n - 1, aux, to, from);
    }
}
