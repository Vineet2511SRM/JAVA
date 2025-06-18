import java.util.*;

public class SwapNumbers {
    public static void main(String[] args) {
        // Creation of scanner object
        Scanner scanner = new Scanner(System.in);

        // Prompting user to input first number
        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();

        // Prompting user to input second number
        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();

        // Swapping the values of number1 and number2 without using a temporary variable
        number1 = number1+number2;
	number2 = number1-number2;
	number1 = number1-number2;
        // Displaying the swapped numbers to the user
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

        // Closing the scanner to avoid resource leaks
        scanner.close();
    }
}
