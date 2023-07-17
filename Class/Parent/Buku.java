package Parent;

public class Buku {
    protected String judul;
    public double hargaBeli;
    public double hargaJual;
    protected int jumlahStok;

    public Buku(String judul, double hargaBeli, double hargaJual, int jumlahStok) {
        this.judul = judul;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.jumlahStok = jumlahStok;
    }

    public void tambahStok(int jumlah) {
        jumlahStok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        jumlahStok -= jumlah;
        if (jumlahStok <= 0) {
            System.out.println("Stok sudah mencapai nol!");
        }
    }

    public String getJudul() {
        return judul;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

}
