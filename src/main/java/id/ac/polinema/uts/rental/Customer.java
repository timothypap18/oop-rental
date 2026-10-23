package id.ac.polinema.uts.rental;

/**
 * Bagian 3: pelanggan rental.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README
 * (semua field harus private).
 *
 * Kerangka field (lengkapi dari diagram), letakkan di atas constructor:
 *   private ____ customerId;
 *   private ____ name;
 *   private int rentalCount;   // nilai awal 0
 */
public class Customer {
    private String customerId;
    private String name;
    private int rentalCount;
    
    public Customer(String customerId, String name) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID tidak boleh kosong");
        }
        this.customerId = customerId;
        setName(name);
        this.rentalCount = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    /** Nama tidak boleh null atau kosong: lempar IllegalArgumentException dan biarkan nama lama. */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh ksosong!");
        }
    }

    public int getRentalCount() {
        return rentalCount;
    }

    /** True jika pelanggan masih boleh menyewa (batasnya 2 sewa aktif). */
    public boolean canRent() {
        return rentalCount < 2;
    }

    /** Menambah jumlah sewa. Jika sudah di batas, tidak berubah dan hasilnya false. */
    public boolean addRental() {
        if (!canRent())  {
            return false;
        }
        rentalCount++;
        return true;
    }

    /** Mengurangi jumlah sewa. Jika sudah tidak ada sewa, tidak berubah dan hasilnya false. */
    public boolean returnRental() {
        if (rentalCount == 0) {
            return false;
        }
        rentalCount--;
        return true;
    }
}
