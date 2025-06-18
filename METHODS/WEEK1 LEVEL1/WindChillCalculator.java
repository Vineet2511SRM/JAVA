import java.util.Scanner;

public class WindChillCalculator {

    // Method to calculate wind chill
    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Input from user
        System.out.print("Enter the temperature (in Fahrenheit): ");
        double temperature = obj.nextDouble();

        System.out.print("Enter the wind speed (in miles per hour): ");
        double windSpeed = obj.nextDouble();

        // Create an object of WindChillCalculator
        WindChillCalculator calculator = new WindChillCalculator();

        // Call the method to calculate wind chill
        double windChill = calculator.calculateWindChill(temperature, windSpeed);

        // Display the result
        System.out.println("The wind chill temperature is: " + windChill + "°F");

        obj.close();
    }
}
