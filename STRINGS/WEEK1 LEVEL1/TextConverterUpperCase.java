import java.util.Scanner;

public class TextConverterUpperCase {

    // method to manually convert text to uppercase
    public static String manualToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // check if the character is lowercase
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32); // shifting to uppercase using ASCII magic
            }
            result += ch; // adding the character to the result
        }

        return result;
    }

    // method to compare two strings manually
    public static boolean manualCompare(String str1, String str2) {
        // if lengths are different, no need to check further
        if (str1.length() != str2.length()) {
            return false;
        }

        // comparing character by character
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true; // if all characters matched
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String originalText = sc.nextLine();

        // using manual method
        String manualUpper = manualToUpperCase(originalText);

        // using built-in method
        String builtInUpper = originalText.toUpperCase();

        System.out.println("\nText converted manually: " + manualUpper);
        System.out.println("Text converted using built-in method: " + builtInUpper);

        // comparing both results
        boolean isSame = manualCompare(manualUpper, builtInUpper);

        if (isSame) {
            System.out.println("\nBoth texts are same after conversion!");
        } else {
            System.out.println("\nTexts are different after conversion!");
        }

        sc.close();
    }
}
