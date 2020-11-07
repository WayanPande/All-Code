import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        towerOfHanoi(3, 'A', 'C', 'B');
    }

    public static void towerOfHanoi(int n, char from, char to, char aux) {

        if (n == 1) {
            System.out.print("(" + from + "-" + to + ") ");
        } else {
            towerOfHanoi(n - 1, from, aux, to);
            System.out.print("From: " + from + " TO: " + to + " N=: " + n);
            System.out.print(" (" + from + "-" + to + ") ");
            towerOfHanoi(n - 1, aux, to, from);
        }
    }

}
