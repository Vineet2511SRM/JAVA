import java.util.Scanner;

public class Factorial_WHILE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer input: ");
        int input = sc.nextInt();  // Declare input variable

        int i = 1;
        int fact = 1;

        while (i <= input) {  // Corrected loop condition
            fact *= i;
            i++;
        }

        System.out.println("Factorial of " + input + " is: " + fact); // Printing factorial
        sc.close(); // Close the scanner to avoid resource leak
    }
}
