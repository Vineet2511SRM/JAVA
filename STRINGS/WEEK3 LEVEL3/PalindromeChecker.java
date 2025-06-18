import java.util.Scanner;

public class PalindromeChecker {

    // Logic 1: Iterative Method using start & end comparison
    public static boolean isPalindromeIterative(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive Method
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // Logic 3: Reverse the string and compare
    public static boolean isPalindromeWithReverse(String str) {
        char[] original = str.toCharArray();
        char[] reverse = reverseUsingCharAt(str);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    // Helper Method to reverse string using charAt()
    public static char[] reverseUsingCharAt(String str) {
        int len = str.length();
        char[] reversed = new char[len];

        for (int i = 0; i < len; i++) {
            reversed[i] = str.charAt(len - 1 - i);
        }

        return reversed;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to check for palindrome: ");
        String input = sc.nextLine();

        boolean isPal1 = isPalindromeIterative(input);
        boolean isPal2 = isPalindromeRecursive(input, 0, input.length() - 1);
        boolean isPal3 = isPalindromeWithReverse(input);

        System.out.println("\nPalindrome Check Results:");
        System.out.println("--------------------------");
        System.out.println("Logic 1 (Iterative): " + (isPal1 ? "Palindrome ✅" : "Not a Palindrome ❌"));
        System.out.println("Logic 2 (Recursive): " + (isPal2 ? "Palindrome ✅" : "Not a Palindrome ❌"));
        System.out.println("Logic 3 (Reverse):   " + (isPal3 ? "Palindrome ✅" : "Not a Palindrome ❌"));

        sc.close();
    }
}
