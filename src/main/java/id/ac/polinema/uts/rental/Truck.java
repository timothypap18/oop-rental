package id.ac.polinema.uts.rental;

public class Truck extends Vehicle {
    private int loadTons;

    public Truck(String model, int year, int loadTons) {
        super(model, year);
        this.loadTons = loadTons;
    }

    @Override
    public String describe() {
        return model + " (" + year + ") - " + loadTons + " tons";
    }

    @Override
    public int dailyRate() {
        return 500000; // Sesuaikan dengan tarif di README kamu
    }

}
