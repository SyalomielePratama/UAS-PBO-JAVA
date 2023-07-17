package Main;
import java.util.Scanner;
import Child.BukuFiksi;
import Child.BukuNonFiksi;
import Child.BukuMajalah;

public class ManajemenPenjualanBuku {
    private double modalAwal;
    private double modalBerjalan;
    private BukuFiksi bukuFiksi;
    private BukuNonFiksi bukuNonFiksi;
    private BukuMajalah bukuMajalah;

    public ManajemenPenjualanBuku(double modalAwal) {
        this.modalAwal = modalAwal;
        this.modalBerjalan = modalAwal;
        this.bukuFiksi = new BukuFiksi("Buku Fiksi", 15000, 20000, 5);
        this.bukuNonFiksi = new BukuNonFiksi("Buku Non Fiksi", 20000, 25000, 10);
        this.bukuMajalah = new BukuMajalah("Buku Majalah", "Edisi Buku: 1", 10000, 15000, 3);
    }

    public void tampilkanLaporan() {
        System.out.println("Modal Awal: " + modalAwal);
        System.out.println("Modal Berjalan: " + modalBerjalan);
    }

    public void tampilkanStokBuku() {
        System.out.println("Stok Buku Fiksi: " + bukuFiksi.getJumlahStok());
        System.out.println("Stok Buku Non Fiksi: " + bukuNonFiksi.getJumlahStok());
        System.out.println("Stok Majalah: " + bukuMajalah.getJumlahStok()+ "," + bukuMajalah.getNomorEdisi());
    }

    public void penjualanBuku() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jenis buku yang terjual (Fiksi/non/majalah): ");
        String judulBuku = "buku "+ scanner.nextLine();
        System.out.print("Masukkan jumlah buku yang terjual: ");
        int jumlahBuku = scanner.nextInt();

        if (judulBuku.equalsIgnoreCase(bukuFiksi.getJudul())) {
            if (jumlahBuku <= bukuFiksi.getJumlahStok()) {
                double totalHarga = bukuFiksi.hargaJual * jumlahBuku;
                modalBerjalan += totalHarga;
                bukuFiksi.kurangiStok(jumlahBuku);
                System.out.println("Penjualan sukses. Total harga: " + totalHarga);
            } else {
                System.out.println("Stok tidak mencukupi.");
            }
        } else if (judulBuku.equalsIgnoreCase(bukuNonFiksi.getJudul())) {
            if (jumlahBuku <= bukuNonFiksi.getJumlahStok()) {
                double totalHarga = bukuNonFiksi.hargaJual * jumlahBuku;
                modalBerjalan += totalHarga;
                bukuNonFiksi.kurangiStok(jumlahBuku);
                System.out.println("Penjualan sukses. Total harga: " + totalHarga);
            } else {
                System.out.println("Stok tidak mencukupi.");
            }
        } else if (judulBuku.equalsIgnoreCase(bukuMajalah.getJudul())) {
            if (jumlahBuku <= bukuMajalah.getJumlahStok()) {
                double totalHarga = bukuMajalah.hargaJual * jumlahBuku;
                modalBerjalan += totalHarga;
                bukuMajalah.kurangiStok(jumlahBuku);
                System.out.println("Penjualan sukses. Total harga: " + totalHarga);
            } else {
                System.out.println("Stok tidak mencukupi.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void pembelianBuku() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jenis buku yang dibeli (Fiksi/non/majalah): ");
        String judulBuku = "buku "+scanner.nextLine();
        System.out.print("Masukkan jumlah buku yang dibeli: ");
        int jumlahBuku = scanner.nextInt();

        if (judulBuku.equalsIgnoreCase(bukuFiksi.getJudul())) {
            double totalHarga = bukuFiksi.hargaBeli * jumlahBuku;
            if (modalBerjalan >= totalHarga) {
                modalBerjalan -= totalHarga;
                bukuFiksi.tambahStok(jumlahBuku);
                System.out.println("Pembelian sukses. Total harga: " + totalHarga);
            } else {
                System.out.println("Modal tidak mencukupi.");
            }
        } else if (judulBuku.equalsIgnoreCase(bukuNonFiksi.getJudul())) {
            double totalHarga = bukuNonFiksi.hargaBeli * jumlahBuku;
            if (modalBerjalan >= totalHarga) {
                modalBerjalan -= totalHarga;
                bukuNonFiksi.tambahStok(jumlahBuku);
                System.out.println("Pembelian sukses. Total harga: " + totalHarga);
            } else {
                System.out.println("Modal tidak mencukupi.");
            }
        } else if (judulBuku.equalsIgnoreCase(bukuMajalah.getJudul())) {
            double totalHarga = bukuMajalah.hargaBeli * jumlahBuku;
            if (modalBerjalan >= totalHarga) {
                modalBerjalan -= totalHarga;
                bukuMajalah.tambahStok(jumlahBuku);
                System.out.println("Pembelian sukses. Total harga: " + totalHarga);
            } else {
                System.out.println("Modal tidak mencukupi.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManajemenPenjualanBuku manajemen = new ManajemenPenjualanBuku(1000000);

        int pilihan = 0;
        while (pilihan != 5) {
            System.out.println("******************************************");
            System.out.println("Sistem Penjualan Buku");
            System.out.println("By: Syalomiele Pratama A.S , NIM: 22201212");
            System.out.println("******************************************");
            System.out.println("1. Beli Buku");
            System.out.println("2. Jual Buku");
            System.out.println("3. Lihat Stok Buku");
            System.out.println("4. Lihat Laporan Keuangan");
            System.out.println("5. Exit");
            System.out.print("Pilihan Menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    manajemen.pembelianBuku();
                    break;
                case 2:
                    manajemen.penjualanBuku();
                    break;
                case 3:
                    manajemen.tampilkanStokBuku();
                    break;
                case 4:
                    manajemen.tampilkanLaporan();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
