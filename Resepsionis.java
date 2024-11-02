public class Resepsionis {
    private String nama;

    public Resepsionis(String nama) {
        this.nama = nama;
    }

    public void tanganiReservasi(Tamu tamu, Kamar kamar, int jumlahMalam, Fasilitas... fasilitas) {
        System.out.println("Resepsionis " + nama + " sedang menangani reservasi untuk " + tamu.getNama());
        System.out.println("Tipe Kamar: " + kamar.getTipeKamar());

        double totalBiaya = hitungTotalBiaya(kamar, jumlahMalam, fasilitas);
        System.out.println("Total Biaya: " + totalBiaya);
        System.out.println("Reservasi berhasil untuk " + tamu.getNama() + " dengan tipe kamar " + kamar.getTipeKamar());
    }

    private double hitungTotalBiaya(Kamar kamar, int jumlahMalam, Fasilitas... fasilitas) {
        double totalBiaya = jumlahMalam * kamar.getHargaPerMalam();
        for (Fasilitas f : fasilitas) {
            totalBiaya += f.getHarga();
        }
        return totalBiaya;
    }
}
