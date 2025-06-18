import java.util.Scanner;

public class CustomStringTrimmer {

    // Method to find the start and end index (non-space) using charAt
    public static int[] findTrimBounds(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Find first non-space from left
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Find first non-space from right
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt() manually
    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with leading/trailing spaces: ");
        String input = sc.nextLine();

        // Step 1: Find bounds
        int[] bounds = findTrimBounds(input);
        int start = bounds[0];
        int end = bounds[1];

        // Step 2: Create trimmed string manually
        String customTrimmed = customSubstring(input, start, end);

        // Step 3: Built-in trim for comparison
        String builtInTrim = input.trim();

        // Step 4: Compare
        boolean isSame = compareStrings(customTrimmed, builtInTrim);

        // Step 5: Display results
        System.out.println("\nOriginal String: [" + input + "]");
        System.out.println("Custom Trimmed : [" + customTrimmed + "]");
        System.out.println("Built-in Trim  : [" + builtInTrim + "]");
        System.out.println("Both Are Same? : " + isSame);
    }
}
