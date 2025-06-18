import java.util.Scanner;

public class StoreNumbers {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in); // Scanner for user input

        double[] numbers = new double[10]; // Array to store up to 10 numbers
        double total = 0.0; // Variable to store the sum of numbers
        int index = 0; // Index to track array position

        // Infinite loop to take user inputs
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = obj.nextDouble();

            // Stop taking input if user enters 0 or a negative number
            if (input <= 0) {
                break;
            }

            // Stop taking input if the array is full
            if (index == 10) {
                System.out.println("Array is full! Stopping input.");
                break;
            }

            // Store the number in the array and increment the index
            numbers[index] = input;
            index++;
        }

        // Display all stored numbers
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i]; // Add number to the total
        }

        // Display the total sum of entered numbers
        System.out.println("\nTotal sum: " + total);

        obj.close(); // Close scanner to avoid resource leak
    }
}
