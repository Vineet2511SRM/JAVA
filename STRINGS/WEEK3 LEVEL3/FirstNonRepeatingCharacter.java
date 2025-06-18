import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character using charAt()
    public static char findFirstNonRepeatingChar(String str) {
        int[] freq = new int[256]; // ASCII characters frequency array

        // First loop: Count frequency of each character
        for (int i = 0; ; i++) {
            try {
                char ch = str.charAt(i);
                freq[(int) ch]++;
            } catch (Exception e) {
                break; // End of string
            }
        }

        // Second loop: Find first character with frequency 1
        for (int i = 0; ; i++) {
            try {
                char ch = str.charAt(i);
                if (freq[(int) ch] == 1) {
                    return ch;
                }
            } catch (Exception e) {
                break;
            }
        }

        return '\0'; // null char if no non-repeating character
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}
