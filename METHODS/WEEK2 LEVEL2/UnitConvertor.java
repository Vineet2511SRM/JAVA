// This program converts distance units:
// KM <-> Miles and Meters <-> Feet

import java.util.Scanner;

public class UnitConvertor {

    // Convert kilometers to miles
    public static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // Convert miles to kilometers
    public static double milesToKm(double miles) {
        return miles / 0.621371;
    }

    // Convert meters to feet
    public static double metersToFeet(double meters) {
        return meters * 3.28084;
    }

    // Convert feet to meters
    public static double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Distance Unit Converter ===");

        // Take inputs from user
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();

        System.out.print("Enter distance in miles: ");
        double miles = sc.nextDouble();

        System.out.print("Enter distance in meters: ");
        double meters = sc.nextDouble();

        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();

        // Show results
        System.out.println();
        System.out.println(km + " km = " + kmToMiles(km) + " miles");
        System.out.println(miles + " miles = " + milesToKm(miles) + " km");
        System.out.println(meters + " meters = " + metersToFeet(meters) + " feet");
        System.out.println(feet + " feet = " + feetToMeters(feet) + " meters");

        System.out.println("=== Conversion Done ===");

        sc.close();
    }
}
