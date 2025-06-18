import java.util.Scanner;

public class ChocolateDivider {

    // Method to calculate quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = obj.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = obj.nextInt();

        // Check for division by zero
        if (numberOfChildren == 0) {
            System.out.println("Number of children cannot be zero.");
        } else {
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            System.out.println("Each child gets: " + result[1] + " chocolates");
            System.out.println("Remaining chocolates: " + result[0]);
        }

        obj.close();
    }
}
