public class Vehicle {
    // Instance variables (unique per vehicle)
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;

    // Static variables (shared among all vehicles)
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;
    private static int rentalDays = 0;

    // Constructor
    public Vehicle(String vehicleId, String brand, String model, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++; // every new vehicle increases totalVehicles
    }

    // Calculate rent and update static counters
    public double calculateRent(int days) {
        double amount = days * rentPerDay;
        totalRevenue += amount;
        rentalDays += days;
        return amount;
    }

    // Rent vehicle
    public void rentVehicle(int days) {
        if (isAvailable) {
            double rent = calculateRent(days);
            System.out.println(brand + " " + model + " rented for " + days + " days. Rent = " + rent);
            isAvailable = false;
        } else {
            System.out.println(brand + " " + model + " is not available for rent.");
        }
    }

    // Return vehicle
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(brand + " " + model + " is now available for rent.");
        } else {
            System.out.println(brand + " " + model + " was already available.");
        }
    }

    // Display instance info
    public void displayVehicleInfo() {
        System.out.println("----------------------------");
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rent per day: " + rentPerDay);
        System.out.println("Available: " + isAvailable);
        System.out.println("----------------------------");
    }

    // Static methods
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        return (rentalDays == 0) ? 0 : totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("=== Company Stats ===");
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("Average Rent per Day: " + getAverageRentPerDay());
        System.out.println("=====================");
    }

    // Main method 
    public static void main(String[] args) {
        // Set static company name
        Vehicle.setCompanyName("Fast Wheels Rental");

        // Create vehicles (instance objects)
        Vehicle v1 = new Vehicle("V101", "Toyota", "Corolla", 2000);
        Vehicle v2 = new Vehicle("V102", "Honda", "City", 2500);
        Vehicle v3 = new Vehicle("V103", "Ford", "EcoSport", 3000);

        // Rent vehicles
        v1.rentVehicle(3);
        v2.rentVehicle(2);

        // Display vehicle info (instance data)
        System.out.println("\n--- Vehicle Info ---");
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo(); // still available

        // Return a vehicle
        v1.returnVehicle();

        // Display static company stats (shared across all vehicles)
        System.out.println("\n--- Company Stats ---");
        Vehicle.displayCompanyStats();

        // Explicitly show static variables
        System.out.println("\nStatic variables shared across all vehicles:");
        System.out.println("Total Revenue: " + Vehicle.getTotalRevenue());
        System.out.println("Average Rent per Day: " + Vehicle.getAverageRentPerDay());

        // Demonstrates instance variables uniqueness
        System.out.println("\nInstance variables unique to each vehicle:");
        System.out.println("v1 available? " + v1.isAvailable);
        System.out.println("v2 available? " + v2.isAvailable);
        System.out.println("v3 available? " + v3.isAvailable);
    }
}
