import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    // Method to check if parentheses are balanced
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // Push opening brackets to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Handle closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack empty → no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check for matching pairs
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Balanced if stack is empty at the end
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an expression (or 'exit' to quit): ");
            String expression = sc.nextLine();

            // Exit condition before processing
            if (expression.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }

            if (isBalanced(expression)) {
                System.out.println("Balanced");
            } else {
                System.out.println("Not Balanced");
            }
        }

        sc.close();
    }
}
