import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        // Convert number to string to count digits
        String numStr = Long.toString(number);
        int length = numStr.length();

        int[] digits = new int[length]; // Array to store digits
        int[] freq = new int[10];       // Frequency array for digits 0-9

        // Extract digits and store in digits array
        for (int i = 0; i < length; i++) {
            digits[i] = numStr.charAt(i) - '0'; // Convert char to int
            freq[digits[i]]++; // Increase frequency
        }

        // Display frequency
        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " = " + freq[i]);
            }
        }

        sc.close();
    }
}
