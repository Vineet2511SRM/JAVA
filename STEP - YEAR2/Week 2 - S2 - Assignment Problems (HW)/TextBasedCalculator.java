import java.util.*;
public class TextBasedCalculator {
    //  Validate expression format
    static boolean validate(String exp) {
        int paren = 0;        // to count parentheses balance
        char prev = ' ';      // track previous char (for operators)

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // only allow digits, operators, parentheses, spaces
            if (!(Character.isDigit(c) || "+-*/() ".indexOf(c) >= 0)) 
                return false;

            // count parentheses
            if (c == '(') paren++;
            if (c == ')') paren--;

            // invalid if more ')' than '(' at any point
            if (paren < 0) return false;

            // check two operators don't come together
            if ("+-*/".indexOf(c) >= 0 && "+-*/".indexOf(prev) >= 0) 
                return false;

            // update prev (ignore spaces)
            if (c != ' ') prev = c;
        }
        return paren == 0;   // valid if parentheses are balanced
    }

    //  Parse numbers/operators into arrays
    static int parse(String exp, int[] nums, char[] ops) {
        int nCount = 0, oCount = 0;   // counters for numbers and operators

        for (int i = 0; i < exp.length();) {
            char c = exp.charAt(i);
            // Handle multi-digit numbers
            if (Character.isDigit(c)) {
                int j = i;
                while (j < exp.length() && Character.isDigit(exp.charAt(j))) j++;

                // substring of digits → convert to integer → store
                nums[nCount++] = Integer.parseInt(exp.substring(i, j));

                i = j; // move to next after the number
            }
            // Handle operators (+ - * /)
            else if ("+-*/".indexOf(c) >= 0) {
                ops[oCount++] = c;
                i++;
            }
            // Ignore spaces
            else i++;
        }
        return oCount; // return number of operators (helps in evaluation)
    }

    //  Evaluate simple expression (no parentheses)
    static int evalSimple(int[] nums, char[] ops, int oCount, StringBuilder steps) {
        int nCount = oCount + 1; // number of numbers = operators + 1
        // First handle * and /
        for (int i = 0; i < oCount;) {
            char op = ops[i];
            if (op == '*' || op == '/') {
                int a = nums[i], b = nums[i + 1];
                int res = (op == '*') ? a * b : a / b;

                // shift nums left after evaluation
                nums[i] = res;
                for (int k = i + 1; k < nCount - 1; k++) nums[k] = nums[k + 1];
                nCount--;

                // shift ops left
                for (int k = i; k < oCount - 1; k++) ops[k] = ops[k + 1];
                oCount--;

                steps.append(a).append(" ").append(op).append(" ")
                     .append(b).append(" = ").append(res).append("\n");
            } else {
                i++; // move ahead for +, -
            }
        }

        // Now handle + and -
        int result = nums[0];
        for (int i = 0; i < oCount; i++) {
            char op = ops[i];
            int b = nums[i + 1];
            result = (op == '+') ? result + b : result - b;

            steps.append(nums[i]).append(" ").append(op).append(" ")
                 .append(b).append(" = ").append(result).append("\n");

            nums[i + 1] = result; // carry forward result
        }

        return result;
    }

    //  Evaluate expression with parentheses
    static int evalWithParen(String exp, StringBuilder steps) {
        while (exp.contains("(")) {
            int close = exp.indexOf(")");
            int open = exp.lastIndexOf("(", close);

            // expression inside ( )
            String inside = exp.substring(open + 1, close);

            // recursively evaluate inner part
            int val = evalWithParen(inside, steps);

            // replace (inside) with result
            exp = exp.substring(0, open) + val + exp.substring(close + 1);

            steps.append("Replace (").append(inside).append(") with ")
                 .append(val).append("\n");
        }

        // allocate arrays (size = length of string for safety)
        int[] nums = new int[exp.length()];
        char[] ops = new char[exp.length()];

        // fill arrays
        int oCount = parse(exp, nums, ops);

        // evaluate without parentheses
        return evalSimple(nums, ops, oCount, steps);
    }

    //  Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter expression (or 'exit'):");
            String exp = sc.nextLine();

            if (exp.equalsIgnoreCase("exit")) break;

            // validate before processing
            if (!validate(exp)) {
                System.out.println("Invalid expression ");
                continue;
            }

            // build steps for explanation
            StringBuilder steps = new StringBuilder();
            steps.append("Original: ").append(exp).append("\n\n");
            int res = evalWithParen(exp, steps);
            steps.append("\nFinal Result = ").append(res);
            // print step-by-step process
            System.out.println(steps);
        }
        sc.close();
    }
}
