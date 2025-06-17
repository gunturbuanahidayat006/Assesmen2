import java.util.*;

class Paket {
    int id;
    String namaPelanggan;
    String alamat;
    int tanggalMasuk;
    String tipe;
    int tanggalSampai;

    public Paket(int id, String nama, int tanggal, String tipe, String alamat) {
        this.id = id;
        this.namaPelanggan = nama;
        this.tanggalMasuk = tanggal;
        this.tipe = tipe.toLowerCase(); 
        this.alamat = alamat;
        this.tanggalSampai = hitungTanggalSampai();
    }

    private int hitungTanggalSampai() {
        switch (tipe) {
            case "biasa": return tanggalMasuk + 3;
            case "express": return tanggalMasuk + 2;
            case "kilat": return tanggalMasuk + 1;
            case "same day": return tanggalMasuk;
            default: return tanggalMasuk; 
        }
    }

    public void tampilkan() {
        System.out.println("ID Paket: " + id + " namaPelanggan: " + namaPelanggan + 
            " alamatPelanggan: " + alamat);
    }
}

class DaftarPaket {
    ArrayList<Paket> daftar = new ArrayList<>();

    public void terimaKiriman(int id, String nama, int tanggal, String tipe, String alamat) {
        daftar.add(new Paket(id, nama, tanggal, tipe, alamat));
    }

    public void cetakDataPaket() {

        Collections.sort(daftar, Comparator.comparingInt(p -> p.tanggalSampai));
        System.out.println("Urutan paket harus diselesaikan:");
        for (Paket p : daftar) {
            p.tampilkan();
        }
    }
}

public class CobaAssesmen2 {
    public static void main(String[] args) {
        DaftarPaket daftarPaket = new DaftarPaket();

        daftarPaket.terimaKiriman(1, "Yuli", 5, "express", "Jl. Ciganitri no. 15");
        daftarPaket.terimaKiriman(2, "Kiki", 6, "kilat", "Jl. Pogor no. 11");
        daftarPaket.terimaKiriman(3, "Toto", 7, "biasa", "Jl. Sukabirus no. 15");
        daftarPaket.terimaKiriman(4, "Juni", 8, "express", "Jl. Telekomunikasi no. 2");
        daftarPaket.terimaKiriman(5, "Julia", 8, "same day", "Jl. Ciganitri no. 13");
        daftarPaket.terimaKiriman(6, "Agus", 9, "biasa", "Jl. Ciganitri no. 23");

        daftarPaket.cetakDataPaket();
    }
}
