import java.util.Scanner;

public class TextConverterLowerCase {

    // method to manually convert text to lowercase
    public static String manualToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // check if character is Uppercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32); // shifting to lowercase using ASCII magic
            }
            result += ch; // adding the character to result
        }

        return result;
    }

    // method to manually compare two strings
    public static boolean manualCompare(String str1, String str2) {
        // first check if lengths are same
        if (str1.length() != str2.length()) {
            return false;
        }

        // compare character by character
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true; // if all characters matched
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter some text: ");
        String originalText = sc.nextLine();

        // manually converting to lowercase
        String manualLower = manualToLowerCase(originalText);

        // using built-in method
        String builtInLower = originalText.toLowerCase();

        System.out.println("\nText converted manually: " + manualLower);
        System.out.println("Text converted using built-in method: " + builtInLower);

        // comparing both
        boolean isSame = manualCompare(manualLower, builtInLower);

        if (isSame) {
            System.out.println("\nBoth texts are same after conversion!");
        } else {
            System.out.println("\nTexts are different after conversion!");
        }

        sc.close();
    }
}
