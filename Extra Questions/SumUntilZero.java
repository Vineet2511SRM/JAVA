import java.util.*;

public class SumUntilZero {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        int sum = 0; // Variable to store the sum of numbers
        
        // Infinite loop to take user input until a stopping condition is met
        while (true) {
            System.out.print("Enter a number: ");
            int num = sc.nextInt(); // Read user input
            
            // Check if the entered number is 0 or negative
            if (num <= 0) {
                break; // Exit the loop if the condition is met
            }
            
            sum += num; // Add the valid number to the sum
        }
        
        // Display the final sum of the entered numbers
        System.out.println("Sum of entered numbers: " + sum);
        
        // Close the scanner to prevent resource leaks
        sc.close();
    }
}
