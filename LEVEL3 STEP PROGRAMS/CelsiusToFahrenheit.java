import java.util.Scanner; // Import Scanner class to take user input

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        // Declare variables for Celsius and Fahrenheit temperatures
        double celsius, fahrenheit; 
        
        // Create a Scanner object to capture input from the user
        Scanner sc = new Scanner(System.in);
        
        // Ask the user to enter the temperature in Celsius
        System.out.print("Enter temperature in Celsius: ");
        celsius = sc.nextDouble(); // Read the temperature input from the user
        
        // Convert the entered Celsius temperature to Fahrenheit
        fahrenheit = ((celsius * 9) / 5) + 32; // Fahrenheit formula

        // Display the result in a readable format
        System.out.println("The " + celsius + " Celsius is " + fahrenheit + " Fahrenheit");

        // Close the scanner object to avoid resource leaks
        sc.close();
    }
}
