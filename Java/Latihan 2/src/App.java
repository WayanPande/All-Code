import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        getWord("orange");
    }

    public static void getWord(String awal) {

        int temp = 0;
        char[] a = awal.toCharArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    temp++;
                }
            }
            if (temp > 1) {
                System.out.println("true");
                break;
            }
            temp = 0;
        }
        if (temp < 2) {
            System.out.println("false");
        }
    }
}
