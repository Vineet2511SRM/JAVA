import java.util.Scanner;

public class NonRepeatingCharacter {

    // Method to find first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256]; // array to store frequency of each char (ASCII range)

        // counting frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++; // increment the count for this character
        }

        // finding the first char whose frequency is 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch; // found the first non-repeating char
            }
        }

        return '\0'; // return null char if not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine(); // taking user input

        char ans = findFirstNonRepeatingChar(input); // calling our method

        if (ans != '\0') {
            System.out.println("First non-repeating character is: " + ans);
        } else {
            System.out.println("No non-repeating character found in the string.");
        }

        sc.close();
    }
}
