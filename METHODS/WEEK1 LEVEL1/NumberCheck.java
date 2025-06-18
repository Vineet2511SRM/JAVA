import java.util.Scanner;

public class NumberCheck {

    // Method to check number status
    public static int checkNumber(int num) {
        if (num > 0) { // Check whether the number is positive
            return 1;
        } else if (num < 0) { // Check whether the number is negative
            return -1;
        } else {
            return 0; // Check whether the number is zero
        }
    }

    public static void main(String[] args) {
        // Scanner object named 'obj'
        Scanner obj = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter an integer: ");
        int number = obj.nextInt();

        // Call method and get result
        int result = checkNumber(number);

        // Display output based on result
        if (result == 1) { 
            System.out.println("The number is Positive.");
        } else if (result == -1) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }

        obj.close();
    }
}
