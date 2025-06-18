import java.util.Scanner;

public class NumberAnalyzer {

    // Method to check if a number is positive
    public static boolean isPositive(int num) {
        return num >= 0;
    }

    // Method to check if a number is even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Method to compare two numbers
    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        else if (num1 == num2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("=== Enter 5 Numbers ===");

        // Input 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\n=== Number Analysis ===");

        // Analyze each number
        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.print(num + " is Positive and ");
                if (isEven(num)) {
                    System.out.println("Even.");
                } else {
                    System.out.println("Odd.");
                }
            } else {
                System.out.println(num + " is Negative.");
            }
        }

        // Compare first and last elements
        int result = compare(numbers[0], numbers[numbers.length - 1]);

        System.out.println("\n=== First vs Last Number ===");
        if (result == 1) {
            System.out.println("First number (" + numbers[0] + ") is Greater than Last number (" + numbers[4] + ")");
        } else if (result == 0) {
            System.out.println("First number and Last number are Equal (" + numbers[0] + ")");
        } else {
            System.out.println("First number (" + numbers[0] + ") is Less than Last number (" + numbers[4] + ")");
        }

        sc.close();
    }
}
