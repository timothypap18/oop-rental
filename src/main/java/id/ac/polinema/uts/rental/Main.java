package id.ac.polinema.uts.rental;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Polinema Rental");

        RentalShop shop = new RentalShop("Polinema Rental");

        // PERHATIKAN: String pakai tanda kutip "", dan Car pakai 4 parameter (ada Brand)
        shop.addVehicle(new Car("N 1203 AB", "Avanza", 2009, new Brand("Toyota", "Japan")));
        
        shop.addVehicle(new Motorcycle("Vario", 2022, 125));
        shop.addVehicle(new Truck("Canter", 2020, 4));
        
        shop.addCustomer(new Customer("C001", "Dewi"));

        RentalApp app = new RentalApp(shop, new Scanner(System.in), System.out);
        app.run();
    }
}