/**
 * Assignment7_VehicleFleet.java
 * Author: Vineet Seth
 * Description: Vehicle Fleet Management System with inheritance, driver assignment,
 * maintenance tracking, fuel consumption, trip management, error handling, and operational cost analysis.
 */

/**
 * Base Vehicle class representing a generic vehicle in the fleet.
 */
class Vehicle {
    String vehicleId, brand, model, fuelType, currentStatus;
    int year;
    double mileage; // km per liter
    double totalDistanceTravelled = 0;
    double fuelConsumed = 0;

    static int totalVehicles = 0;
    static double fleetValue = 0; // sum of all vehicle costs
    static double totalFuelConsumption = 0; // fleet-wide fuel consumed
    static String companyName = "TranspoCorp";

    double vehicleCost;
    Driver assignedDriver = null;

    /**
     * Constructs a new Vehicle.
     *
     * @param id          Vehicle ID
     * @param brand       Brand name
     * @param model       Model name
     * @param year        Manufacturing year
     * @param mileage     Mileage in km/l
     * @param fuelType    Fuel type (Petrol/Diesel)
     * @param vehicleCost Cost of the vehicle
     */
    Vehicle(String id, String brand, String model, int year, double mileage, String fuelType, double vehicleCost) {
        this.vehicleId = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.currentStatus = "Available";
        this.vehicleCost = vehicleCost;

        totalVehicles++;
        fleetValue += vehicleCost;
    }

    /**
     * Assigns a driver to this vehicle.
     *
     * @param d Driver to assign
     * @throws IllegalArgumentException if driver is null
     */
    public void assignDriver(Driver d) {
        if (d == null) throw new IllegalArgumentException("Driver cannot be null.");
        this.assignedDriver = d;
        d.assignedVehicle = this;
        System.out.println("Driver " + d.driverName + " assigned to vehicle " + this.vehicleId);
    }

    /**
     * Schedules maintenance for the vehicle.
     */
    public void scheduleMaintenance() {
        System.out.println("Maintenance scheduled for vehicle " + vehicleId);
        this.currentStatus = "Under Maintenance";
    }

    /**
     * Updates mileage and fuel consumption when a trip is made.
     *
     * @param distanceTravelled Distance in km
     * @throws IllegalArgumentException if distance <= 0
     */
    public void updateMileage(double distanceTravelled) {
        if (distanceTravelled <= 0) throw new IllegalArgumentException("Distance must be positive.");
        totalDistanceTravelled += distanceTravelled;
        double fuelUsed = distanceTravelled / mileage;
        fuelConsumed += fuelUsed;
        totalFuelConsumption += fuelUsed;
        System.out.println(vehicleId + " ran " + distanceTravelled + " km. Fuel used: " + fuelUsed + " L");
    }

    /**
     * Calculates running cost based on fuel consumed and fuel price.
     *
     * @param fuelPricePerL Price per liter of fuel
     * @return Total cost
     */
    public double calculateRunningCost(double fuelPricePerL) {
        double cost = fuelConsumed * fuelPricePerL;
        System.out.println("Running cost for " + vehicleId + ": ₹" + cost);
        return cost;
    }

    /**
     * Checks if the vehicle is due for service.
     *
     * @param currentYear Current year
     */
    public void checkServiceDue(int currentYear) {
        if (currentYear - year >= 3) {
            System.out.println(vehicleId + " is due for service!");
        } else {
            System.out.println(vehicleId + " service not due yet.");
        }
    }

    @Override
    public String toString() {
        return vehicleId + " - " + brand + " " + model + " | Status: " + currentStatus;
    }
}

/**
 * Car class representing passenger cars.
 */
class Car extends Vehicle {
    int passengerCapacity;

    Car(String id, String brand, String model, int year, double mileage, String fuelType, double vehicleCost, int passengerCapacity) {
        super(id, brand, model, year, mileage, fuelType, vehicleCost);
        this.passengerCapacity = passengerCapacity;
    }
}

/**
 * Bus class representing passenger buses.
 */
class Bus extends Vehicle {
    int seatingCapacity;

    Bus(String id, String brand, String model, int year, double mileage, String fuelType, double vehicleCost, int seatingCapacity) {
        super(id, brand, model, year, mileage, fuelType, vehicleCost);
        this.seatingCapacity = seatingCapacity;
    }
}

/**
 * Truck class representing cargo trucks.
 */
class Truck extends Vehicle {
    double loadCapacity; // in tons

    Truck(String id, String brand, String model, int year, double mileage, String fuelType, double vehicleCost, double loadCapacity) {
        super(id, brand, model, year, mileage, fuelType, vehicleCost);
        this.loadCapacity = loadCapacity;
    }
}

/**
 * Driver class representing drivers in the fleet.
 */
class Driver {
    String driverId, driverName, licenseType;
    Vehicle assignedVehicle;
    int totalTrips = 0;
    double totalDistance = 0;

    Driver(String id, String name, String licenseType) {
        this.driverId = id;
        this.driverName = name;
        this.licenseType = licenseType;
    }

    /**
     * Performs a trip using the assigned vehicle.
     *
     * @param distance Distance in km
     */
    public void makeTrip(double distance) {
        if (distance <= 0) {
            System.out.println("Trip distance must be positive!");
            return;
        }
        if (assignedVehicle != null) {
            assignedVehicle.updateMileage(distance);
            totalDistance += distance;
            totalTrips++;
            System.out.println(driverName + " completed a trip of " + distance + " km. Total trips: " + totalTrips);
        } else {
            System.out.println(driverName + " has no vehicle assigned!");
        }
    }
}

/**
 * Fleet Management utility class for reports and operations.
 */
class FleetManagement {
    public static void getFleetUtilization(Vehicle[] vehicles) {
        int active = 0;
        for (Vehicle v : vehicles) {
            if ("Available".equals(v.currentStatus)) active++;
        }
        System.out.println("Fleet Utilization: " + active + "/" + vehicles.length + " available.");
    }

    public static double calculateTotalMaintenanceCost(Vehicle[] vehicles, double costPerVehicle) {
        if (costPerVehicle < 0) throw new IllegalArgumentException("Maintenance cost cannot be negative.");
        double total = vehicles.length * costPerVehicle;
        System.out.println("Total maintenance cost for fleet: ₹" + total);
        return total;
    }

    public static void getVehiclesByType(Vehicle[] vehicles, String type) {
        System.out.println("Vehicles of type " + type + ":");
        for (Vehicle v : vehicles) {
            if ((type.equalsIgnoreCase("Car") && v instanceof Car)
                || (type.equalsIgnoreCase("Bus") && v instanceof Bus)
                || (type.equalsIgnoreCase("Truck") && v instanceof Truck)) {
                System.out.println(v);
            }
        }
    }

    public static void printFuelConsumptionReport(Vehicle[] vehicles, double fuelPricePerL) {
        if (fuelPricePerL < 0) throw new IllegalArgumentException("Fuel price cannot be negative.");
        System.out.println("\n--- Fleet Fuel Consumption Report ---");
        for (Vehicle v : vehicles) {
            System.out.println(v.vehicleId + ": Distance Travelled = " + v.totalDistanceTravelled + " km, Fuel Used = " + v.fuelConsumed + " L");
            v.calculateRunningCost(fuelPricePerL);
        }
        System.out.println("Total fleet fuel consumed: " + Vehicle.totalFuelConsumption + " L");
    }
}

/**
 * Main class for testing the Vehicle Fleet Management System.
 */
public class Assignment7_VineetSeth {
    public static void main(String[] args) {
        Vehicle v1 = new Car("C001", "Toyota", "Corolla", 2021, 15, "Petrol", 800000, 5);
        Vehicle v2 = new Bus("B001", "Volvo", "7900", 2019, 5, "Diesel", 5000000, 50);
        Vehicle v3 = new Truck("T001", "Tata", "LPT", 2020, 4, "Diesel", 3000000, 10);

        Vehicle[] fleet = {v1, v2, v3};

        Driver d1 = new Driver("D001", "Aman", "Light");
        Driver d2 = new Driver("D002", "Rohit", "Heavy");

        try {
            v1.assignDriver(d1);
            v2.assignDriver(d2);

            // Trips
            d1.makeTrip(100); // Car trip
            d2.makeTrip(200); // Bus trip
            d1.makeTrip(50);  // Car trip again
            d2.makeTrip(120); // Bus trip again

            // Maintenance & service
            v1.checkServiceDue(2025);
            v2.scheduleMaintenance();

            // Fleet reports
            FleetManagement.getFleetUtilization(fleet);
            FleetManagement.calculateTotalMaintenanceCost(fleet, 20000);
            FleetManagement.getVehiclesByType(fleet, "Bus");

            // Fuel consumption report
            FleetManagement.printFuelConsumptionReport(fleet, 100); // fuel price ₹100 per L
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
