package com;

class Buku {

    public String nama;
    public int halaman;

    public void baca() {
        System.out.println("Nama buku: " + this.nama + " Jumlah Hal: " + this.halaman);
    }

    Buku(String nama) {

        this.nama = nama;
        this.halaman = 12;

    }

    public void ubahNama(String nama) {
        this.nama = nama;
    }

}

public class Main {

    public static void main(String[] args) throws Exception {

        // Buku komik = new Buku("kocak");
        // System.out.println(komik.nama);
        // System.out.println(komik.halaman);

        Buku game = new Buku();
        System.out.println(game.nama);
        game.ubahNama("Asep");
        System.out.println(game.nama);
    }

    public static int tambah(int num1, int num2) {
        return num1 + num2;
    }

}
