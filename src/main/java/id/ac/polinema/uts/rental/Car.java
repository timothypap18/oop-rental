package id.ac.polinema.uts.rental;

/**
 * Bagian 2 dan 3: mobil rental.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Method untuk bagian berikutnya (setBrand, getBrand, dan seterusnya) kamu
 * tambahkan sendiri sesuai diagram di bagian tersebut.
 *
 * Kerangka field (lengkapi tipe dan nama dari diagram), letakkan di atas constructor:
 *   public String plate;
 *   public ____ model;
 *   public ____ year;
 *   public ____ available;
 */
public class Car {
    public String plate;
    public String model;
    public int year;
    public boolean available;
    private Brand brand;

    public Brand getBrand() {
        return brand;
    }
    
    public Car(String plate, String model, int year) {
        if (plate == null || plate.trim().isEmpty()) {
            throw new IllegalArgumentException("Plate tidak boleh kosong");
        }
        this.plate = plate;
        setModel(model);
        setYear(year);
        this.available = true;
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    /** True jika mobil ada di garasi (tidak sedang disewa). */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Menyewa mobil. Berhasil (true) jika mobil tersedia. Jika mobil sedang
     * disewa, hasilnya false dan keadaan mobil tidak berubah.
     */
    public boolean rentOut() {
        if (!available) {
            return false;
        } else {
            available = false;
            return true;
        }
    }

    /** Mobil dikembalikan: mobil bisa disewa lagi. */
    public void returnVehicle() {
        available = true;
    }

    /**
     * Bagian 3. Mengubah model. Model null, kosong, atau hanya spasi ditolak
     * dengan IllegalArgumentException, dan model lama tetap.
     */
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model tidak boleh kosong");
        }
        this.model = model;
    }

    /**
     * Bagian 3. Mengubah tahun produksi. Tahun di bawah 1990 ditolak dengan
     * IllegalArgumentException, dan tahun lama tetap.
     */
    public void setYear(int year) {
        if (year < 1990) {
            throw new IllegalArgumentException("Tahun tidak boleh di bawah 1990");
        }
        this.year = year;
    }
}
