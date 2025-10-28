import java.util.Scanner;
import java.util.Stack;

public class ReverseString {

    // Method to reverse a string using a stack
    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();

        // Pop characters from the stack to form the reversed string
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string to reverse (or 'exit' to quit): ");
            String input = sc.nextLine();

            // Exit condition before processing
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }

            String reversed = reverseString(input);
            System.out.println("Reversed String: " + reversed);
        }

        sc.close();
    }
}

