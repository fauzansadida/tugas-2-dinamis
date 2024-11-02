import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemManajemenHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek fasilitas
        List<Fasilitas> daftarFasilitas = new ArrayList<>();
        daftarFasilitas.add(new Fasilitas("WiFi", 10000));
        daftarFasilitas.add(new Fasilitas("Sarapan", 10000));
        daftarFasilitas.add(new Fasilitas("Parkir", 2000));

        // Membuat objek resepsionis
        Resepsionis resepsionis = new Resepsionis("Alice");

        while (true) {
            // Mengambil input dari pengguna
            System.out.println("Standar : 500000");
            System.out.println("Suites : 1000000");
            System.out.print("Masukkan nama tamu: ");
            String namaTamu = scanner.nextLine();

            System.out.print("Masukkan nomor telepon tamu: ");
            String nomorTelepon = scanner.nextLine();

            System.out.print("Masukkan email tamu: ");
            String email = scanner.nextLine();

            // Membuat objek tamu
            Tamu tamu = new Tamu(namaTamu, nomorTelepon, email);

            System.out.print("Pilih tipe kamar (Standar/Suite): ");
            String tipeKamar = scanner.nextLine();

            double hargaPerMalam = 0;
            Kamar kamar;
            if (tipeKamar.equalsIgnoreCase("Standar")) {
                kamar = new KamarStandar("Kamar Standar", 500000);
            } else if (tipeKamar.equalsIgnoreCase("Suite")) {
                kamar = new KamarSuite("Kamar Suite", 1000000);
            } else {
                System.out.println("Tipe kamar tidak valid.");
                continue; // Kembali ke awal loop
            }

            System.out.print("Masukkan jumlah malam: ");
            int jumlahMalam = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            // Memilih fasilitas
            List<Fasilitas> fasilitasPilihan = new ArrayList<>();
            String pilihFasilitas;
            do {
                System.out.println("Pilih fasilitas (ketik 'selesai' untuk selesai):");
                for (Fasilitas f : daftarFasilitas) {
                    System.out.println("- " + f.getNama() + " (Rp " + f.getHarga() + ")");
                }
                pilihFasilitas = scanner.nextLine();
                if (!pilihFasilitas.equalsIgnoreCase("selesai")) {
                    for (Fasilitas f : daftarFasilitas) {
                        if (f.getNama().equalsIgnoreCase(pilihFasilitas)) {
                            fasilitasPilihan.add(f);
                            break;
                        }
                    }
                }
            } while (!pilihFasilitas.equalsIgnoreCase("selesai"));

            // Melakukan reservasi
            resepsionis.tanganiReservasi(tamu, kamar, jumlahMalam, fasilitasPilihan.toArray(new Fasilitas[0]));

            System.out.print("Apakah Anda ingin melakukan reservasi lagi? (ya/tidak): ");
            String lagi = scanner.nextLine();
            if (lagi.equalsIgnoreCase("tidak")) {
                break; // Keluar dari loop
            }
        }

        scanner.close(); // Menutup scanner
    }
}
