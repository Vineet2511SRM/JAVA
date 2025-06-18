import java.util.Scanner;

public class QuotientRemainder {

    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Input from user
        System.out.print("Enter the number (dividend): ");
        int number = obj.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = obj.nextInt();

        if (divisor == 0) {
            System.out.println("Divisor cannot be zero.");
        } else {
            // Call the method
            int[] result = findRemainderAndQuotient(number, divisor);

            // Display result
            System.out.println("Quotient: " + result[1]);
            System.out.println("Remainder: " + result[0]);
        }

        obj.close();
    }
}
