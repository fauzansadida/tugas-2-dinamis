public class Kamar {
    private String tipeKamar;
    private double hargaPerMalam;

    public Kamar(String tipeKamar, double hargaPerMalam) {
        this.tipeKamar = tipeKamar;
        this.hargaPerMalam = hargaPerMalam;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }
}
