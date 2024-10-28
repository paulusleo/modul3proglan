package tugas2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas Inventory digunakan untuk mengelola stok buah.
 * Kelas ini mengimplementasikan antarmuka Inventoryoperation dan mewarisi dari kelas Inventorysuperr.
 */
public class Inventory extends Inventorysuperr implements Inventoryoperation {

    /**
     * Menambahkan buah ke dalam daftar inventaris.
     * Meminta pengguna memasukkan nama buah dan jumlah stok,
     * lalu menambahkannya ke daftar buah dan stok.
     */
    @Override
    public void addFruit() {
        System.out.print("Masukkan nama buah: ");
        String fruit = scanner.nextLine();
        System.out.print("Masukkan stok buah: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        extracted(fruit);
        stock.add(quantity);
    }

    /**
     * Menambahkan nama buah ke daftar buah.
     * Metode ini adalah helper untuk menambahkan buah ke daftar.
     *
     * @param fruit Nama buah yang akan ditambahkan.
     */
    private void extracted(String fruit) {
        fruits.add(fruit);
    }

    /**
     * Menghapus buah dari daftar inventaris berdasarkan indeks.
     * Meminta pengguna memasukkan indeks buah yang akan dihapus.
     * Jika indeks valid, buah dan stok akan dihapus dari daftar.
     * Jika tidak, menampilkan pesan kesalahan.
     */
    @Override
    public void removeFruit() {
        System.out.print("Masukkan indeks buah yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (index >= 0 && index < fruits.size()) {
            fruits.remove(index);
            stock.remove(index);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    /**
     * Menampilkan daftar buah dan stok yang ada di inventaris.
     * Melalui perulangan, menampilkan nama buah dan jumlah stok di layar.
     */
    @Override
    public void displayFruits() {
        System.out.println("Daftar Buah dan Stok:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i) + " - " + stock.get(i) + " pcs");
        }
    }

    /**
     * Menyediakan menu interaktif bagi pengguna untuk mengelola inventaris.
     * Menu ini berisi opsi untuk menambah buah, menghapus buah, menampilkan daftar buah, dan keluar.
     */
    @Override
    public void menu() {
        while (true) {
            System.out.println("\n1. Tambah Buah\n2. Hapus Buah\n3. Lihat Daftar\n4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> addFruit();
                case 2 -> removeFruit();
                case 3 -> displayFruits();
                case 4 -> {
                    System.out.println("Keluar...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    /**
     * Metode utama untuk menjalankan program.
     * Membuat instance dari kelas Inventory dan memanggil metode menu.
     *
     * @param args Argumen baris perintah yang tidak digunakan.
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.menu();
    }
}
