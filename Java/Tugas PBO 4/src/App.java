import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int[][] matriks1 = new int[50][50];
        int[][] matriks2 = new int[50][50];
        int[][] hasil = new int[50][50];
        int m, n, x, y, jumlah = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Masukan matriks pertrama: ");
        System.out.print("Baris: ");
        n = input.nextInt();
        System.out.print("Kolom: ");
        m = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Baris " + (i + 1) + " Kolom " + (j + 1) + ": ");
                matriks1[i][j] = input.nextInt();
            }
        }

        System.out.println("Masukan matriks Kedua: ");
        System.out.print("Baris: ");
        x = input.nextInt();
        System.out.print("Kolom: ");
        y = input.nextInt();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("Baris " + (i + 1) + " Kolom " + (j + 1) + ": ");
                matriks2[i][j] = input.nextInt();
            }
        }

        clearScreen();
        System.out.println("\nInput matriks pertama anda: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matriks1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nInput matriks kedua anda: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(matriks2[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < x; k++) {
                    jumlah = jumlah + matriks1[i][k] * matriks2[k][j];
                }
                hasil[i][j] = jumlah;
                jumlah = 0;
            }
        }

        System.out.println("\nHasil kali matriks kedua anda: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(hasil[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
