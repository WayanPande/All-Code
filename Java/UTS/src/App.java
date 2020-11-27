import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int jum;
        String metode;
        int bilangan[] = new int[10];
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan jumlah bilangan: ");
        jum = input.nextInt();
        input.nextLine();
        System.out.print("Metode pengurutan: ");
        metode = input.nextLine();
        for (int i = 0; i < jum; i++) {
            System.out.print("Bilangan: ");
            bilangan[i] = input.nextInt();
        }
        urut(bilangan, jum, metode);
    }

    static void cetak(int bilangan[], int jum, String metode) {

        if (metode.equals("asc")) {
            System.out.print("Hasil pengurutan secara ASC:");
            for (int i = 0; i < jum; i++) {
                System.out.print(" " + bilangan[i]);
            }
        } else {
            System.out.print("Hasil pengurutan secara Desc:");
            for (int i = jum - 1; i >= 0; i--) {
                System.out.print(" " + bilangan[i]);
            }
        }

        System.out.print("\nList Bilangan Genap adalah: ");
        for (int i = 0; i < jum; i++) {
            if (bilangan[i] % 2 == 0) {
                System.out.print(" " + bilangan[i]);
            }
        }
        System.out.print("\nList Bilangan Ganjil adalah: ");
        for (int i = 0; i < jum; i++) {
            if (bilangan[i] % 2 != 0) {
                System.out.print(" " + bilangan[i]);
            }
        }
        rata(bilangan, jum);
    }

    static void rata(int bilangan[], int jum) {
        int jumGenap = 0;
        int jumGanjil = 0;
        int totalGenap = 0, totalGanjil = 0;

        for (int i = 0; i < jum; i++) {
            if (bilangan[i] % 2 == 0) {
                totalGenap = totalGenap + bilangan[i];
                jumGenap++;
            } else {
                totalGanjil = totalGanjil + bilangan[i];
                jumGanjil++;
            }
        }
        System.out.println("\nRata-rata bilangan Genap adalah: " + totalGenap / jumGenap);
        System.out.println("Rata-rata bilangan Ganjil adalah: " + totalGanjil / jumGanjil);
    }

    static void urut(int bilangan[], int jum, String metode) {
        for (int i = 0; i < jum; i++) {
            for (int j = i; j < jum; j++) {
                if (bilangan[j] < bilangan[i]) {
                    int temp = bilangan[j];
                    bilangan[j] = bilangan[i];
                    bilangan[i] = temp;
                }
            }
        }
        cetak(bilangan, jum, metode);
    }
}
