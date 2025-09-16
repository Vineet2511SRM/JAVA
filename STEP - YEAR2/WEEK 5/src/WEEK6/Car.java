package WEEK6;

public class Car extends Vehicle {
    // TODO: Add car-specific fields:
    // - numberOfDoors (int)
    // - fuelType (String)
    // - transmissionType (String)
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // TODO: Create default constructor that:
    // - Calls super() explicitly
    // - Sets car-specific default values
    // - Prints "Car default constructor called"
    public Car() {
        super(); // Call Vehicle default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // TODO: Create parameterized constructor that:
    // - Takes all Vehicle parameters plus car-specific parameters
    // - Calls super(brand, model, year, engineType) explicitly
    // - Initializes car-specific fields
    // - Prints "Car parameterized constructor called"
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // TODO: Override parent methods where appropriate:
    // - Override start() to include car-specific startup sequence
    // - Call super.start() first, then add car-specific operations
    @Override
    public void start() {
        super.start();
        System.out.println("Car-specific startup sequence: Check mirrors and seatbelt.");
    }

    // - Override displaySpecs() to show both vehicle and car specifications
    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Car Specifications:");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

    // TODO: Add car-specific methods:
    // - openTrunk() - prints "Trunk opened"
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    // - playRadio() - prints "Radio playing music"
    public void playRadio() {
        System.out.println("Radio playing music");
    }

    // Getters and setters for car-specific fields
    public int getNumberOfDoors() { return numberOfDoors; }
    public void setNumberOfDoors(int numberOfDoors) { this.numberOfDoors = numberOfDoors; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public String getTransmissionType() { return transmissionType; }
    public void setTransmissionType(String transmissionType) { this.transmissionType = transmissionType; }

    // Main method to test everything
    public static void main(String[] args) {
        // TODO: Test constructor chaining:
        System.out.println("--- Constructor Chaining Test ---");
        Car defaultCar = new Car(); // Default constructor
        System.out.println(defaultCar.getVehicleInfo());

        System.out.println("\n--- Parameterized Car ---");
        Car paramCar = new Car("Toyota", "Corolla", 2022, "Hybrid", 4, "Hybrid", "Automatic");
        paramCar.displaySpecs();

        // TODO: Test inheritance of fields and methods:
        System.out.println("\n--- Testing methods ---");
        paramCar.start();     // overridden method
        paramCar.playRadio(); // car-specific
        paramCar.openTrunk(); // car-specific
        paramCar.stop();      // inherited from Vehicle

        // TODO: Test super keyword usage:
        System.out.println("\n--- Access protected fields directly ---");
        System.out.println("Brand: " + paramCar.brand);
        System.out.println("Model: " + paramCar.model);

        // TODO: Test method resolution:
        // Call methods that exist only in Car
        paramCar.playRadio();
        // Call methods that exist in both Vehicle and Car
        paramCar.start();
    }
}
