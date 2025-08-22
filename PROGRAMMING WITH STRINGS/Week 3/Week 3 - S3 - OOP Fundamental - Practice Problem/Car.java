public class Car {
    // Instance variables (attributes)
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    // Constructor to initialize all attributes
    Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // Initially car is not running
    }

    // Method to start the engine
    void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " has started.");
    }

    // Method to stop the engine
    void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " has stopped.");
    }

    // Method to display car information
    void displayInfo(int currentYear) {
        System.out.println("Car Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
        System.out.println("Age: " + getAge(currentYear) + " years");
        System.out.println("------------------------");
    }

    // Method to get car age
    int getAge(int currentYear) {
        return currentYear - year;
    }

    // Main method
    public static void main(String[] args) {
        int currentYear = 2025; // You can change this manually

        // Creating 3 different Car objects
        Car car1 = new Car("Toyota", "Camry", 2020, "Blue");
        Car car2 = new Car("Honda", "Civic", 2018, "Red");
        Car car3 = new Car("Ford", "Mustang", 2021, "Black");

        // Demonstrating method calls
        car1.displayInfo(currentYear);
        car1.startEngine();
        car1.stopEngine();

        car2.displayInfo(currentYear);
        car2.startEngine();
        car2.stopEngine();

        car3.displayInfo(currentYear);
        car3.startEngine();
        car3.stopEngine();

        // Showing each car maintains its own state
        System.out.println("Final State of Cars:");
        car1.displayInfo(currentYear);
        car2.displayInfo(currentYear);
        car3.displayInfo(currentYear);

        // Explanation:
        // Each Car object represents a real-world car.
        // They have their own attributes (brand, model, year, color) and state (isRunning),
        // and can perform actions independently (start/stop engine).
    }
}
