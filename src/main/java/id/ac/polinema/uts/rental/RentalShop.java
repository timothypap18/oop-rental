package id.ac.polinema.uts.rental;

import java.util.Arrays;

public class RentalShop {

    private static final int MAX_VEHICLES = 20;
    private static final int MAX_CUSTOMERS = 10;

    private String name;
    private Vehicle[] vehicles;
    private int vehicleCount;
    private Customer[] customers;
    private int customerCount;

    public RentalShop(String name) {
        this.name = name;
        this.vehicles = new Vehicle[MAX_VEHICLES];
        this.vehicleCount = 0;
        this.customers = new Customer[MAX_CUSTOMERS];
        this.customerCount = 0;
    }

    public String getName() {
        return name;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle == null || vehicleCount >= MAX_VEHICLES) {
            return false;
        }
        vehicles[vehicleCount++] = vehicle;
        return true;
    }

    public boolean addCustomer(Customer customer) {
        if (customer == null || customerCount >= MAX_CUSTOMERS) {
            return false;
        }
        if (findCustomer(customer.getCustomerId()) != null) {
            return false;
        }
        customers[customerCount++] = customer;
        return true;
    }

    public Vehicle[] getVehicles() {
        return Arrays.copyOf(vehicles, vehicleCount);
    }

    public Customer[] getCustomers() {
        return Arrays.copyOf(customers, customerCount);
    }

    public Vehicle findVehicleByModel(String model) {
        if (model == null) {
            return null;
        }
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getModel().equalsIgnoreCase(model)) {
                return vehicles[i];
            }
        }
        return null;
    }

    public Customer findCustomer(String customerId) {
        if (customerId == null) {
            return null;
        }
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equals(customerId)) {
                return customers[i];
            }
        }
        return null;
    }

    public Vehicle[] searchByKeyword(String keyword) {
        if (keyword == null) {
            return new Vehicle[0];
        }
        String needle = keyword.toLowerCase();
        Vehicle[] temp = new Vehicle[vehicleCount];
        int found = 0;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getModel().toLowerCase().contains(needle)) {
                temp[found++] = vehicles[i];
            }
        }
        return Arrays.copyOf(temp, found);
    }

    public boolean rent(String customerId, String model) {
        Customer customer = findCustomer(customerId);
        Vehicle vehicle = findVehicleByModel(model);
        if (customer == null || vehicle == null) {
            return false;
        }
        if (!customer.canRent()) {
            return false;
        }
        if (!vehicle.isAvailable()) {
            return false;
        }
        if (!vehicle.rentOut()) {
            return false;
        }
        if (!customer.addRental()) {
            vehicle.returnVehicle();
            return false;
        }
        return true;
    }

    public boolean giveBack(String customerId, String model) {
        Customer customer = findCustomer(customerId);
        Vehicle vehicle = findVehicleByModel(model);
        if (customer == null || vehicle == null) {
            return false;
        }
        if (vehicle.isAvailable()) {
            return false;
        }
        if (customer.getRentalCount() <= 0) {
            return false;
        }
        vehicle.returnVehicle();
        customer.returnRental();
        return true;
    }
}
