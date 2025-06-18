import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        double total = 0.0; // Variable to store the sum
        double number;
        
        System.out.println("Enter numbers to sum (enter 0 to stop):");
        
        while (true) {
            System.out.print("Enter a number: ");
            number = scanner.nextDouble();
            
            if (number == 0) { // Stop the loop if input is 0
                break;
            }
            
            total += number; // Add input to total
        }
        
        System.out.println("Total sum: " + total); // Display the result
        scanner.close(); // Close the scanner
    }
}
