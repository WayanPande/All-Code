import java.util.Scanner;

class Urut {

    public void urut(int[] num) {

        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                if (num[j] < num[i]) {
                    int temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }
        cetak(num);
    }

    public void cetak(int[] num) {
        for (int i : num) {
            System.out.println(i);
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[] num = new int[20];
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah angka: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Angka ke-" + (i + 1) + ": ");
            num[i] = sc.nextInt();
        }

        // for (int i : num) {
        // if (i != 0) {
        // System.out.println(i);
        // }

        // }
        Urut angka = new Urut();
        angka.urut(num);
    }
}
