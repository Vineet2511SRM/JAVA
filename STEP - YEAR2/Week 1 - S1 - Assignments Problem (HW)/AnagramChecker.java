import java.util.Scanner;

public class AnagramChecker {

    // Method to check if two texts are anagrams
    public static boolean isAnagram(String firstText, String secondText) {

        // Remove spaces and convert to lowercase for fair comparison
        String text1 = firstText.replaceAll("\\s+", "").toLowerCase();
        String text2 = secondText.replaceAll("\\s+", "").toLowerCase();

        // Step 1: If lengths don't match → not an anagram
        if (text1.length() != text2.length()) {
            return false;
        }

        // Step 2: Arrays to store frequency of each character
        int[] freqText1 = new int[256]; // For all ASCII characters
        int[] freqText2 = new int[256];

        // Step 3: Count character frequencies
        for (int i = 0; i < text1.length(); i++) {
            freqText1[text1.charAt(i)]++;
            freqText2[text2.charAt(i)]++;
        }

        // Step 4: Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freqText1[i] != freqText2[i]) {
                return false; // Mismatch found → not an anagram
            }
        }

        return true; // All characters match → an anagram
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String firstInput = sc.nextLine();

        System.out.print("Enter second text: ");
        String secondInput = sc.nextLine();

        // Call method and display result
        if (isAnagram(firstInput, secondInput)) {
            System.out.println("The texts are Anagrams.");
        } else {
            System.out.println("The texts are NOT Anagrams.");
        }

        sc.close();
    }
}
