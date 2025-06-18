import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to find sum using loop
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Scanner object for input
        Scanner obj = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a positive number: ");
        int n = obj.nextInt();

        // Call method and display result
        int result = findSum(n);
        System.out.println("Sum of first " + n + " natural numbers is: " + result);

        obj.close();
    }
}
