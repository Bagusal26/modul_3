import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interface untuk pengelolaan kontak.
 */
interface PengelolaKontak {
    /**
     * Menambahkan kontak baru ke dalam daftar.
     *
     * @param nama Nama kontak yang akan ditambahkan.
     * @param telepon Nomor telepon kontak yang akan ditambahkan.
     */
    void tambahKontak(String nama, String telepon);

    /**
     * Menghapus kontak dari daftar berdasarkan nama.
     *
     * @param nama Nama kontak yang akan dihapus.
     */
    void hapusKontak(String nama);

    /**
     * Menampilkan daftar semua kontak.
     */
    void daftarKontak();
}

/**
 * Kelas untuk merepresentasikan kontak dengan nama dan nomor telepon.
 */
class Kontak {
    private String nama; // Nama kontak
    private String telepon; // Nomor telepon kontak

    /**
     * Konstruktor untuk objek Kontak.
     *
     * @param nama Nama kontak.
     * @param telepon Nomor telepon kontak.
     */
    public Kontak(String nama, String telepon) {
        this.nama = nama;
        this.telepon = telepon;
    }

    /**
     * Mengambil nama kontak.
     *
     * @return Nama kontak.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengambil nomor telepon kontak.
     *
     * @return Nomor telepon kontak.
     */
    public String getTelepon() {
        return telepon;
    }
}

/**
 * Kelas yang mengimplementasikan interface PengelolaKontak.
 */
class SimplePengelolaKontak implements PengelolaKontak {
    private List<Kontak> kontakList; // Daftar kontak

    /**
     * Konstruktor untuk objek SimplePengelolaKontak.
     * Menginisialisasi daftar kontak.
     */
    public SimplePengelolaKontak() {
        kontakList = new ArrayList<>();
    }

    @Override
    public void tambahKontak(String nama, String telepon) {
        kontakList.add(new Kontak(nama, telepon));
    }

    @Override
    public void hapusKontak(String nama) {
        Kontak kontakUntukDihapus = cariKontak(nama);
        if (kontakUntukDihapus != null) {
            kontakList.remove(kontakUntukDihapus);
        } else {
            System.out.println("Kontak tidak ditemukan.");
        }
    }

    @Override
    public void daftarKontak() {
        for (Kontak kontak : kontakList) {
            System.out.println("Nama: " + kontak.getNama() + ", Telepon: " + kontak.getTelepon());
        }
    }

    /**
     * Mencari kontak berdasarkan nama.
     *
     * @param nama Nama kontak yang dicari.
     * @return Kontak yang ditemukan, atau null jika tidak ada.
     */
    private Kontak cariKontak(String nama) {
        for (Kontak kontak : kontakList) {
            if (kontak.getNama().equals(nama)) {
                return kontak;
            }
        }
        return null;
    }
}

/**
 * Kelas utama untuk menjalankan aplikasi pengelolaan kontak.
 */
class AplikasiKontak {
    /**
     * Metode utama untuk menjalankan aplikasi.
     *
     * @param args Argumen command line (tidak digunakan).
     */
    public static void main(String[] args) {
        PengelolaKontak pengelola = new SimplePengelolaKontak();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Hapus Kontak");
            System.out.println("3. Daftar Kontak");
            System.out.println("4. Keluar");
            System.out.println("5. Keluar");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan telepon: ");
                    String telepon = scanner.nextLine();
                    pengelola.tambahKontak(nama, telepon);
                    break;
                case "2":
                    System.out.print("Masukkan nama untuk dihapus: ");
                    String namaUntukDihapus = scanner.nextLine();
                    pengelola.hapusKontak(namaUntukDihapus);
                    break;
                case "3":
                    pengelola.daftarKontak();
                    break;
                case "4":
                    scanner.close();
                    return; // Keluar dari program
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
