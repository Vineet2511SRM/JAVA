import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner obj = new Scanner(System.in);
        
        // Prompt user for a positive number
        System.out.print("Enter a number: ");
        int number = obj.nextInt(); // Store user input
        
        // Validate input
        if (number <= 0) {
            System.out.println("Invalid Input. Please input a valid positive integer.");
        } else {
            // Initialize counter variable
            int counter = 1;
            System.out.println("Factors of " + number + " are:");
            
            // Loop to find and print factors
            while (counter <= number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
        }
        
        // Close the scanner to prevent resource leaks
        obj.close();
    }
}
