import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (true) {  // Infinite while loop
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();

            if (num <= 0) {  // Check for 0 or negative number
                break;  // Exit the loop
            }

            sum += num;  // Add number to sum
        }

        System.out.println("Sum of entered numbers: " + sum);
        scanner.close();
    }
}
