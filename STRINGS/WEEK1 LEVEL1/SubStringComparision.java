import java.util.Scanner;

public class SubStringComparision {

    // Method to create a substring manually using charAt()
    public static String createSubStringUsingCharAt(String str, int start, int end) {
        char[] ch = new char[end - start];
        for (int i = start; i < end; i++) {
            ch[i - start] = str.charAt(i);
        }
        return new String(ch);
    }

    // Method to compare two strings manually using charAt()
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter the main string: ");
        String str = obj.nextLine();

        System.out.println("Enter the start index of the substring: ");
        int start = obj.nextInt();

        System.out.println("Enter the end index of the substring: ");
        int end = obj.nextInt();

        // Create substring using charAt()
        String subStrUsingCharAt = createSubStringUsingCharAt(str, start, end);

        // Create substring using built-in substring() method
        String subStrUsingBuiltIn = str.substring(start, end);

        // Compare substrings using charAt()
        boolean areEqual = compareStringsUsingCharAt(subStrUsingCharAt, subStrUsingBuiltIn);

        // Displaying the results
        System.out.println("\nSubstring using charAt(): " + subStrUsingCharAt);
        System.out.println("Substring using substring(): " + subStrUsingBuiltIn);
        System.out.println("Are both substrings equal? " + areEqual);

        obj.close();
    }
}
