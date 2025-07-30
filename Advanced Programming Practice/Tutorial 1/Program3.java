import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Ask the user to enter an integer
        System.out.print("Enter any integer: ");
        int number = scanner.nextInt();

       // Checking divisibility by 3
        if (number % 3 == 0) {
            System.out.println(number + " is divisible by 3.");
        } else {
            System.out.println(number + " is NOT divisible by 3.");
        }

        scanner.close();
    }
}
