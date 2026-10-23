package id.ac.polinema.uts.rental;

public class Motorcycle extends Vehicle {
    private int engineCc;

    public Motorcycle(String model, int year, int engineCc) {
        super(model, year);
        this.engineCc = engineCc;
    }

    @Override 
    public String describe() {
        return model + "(" + year + ") - " + engineCc + " cc";
    }

    @Override 
    public int dailyRate() {
        return 150000;
    }
}
