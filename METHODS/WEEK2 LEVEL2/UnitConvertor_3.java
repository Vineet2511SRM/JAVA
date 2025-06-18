import java.util.Scanner;

public class UnitConvertor_3 {

    // Method to convert Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Method to convert Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    // Method to convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    // Method to convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    // Method to convert liters to gallons
    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Temperature, Weight, and Volume Converter ===");

        // Temperature
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.print("Enter temperature in Celsius: ");
        double c = sc.nextDouble();

        // Weight
        System.out.print("Enter weight in pounds: ");
        double pounds = sc.nextDouble();
        System.out.print("Enter weight in kilograms: ");
        double kg = sc.nextDouble();

        // Volume
        System.out.print("Enter volume in gallons: ");
        double gallons = sc.nextDouble();
        System.out.print("Enter volume in liters: ");
        double liters = sc.nextDouble();

        System.out.println();

        // Show results
        System.out.println(f + "°F = " + convertFahrenheitToCelsius(f) + "°C");
        System.out.println(c + "°C = " + convertCelsiusToFahrenheit(c) + "°F");

        System.out.println(pounds + " pounds = " + convertPoundsToKilograms(pounds) + " kg");
        System.out.println(kg + " kg = " + convertKilogramsToPounds(kg) + " pounds");

        System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");
        System.out.println(liters + " liters = " + convertLitersToGallons(liters) + " gallons");

        System.out.println("=== Conversion Done ===");

        sc.close();
    }
}
