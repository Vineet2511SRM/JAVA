import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();
        
        // Validate if the input is a natural number (positive integer)
        if (number < 1) {
            System.out.println("Error: Please enter a natural number (greater than 0). Exiting program.");
            System.exit(1); // Exit the program
        }
        
        // Calculate the size of even and odd number arrays
        int evenSize = number / 2 + 1;
        int oddSize = number / 2 + 1;
        
        // Initialize arrays for even and odd numbers
        int[] evenNumbers = new int[evenSize];
        int[] oddNumbers = new int[oddSize];
        
        // Index variables for even and odd arrays
        int evenIndex = 0, oddIndex = 0;
        
        // Iterate from 1 to the given number and categorize numbers
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i; // Store even number
            } else {
                oddNumbers[oddIndex++] = i; // Store odd number
            }
        }
        
        // Print the odd numbers array
        System.out.print("Odd Numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();
        
        // Print the even numbers array
        System.out.print("Even Numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
    }
}