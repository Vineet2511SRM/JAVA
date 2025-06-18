import java.util.Scanner;

public class AnagramChecker {

    // Method to check if two texts are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        // First, check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create frequency arrays for both strings
        int[] freq1 = new int[256]; // ASCII characters
        int[] freq2 = new int[256];

        // Count frequency for str1
        for (int i = 0; i < str1.length(); i++) {
            freq1[str1.charAt(i)]++;
        }

        // Count frequency for str2
        for (int i = 0; i < str2.length(); i++) {
            freq2[str2.charAt(i)]++;
        }

        // Compare both frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true; // If all frequencies matched
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first text: ");
        String text1 = sc.nextLine();

        System.out.print("Enter the second text: ");
        String text2 = sc.nextLine();

        // Convert to lowercase to make it case-insensitive
        boolean result = areAnagrams(text1.toLowerCase(), text2.toLowerCase());

        System.out.println("\nAnagram Check Result:");
        System.out.println("----------------------");
        if (result) {
            System.out.println("Yes! \"" + text1 + "\" and \"" + text2 + "\" are Anagrams 🔁✅");
        } else {
            System.out.println("Nope! \"" + text1 + "\" and \"" + text2 + "\" are not Anagrams ❌");
        }

        sc.close();
    }
}
