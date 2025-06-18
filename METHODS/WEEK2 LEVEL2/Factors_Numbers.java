import java.util.Scanner;

public class Factors_Numbers {

    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter a number: ");
        int number = ob.nextInt();

        // Step 2: Get factors
        int[] factors = findFactors(number);

        // Step 3: Display factors
        System.out.print("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        // Step 4: Perform operations
        int sum = findSum(factors);
        int product = findProduct(factors);
        int sumOfSquares = findSumOfSquares(factors);

        // Step 5: Display results
        System.out.println("Sum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumOfSquares);
    }

    // Method to find and return factors in an array
    public static int[] findFactors(int num) {
        int count = 0;

        // First loop: count factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        // Initialize array with factor count
        int[] factors = new int[count];
        int index = 0;

        // Second loop: store factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to find sum of factors
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    // Method to find product of factors
    public static int findProduct(int[] arr) {
        int product = 1;
        for (int value : arr) {
            product *= value;
        }
        return product;
    }

    // Method to find sum of squares of factors
    public static int findSumOfSquares(int[] arr) {
        int sumSquares = 0;
        for (int value : arr) {
            sumSquares += Math.pow(value, 2);
        }
        return sumSquares;
    }
}
