import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int cari;

        System.out.println("Data pada array = {1,2,3,4,5,6,7,8,9}");
        Scanner n = new Scanner(System.in);
        System.out.print("Masukkan angka yang ingin dicari: ");
        cari = n.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cari) {
                System.out.println("Data ditemukan");
                break;
            }
        }

    }
}
