//  program to find vowels and consonants in a string and display the count of Vowels and Consonants in the string
import java.util.Scanner;

public class VowelAndConsonant {
    // Create a method to check if the character is a vowel or consonant and return the result.
    // i. Convert the character to lowercase if it is an uppercase letter using the ASCII values of the characters
    public static String checkCharacterType(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32); // ASCII conversion to lowercase
        }

        // Check if letter
        if (ch >= 'a' && ch <= 'z') {
            // Check vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to find vowel and consonant counts using charAt()
    public static int[] findVowelsAndConsonants(String str) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Get character at index i
            String result = checkCharacterType(ch); // Check character type

            if (result.equals("Vowel")) { // If it's a vowel
                vowelCount++;
            } else if (result.equals("Consonant")) { // If it's a consonant
                consonantCount++;
            }
        }

        return new int[]{vowelCount, consonantCount}; // Return the counts
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        //Check character types
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String result = checkCharacterType(ch);
            System.out.println("Character: " + ch + " - " + result);
        }

        // Get counts
        int[] counts = findVowelsAndConsonants(input);

        // Display result
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);

        sc.close();
    }
}
    


