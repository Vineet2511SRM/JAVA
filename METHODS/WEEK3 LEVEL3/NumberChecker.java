import java.util.Arrays;

public class NumberChecker {

    // Method to count number of digits
    public static int countDigits(int number) {
        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    
    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int index = count - 1;

        while (number > 0) {
            digits[index--] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // Method to check if it's a duck number (contains zero but not as first digit)
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }

    // Method to check if it's an Armstrong number
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    // Method to find largest and second largest digits
    public static int[] findTwoLargest(int[] digits) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > first) {
                second = first;
                first = digit;
            } else if (digit > second && digit != first) {
                second = digit;
            }
        }
        return new int[]{first, second};
    }

    // Method to find smallest and second smallest digits
    public static int[] findTwoSmallest(int[] digits) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < first) {
                second = first;
                first = digit;
            } else if (digit < second && digit != first) {
                second = digit;
            }
        }
        return new int[]{first, second};
    }

    // Main method to display results
    public static void main(String[] args) {
        int number = 120;  // Change this to any number you want to test

        System.out.println("Number: " + number);

        int count = countDigits(number);
        System.out.println("Number of digits: " + count);

        int[] digits = getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        System.out.println("Is Duck Number? " + (isDuckNumber(digits) ? "Yes" : "No"));
        System.out.println("Is Armstrong Number? " + (isArmstrongNumber(number, digits) ? "Yes" : "No"));

        int[] largest = findTwoLargest(digits);
        System.out.println("Largest digit: " + largest[0]);
        System.out.println("Second largest digit: " + (largest[1] != Integer.MIN_VALUE ? largest[1] : "None"));

        int[] smallest = findTwoSmallest(digits);
        System.out.println("Smallest digit: " + smallest[0]);
        System.out.println("Second smallest digit: " + (smallest[1] != Integer.MAX_VALUE ? smallest[1] : "None"));
    }
}
