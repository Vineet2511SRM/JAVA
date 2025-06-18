import java.util.Scanner; // Importing Scanner class for user input

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        // Declare a variable to store the Fahrenheit temperature
        double fahrenheit;
        
        // Create a Scanner object to capture user input
        Scanner sc = new Scanner(System.in);
        
        // Ask the user to input the temperature in Fahrenheit
        System.out.print("Enter temperature in Fahrenheit: ");
        fahrenheit = sc.nextDouble(); // Read the user input for Fahrenheit
        
        // Declare a variable to store the converted Celsius temperature
        double celsius;
        
        // Convert Fahrenheit to Celsius using the formula: (F - 32) * 5 / 9
        celsius = (fahrenheit - 32) * 5 / 9;
        
        // Display the result in a readable format
        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsius + " Celsius");
        
        // Close the scanner object to avoid resource leaks
        sc.close();
    }
}
