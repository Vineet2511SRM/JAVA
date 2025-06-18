import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get integer input for number and power
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();

        // Initialize result variable
        int result = 1;

        // Run a for loop from i = 1 to i <= power
        for (int i = 1; i <= power; i++) {
            // Multiply the result with the number
            result *= number;
        }

        // Print the result
        System.out.println("Result: " + result);
    }
}