import java.util.Scanner //Library yang berfungsi untuk menerima inputan dari user

public class TugasPBO {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        // Deklarasi Variabel
        String nama, alamat;
        char jk;
        int usia;
        double tinggi, berat, bmi;

        // Input Data
        System.out.print("Nama : ");
        nama = input.nextLine();

        System.out.print("Jenis Kelamin : ");
        jk = input.next().charAt(0);

        System.out.print("Umut : ");
        usia = input.nextInt();
        input.nextLine(); // Trik agar bisa menginputkan Data setelahnya

        System.out.print("Alamat : ");
        alamat = input.nextLine();

        System.out.print("Tinggi Badan (cm) : ");
        tinggi = input.nextDouble();
        tinggi /= 100; // Nilai var tinggi dibagi 100
        tinggi *= tinggi; // Nilai var tinggi dikali var tinggi

        System.out.print("Berat Badan (kg) : ");
        berat = input.nextDouble();

        System.out.println("=======Output=======");
        System.out.println("Nama : " + nama);
        System.out.println("JK : " + jk);
        System.out.println("Umur : " + usia);
        System.out.println("Alamat : " + alamat);
        bmi = berat / tinggi; // Operasi Pembagian untuk mendapatkan BMI
        System.out.print("BMI (Body Mass Index) anda : ");
        System.out.printf("%.1f %n", bmi); // Membulatkan Hasil Desimal var BMI 1 angka dibelakang koma

        switch (jk) {
            case 'P':
                if (bmi < 17) {
                    System.out.println("BERAT BADAN ANDA MENUNJUKAN KURUS");
                } else if (bmi > 17 && bmi <= 23) {
                    System.out.println("SELAMAT BERAT BADAN ANDA NORMAL");
                } else if (bmi > 23 && bmi <= 27) {
                    System.out.println("BERAT BADAN ANDA MENUNJUKAN GEMUK");
                } else if (bmi > 27) {
                    System.out.println("PERINGATAN ANDA MENGALAMI OBESITAS");
                }
                break;
            case 'L':
                if (bmi < 18) {
                    System.out.print("BERAT BADAN ANDA MENUNJUKAN KURUS");
                } else if (bmi > 18 && bmi <= 25) {
                    System.out.print("SELAMAT BERAT BADAN ANDA NORMAL");
                } else if (bmi > 25 && bmi <= 27) {
                    System.out.print("BERAT BADAN ANDA MENUNJUKAN GEMUK");
                } else if (bmi > 27) {
                    System.out.print("PERINGATAN ANDA MENGALAMI OBESITAS");
                }
                break;
        }
    }

}
