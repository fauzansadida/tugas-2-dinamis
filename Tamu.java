public class Tamu {
    private String nama;
    private String nomorTelepon;
    private String email;

    public Tamu(String nama, String nomorTelepon, String email) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getEmail() {
        return email;
    }
}
