package Child;
import Parent.Buku;

public class BukuMajalah extends Buku {
    private String nomorEdisi;

    public BukuMajalah(String judul, String nomorEdisi, double hargaBeli, double hargaJual, int jumlahStok) {
        super(judul, hargaBeli, hargaJual, jumlahStok);
        this.nomorEdisi = nomorEdisi;
    }

    public String getNomorEdisi() {
        return nomorEdisi;
    }
}
