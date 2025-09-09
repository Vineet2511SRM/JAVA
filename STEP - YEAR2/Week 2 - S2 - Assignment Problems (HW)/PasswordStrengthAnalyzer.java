
import java.util.*;
public class PasswordStrengthAnalyzer {
    public static int[] analyze(String pass) {
        int upper = 0, lower = 0, digit = 0, special = 0;
        for (char ch : pass.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upper++;
            } else if (Character.isLowerCase(ch)) {
                lower++;
            } else if (Character.isDigit(ch)) {
                digit++;
            } else if (!Character.isLetterOrDigit(ch)) {
                special++;
            }
        }

        return new int[]{upper, lower, digit, special};
    }
    //Calculate password strength score
    public static int calculateStrength(String password, int[] counts) {
        int score = 0;
        int length = password.length(); // Password length
        if (length > 8) {
            score += (length - 8) * 2;   // Length points
        }        // Character variety
        if (counts[0] > 0) {
            score += 10; // Upper

                }if (counts[1] > 0) {
            score += 10; // Lower

                }if (counts[2] > 0) {
            score += 10; // Digits

                }if (counts[3] > 0) {
            score += 10; // Special
        }        // Deduct points for common patterns
        String pwLower = password.toLowerCase();
        String[] patterns = {"123", "abc", "qwerty", "password"};
        for (String p : patterns) {
            if (pwLower.contains(p)) {
                score -= 10;
            }
        }
        return Math.max(score, 0);
    }

    // Get strength level
    public static String getStrengthLevel(int score) {
        if (score <= 20) {
            return "Weak"; 
        }else if (score <= 50) {
            return "Medium"; 
        }else {
            return "Strong";
        }
    }

    // Generate strong password
    public static String generatePassword(int length) {
        if (length < 8) {
            length = 8;
        }
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+[]{}<>?/";

        String allChars = upper + lower + digits + special;
        Random r = new Random();
        StringBuilder pw = new StringBuilder();

        // Ensure at least one character of each type
        pw.append(upper.charAt(r.nextInt(upper.length())));
        pw.append(lower.charAt(r.nextInt(lower.length())));
        pw.append(digits.charAt(r.nextInt(digits.length())));
        pw.append(special.charAt(r.nextInt(special.length())));
        // Fill remaining
        for (int i = 4; i < length; i++) {
            pw.append(allChars.charAt(r.nextInt(allChars.length())));
        }
        // Shuffle
        char[] arr = pw.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int j = r.nextInt(arr.length);
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return new String(arr);
    }
    //method to display analysis results in tabular format:
    public static void displayResults(String[] passwords) {
        System.out.printf("%-20s %-6s %-6s %-6s %-6s %-6s %-6s %-10s%n",
                "Password", "Length", "Upper", "Lower", "Digits", "Special", "Score", "Strength");
        System.out.println("----------------------------------------------------------------------------");

        for (String pw : passwords) {
            int[] counts = analyze(pw);
            int score = calculateStrength(pw, counts);
            String level = getStrengthLevel(score);
            System.out.printf("%-20s %-6d %-6d %-6d %-6d %-6d %-6d %-10s%n",
                    pw, pw.length(), counts[0], counts[1], counts[2], counts[3], score, level);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Analyze multiple passwords
        System.out.print("Enter number of passwords to analyze: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] passwords = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter password " + (i + 1) + ": ");
            passwords[i] = sc.nextLine();
        }
        System.out.println("\nPassword Analysis:");
        displayResults(passwords);

        // Generate new strong passwords
        System.out.print("\nHow many strong passwords to generate? ");
        int genCount = sc.nextInt();
        System.out.print("Desired length for generated passwords: ");
        int genLength = sc.nextInt();
        System.out.println("\nGenerated Strong Passwords:");
        for (int i = 0; i < genCount; i++) {
            System.out.println(generatePassword(genLength));
        }
        sc.close();
    }
}
