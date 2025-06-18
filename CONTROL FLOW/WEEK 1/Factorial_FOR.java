import java.util.Scanner;

public class Factorial_FOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer input: ");
        int input = sc.nextInt();  // Get user input

        int fact = 1;

        // Using a for loop
        for (int i = 1; i <= input; i++) {
            fact *= i;
        }

        System.out.println("Factorial of " + input + " is: " + fact);
        sc.close(); // Close scanner to prevent resource leak
    }
}
