import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {

    // Method to evaluate postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Split by spaces
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            // If token is a number → push it
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } 
            // If token is an operator → pop two operands
            else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression!");
                }

                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } 
            else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        // Final result should be the only element in stack
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression!");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a postfix expression (or 'quit' to exit): ");
            String expression = sc.nextLine().trim();

            // Exit condition before processing
            if (expression.equalsIgnoreCase("quit")) {
                System.out.println("Program terminated.");
                break;
            }

            try {
                int result = evaluatePostfix(expression);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: Invalid Expression");
            }
        }

        sc.close();
    }
}


