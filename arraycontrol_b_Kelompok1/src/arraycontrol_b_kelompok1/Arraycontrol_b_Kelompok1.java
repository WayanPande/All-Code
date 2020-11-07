package arraycontrol_b_kelompok1;

import java.io.*;

public class Arraycontrol_b_Kelompok1 {
    public static void main(String[] args) throws IOException {
        int m, n, p, q, pilih, i, j, k;
        int keluar = 0;
        int[][] array = new int[100][100];
        int[][] arrays = new int[100][100];
        int[][] hasil = new int[100][100];
        String pilihan;

        System.out.println("\nSilakan pilih operasi:");
        System.out.println("\t1. Penjumlahan matriks");
        System.out.println("\t2. Pengurangan matriks");
        System.out.println("\t3. Perkalian matriks\n\n");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        pilihan = br.readLine();
        pilih = Integer.parseInt(pilihan);

        switch (pilih) {
            case 1:
                do {
                    System.out.println("Operasi yang Anda pilih adalah Penjumlahan");
                    System.out.println("\nMasukan matriks pertama:");
                    System.out.print("Ukuran Baris:");
                    pilihan = br.readLine();
                    m = Integer.parseInt(pilihan);
                    System.out.print("Ukuran kolom:");
                    pilihan = br.readLine();
                    n = Integer.parseInt(pilihan);
                    System.out.print("\n");
                    for (i = 1; i <= m; i++) {
                        for (j = 1; j <= n; j++) {
                            System.out.print("Baris " + i + " kolom " + j + " : ");
                            pilihan = br.readLine();
                            array[i][j] = Integer.parseInt(pilihan);
                        }
                    }
                    System.out.println("\nInput matriks anda :");
                    for (i = 1; i <= m; i++) {
                        for (j = 1; j <= n; j++) {
                            System.out.print(array[i][j] + "  ");
                        }
                        System.out.print("\n");
                    }

                    System.out.println("\nMasukan matriks kedua:");
                    System.out.print("Ukuran Baris:");
                    pilihan = br.readLine();
                    p = Integer.parseInt(pilihan);
                    System.out.print("Ukuran kolom:");
                    pilihan = br.readLine();
                    q = Integer.parseInt(pilihan);
                    System.out.print("\n");
                    for (i = 1; i <= p; i++) {
                        for (j = 1; j <= q; j++) {
                            System.out.print("Baris " + i + " kolom " + j + " : ");
                            pilihan = br.readLine();
                            arrays[i][j] = Integer.parseInt(pilihan);
                        }
                    }
                    System.out.println("\nInput matriks anda :");
                    for (i = 1; i <= p; i++) {
                        for (j = 1; j <= q; j++) {
                            System.out.print(arrays[i][j] + "  ");
                        }
                        System.out.print("\n");
                    }
                    if ((m == p) && (n == q)) {
                        for (i = 1; i <= m; i++) {
                            for (j = 1; j <= n; j++) {
                                hasil[i][j] = array[i][j] + arrays[i][j];
                            }
                        }
                        System.out.println("Hasil penjumlahan matriks diatas adalah");
                        for (i = 1; i <= m; i++) {
                            for (j = 1; j <= n; j++) {
                                System.out.print(hasil[i][j] + " ");
                            }
                            System.out.print("\n");
                        }
                        keluar = 1;
                    } else {
                        System.out.println("\nMaaf Matriks Yang Anda Masukan tidak memenuhi syarat");
                        System.out.println("Anda Harus mengulang input\n\n");
                    }
                } while (keluar == 0);
                break;
            case 2:
                do {
                    System.out.println("\nOperasi yang Anda pilih adalah Pengurangan");
                    System.out.println("\nMasukan matriks pertama:");
                    System.out.print("Ukuran Baris:");
                    pilihan = br.readLine();
                    m = Integer.parseInt(pilihan);
                    System.out.print("Ukuran kolom:");
                    pilihan = br.readLine();
                    n = Integer.parseInt(pilihan);
                    System.out.print("\n");
                    for (i = 1; i <= m; i++) {
                        for (j = 1; j <= n; j++) {
                            System.out.print("Baris " + i + " kolom " + j + " : ");
                            pilihan = br.readLine();
                            array[i][j] = Integer.parseInt(pilihan);
                        }
                    }
                    System.out.println("\nInput matriks anda :");
                    for (i = 1; i <= m; i++) {
                        for (j = 1; j <= n; j++) {
                            System.out.print(array[i][j] + "  ");
                        }
                        System.out.print("\n");
                    }

                    System.out.println("\nMasukan matriks kedua:");
                    System.out.print("Ukuran Baris:");
                    pilihan = br.readLine();
                    p = Integer.parseInt(pilihan);
                    System.out.print("Ukuran kolom:");
                    pilihan = br.readLine();
                    q = Integer.parseInt(pilihan);
                    System.out.print("\n");
                    for (i = 1; i <= p; i++) {
                        for (j = 1; j <= q; j++) {
                            System.out.print("Baris " + i + " kolom " + j + " : ");
                            pilihan = br.readLine();
                            arrays[i][j] = Integer.parseInt(pilihan);
                        }
                    }
                    System.out.println("\nInput matriks anda :");
                    for (i = 1; i <= p; i++) {
                        for (j = 1; j <= q; j++) {
                            System.out.print(arrays[i][j] + "  ");
                        }
                        System.out.print("\n");
                    }

                    if ((m == p) && (n == q)) {
                        for (i = 1; i <= m; i++) {
                            for (j = 1; j <= n; j++) {
                                hasil[i][j] = array[i][j] - arrays[i][j];
                            }
                        }
                        System.out.println("Hasil pengurangan matriks diatas adalah");
                        for (i = 1; i <= m; i++) {
                            for (j = 1; j <= n; j++) {
                                System.out.print(hasil[i][j] + " ");
                            }
                            System.out.print("\n");
                        }
                        keluar = 1;
                    } else {
                        System.out.println("\nMaaf Matriks Yang Anda Masukan tidak memenuhi syarat");
                        System.out.println("Anda Harus menginput ulang\n\n");
                    }
                } while (keluar == 0);
                break;
            case 3:
                do {
                    System.out.println("\nOperasi yang Anda pilih adalah Perkalian");
                    System.out.println("\nMasukan matriks pertama:");
                    System.out.print("Ukuran Baris:");
                    pilihan = br.readLine();
                    m = Integer.parseInt(pilihan);
                    System.out.print("Ukuran kolom:");
                    pilihan = br.readLine();
                    n = Integer.parseInt(pilihan);
                    System.out.print("\n");
                    for (i = 1; i <= m; i++) {
                        for (j = 1; j <= n; j++) {
                            System.out.print("Baris " + i + " kolom " + j + " : ");
                            pilihan = br.readLine();
                            array[i][j] = Integer.parseInt(pilihan);
                        }
                    }
                    System.out.println("\nInput matriks anda :");
                    for (i = 1; i <= m; i++) {
                        for (j = 1; j <= n; j++) {
                            System.out.print(array[i][j] + "  ");
                        }
                        System.out.print("\n");
                    }

                    System.out.println("\nMasukan matriks kedua:");
                    System.out.print("Ukuran Baris:");
                    pilihan = br.readLine();
                    p = Integer.parseInt(pilihan);
                    System.out.print("Ukuran kolom:");
                    pilihan = br.readLine();
                    q = Integer.parseInt(pilihan);
                    System.out.print("\n");
                    //
                    for (i = 1; i <= p; i++) {
                        for (j = 1; j <= q; j++) {
                            System.out.print("Baris " + i + " kolom " + j + " : ");
                            pilihan = br.readLine();
                            arrays[i][j] = Integer.parseInt(pilihan);
                        }
                    }
                    System.out.println("\nInput matriks anda :");
                    for (i = 1; i <= p; i++) {
                        for (j = 1; j <= q; j++) {
                            System.out.print(arrays[i][j] + "  ");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("Hasil perkalian matriks diatas adalah");
                    if (n == p) {
                        for (i = 1; i <= m; i++) {
                            for (j = 1; j <= q; j++) {
                                hasil[i][j] = 0;
                                for (k = 1; k <= n; k++) {
                                    hasil[i][j] = hasil[i][j] + (array[i][k] * arrays[k][j]);
                                }
                            }
                        }
                        for (i = 1; i <= m; i++) {
                            for (j = 1; j <= q; j++) {
                                System.out.print(hasil[i][j] + "  ");
                            }
                            System.out.print("\n");
                        }
                        keluar = 1;
                    } else {
                        System.out.println("\nMaaf Matriks Yang Anda Masukan tidak memenuhi syarat");
                        System.out.println("Anda harus menginput ulang\n");
                    }
                } while (keluar == 0);
                break;
            default: {
                System.out.println("Tidak ada pilihan ke-" + pilih);
            }
        }
    }

}
