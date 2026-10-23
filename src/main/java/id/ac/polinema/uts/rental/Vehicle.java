package id.ac.polinema.uts.rental;

public abstract class Vehicle {
    protected String model;
    protected int year;
    protected boolean available;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
        this.available = true; 
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean rentOut() {
        if (!available) {
            return false;
        }
        available = false;
        return true;
    }

    public void returnVehicle() {
        available = true;
    }

    public abstract String describe();

    public abstract int dailyRate();
}