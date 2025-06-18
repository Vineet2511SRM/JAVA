import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to find the sum using recursion
    public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + recursiveSum(n - 1);
        }
    }

    // Method to find the sum using the formula
    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        // Check if input is a natural number
        if (n <= 0) {
            System.out.println("Invalid input! Please enter a natural number (greater than 0).");
            return;
        }

        // Calculate the sum using recursion
        int sumByRecursion = recursiveSum(n);

        // Calculate the sum using formula
        int sumByFormula = formulaSum(n);

        // Print both results
        System.out.println("Sum of first " + n + " natural numbers using recursion: " + sumByRecursion);
        System.out.println("Sum of first " + n + " natural numbers using formula: " + sumByFormula);

        // Compare both results
        if (sumByRecursion == sumByFormula) {
            System.out.println("Both results are same. Calculation is correct!");
        } else {
            System.out.println("There seems to be a mismatch in the results.");
        }

        sc.close();
    }
}
