import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {

    // Method to check palindrome
    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        // Normalize: remove spaces and convert to lowercase
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();

        // Push all characters to stack
        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        // Build reversed string by popping from stack
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Compare original and reversed
        return cleaned.equals(reversed.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string to check (or 'exit' to quit): ");
            String input = sc.nextLine();

            // Exit condition
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }

            if (isPalindrome(input)) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not Palindrome");
            }
        }

        sc.close();
    }
}
