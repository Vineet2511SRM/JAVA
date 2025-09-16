package WEEK6;

import java.util.UUID;

public class Vehicle {
    // TODO: Create protected fields for inheritance:
    // - brand (String) - accessible to subclasses
    // - model (String) - accessible to subclasses
    // - year (int) - accessible to subclasses
    // - engineType (String) - accessible to subclasses
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // TODO: Create private fields that require getter/setter access:
    // - registrationNumber (String) - only through methods
    // - isRunning (boolean) - internal state
    private String registrationNumber;
    private boolean isRunning;

    // TODO: Create default constructor that:
    // - Sets default values for all fields
    // - Prints "Vehicle default constructor called"
    public Vehicle() {
        this.brand = "DefaultBrand";
        this.model = "DefaultModel";
        this.year = 2025;
        this.engineType = "Petrol";
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // TODO: Create parameterized constructor that:
    // - Takes brand, model, year, engineType parameters
    // - Initializes all fields
    // - Prints "Vehicle parameterized constructor called"
    // - Generates random registration number
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // TODO: Create methods for basic vehicle operations:
    // - start() - sets isRunning to true, prints "Vehicle started"
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    // - stop() - sets isRunning to false, prints "Vehicle stopped"
    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    // - getVehicleInfo() - returns formatted string with all vehicle details
    public String getVehicleInfo() {
        return String.format("Brand: %s, Model: %s, Year: %d, Engine: %s, Registration: %s, Running: %b",
                brand, model, year, engineType, registrationNumber, isRunning);
    }

    // - displaySpecs() - prints technical specifications
    public void displaySpecs() {
        System.out.println("Vehicle Specifications:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine: " + engineType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Running: " + isRunning);
    }

    // TODO: Create getter/setter methods for private fields:
    // - getRegistrationNumber() / setRegistrationNumber()
    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    // - isRunning() - no setter for this (controlled through start/stop)
    public boolean isRunning() { return isRunning; }

    // Helper method to generate registration number
    private String generateRegistrationNumber() {
        return "REG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
