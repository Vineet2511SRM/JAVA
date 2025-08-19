
import java.util.Scanner;
public class ReplaceSubstring {
    public static void main(String[] args) {
        // Your main method implementation
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the main text : ");
        String mainText = obj.nextLine();

        System.out.println("Enter the substring to find and replace: ");
        String subString = obj.nextLine();

        System.out.println("Enter the replacement substring: ");
        String replacement = obj.nextLine();

        int[] occurrences = findSubstringOccurrences(mainText, subString);
        String replacedText = replaceSubstring(mainText, subString, replacement);
        boolean isEqual = compareWithBuiltInReplace(mainText, subString, replacement);

        System.out.println("Occurrences found at: ");
        for (int index : occurrences) {
            System.out.print(index + " ");
        }
        System.out.println("\nReplaced Text: " + replacedText);
        System.out.println("Comparison with built-in replace(): " + (isEqual ? "Equal" : "Not Equal"));
    }

    public static int[] findSubstringOccurrences(String text, String substring) {
        // Your implementation to find all occurrences of the substring
        int count = 0;
        int index = text.indexOf(substring); // Find the first occurrence

        while(index != -1){ // Loop until no more occurrences are found
            count++;
            index = text.indexOf(substring, index + 1); // Find the next occurrence
        }

        // Store the starting positions in an array
        int[] positions = new int[count];
        index = text.indexOf(substring); // Find the first occurrence
        int pos = 0;
        while (index != -1) {
            positions[pos++] = index; // Store the position
            index = text.indexOf(substring, index + 1); // Find the next occurrence
        }
        return positions;
    }

    public static String replaceSubstring(String text, String substring, String replacement) {
        // Your implementation to replace the substring manually
        StringBuilder result = new StringBuilder(); // create a StringBuilder for efficiency
        int index = 0;
        int subLength = substring.length(); // Get the length of the substring

        while (index < text.length()) {
            if (text.startsWith(substring, index)) { // Checking if the substring matches
                result.append(replacement);  // Append the replacement substring
                index += subLength;
            } else {
                result.append(text.charAt(index)); // if not a match, append the current character because it is not part of the substring
                index++;
            }
        }
        return result.toString();
    }

    public static boolean compareWithBuiltInReplace(String text, String substring, String replacement) {
        // Your implementation to compare with built-in replace method
        String replacedText = text.replace(substring, replacement); // Using built-in replace method
        String manualReplacedText = replaceSubstring(text, substring, replacement); // Using custom method

        return replacedText.equals(manualReplacedText); // Compare the results
    }
}