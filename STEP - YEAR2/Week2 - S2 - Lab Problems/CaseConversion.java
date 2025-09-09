import java.util.Scanner;

public class CaseConversion {

    // Convert to UPPERCASE manually
    public static String convertUpperCase(String upper) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < upper.length(); i++) {
            char ch = upper.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result.append(ch);
        }
        return result.toString();
    }

    // Convert to lowercase manually
    public static String convertLowerCase(String lower) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result.append(ch);
        }
        return result.toString();
    }

    // Convert to Title Case manually
    public String titleCaseConversion(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // First character OR previous character is space
            if (i == 0 || str.charAt(i - 1) == ' ') {
                if (ch >= 'a' && ch <= 'z') {
                    ch = (char) (ch - 32); // lowercase → uppercase
                }
            } else {
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + 32); // uppercase → lowercase
                }
            }

            result.append(ch);
        }

        return result.toString();
    }

    // Compare custom with built-in
    public static boolean Comparison() {
        String testString = "Hello World";
        String upperCaseResult = testString.toUpperCase();
        String lowerCaseResult = testString.toLowerCase();

        // Call custom methods
        String customUpperCaseResult = convertUpperCase(testString);
        String customLowerCaseResult = convertLowerCase(testString);

        // Compare results
        boolean isUpperCaseEqual = upperCaseResult.equals(customUpperCaseResult);
        boolean isLowerCaseEqual = lowerCaseResult.equals(customLowerCaseResult);

        return isUpperCaseEqual && isLowerCaseEqual;
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Custom Uppercase: " + convertUpperCase(input));
        System.out.println("Custom Lowercase: " + convertLowerCase(input));

        CaseConversion cc = new CaseConversion();
        System.out.println("Custom Title Case: " + cc.titleCaseConversion(input));

        System.out.println("Comparison with built-in: " + Comparison());
    }
}
