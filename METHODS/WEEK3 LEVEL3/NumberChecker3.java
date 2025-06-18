import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker3 {

    // Method to count digits in the number
    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // Method to get digits in an array
    public static int[] getDigitsArray(int number) {
        int length = countDigits(number);
        int[] digits = new int[length];
        int index = length - 1;
        while (number > 0) {
            digits[index--] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to reverse an array
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseArray(digits);
        return arraysEqual(digits, reversed);
    }

    // Method to check if the number is a Duck Number
    public static boolean isDuckNumber(int number) {
        boolean foundZero = false;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 0) foundZero = true;
            number /= 10;
        }
        return foundZero;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input. Please enter a positive number.");
            return;
        }

        int[] digits = getDigitsArray(number);
        int[] reversedDigits = reverseArray(digits);

        System.out.println("\nDigits: " + Arrays.toString(digits));
        System.out.println("Reversed Digits: " + Arrays.toString(reversedDigits));
        System.out.println("Number of digits: " + countDigits(number));
        System.out.println("Is Palindrome? " + (isPalindrome(number) ? "Yes" : "No"));
        System.out.println("Is Duck Number? " + (isDuckNumber(number) ? "Yes" : "No"));

        sc.close();
    }
}
