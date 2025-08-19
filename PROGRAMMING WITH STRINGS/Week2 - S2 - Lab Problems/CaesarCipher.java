import java.util.Scanner;

public class CaesarCipher {

    // Encrypt method
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                char c = (char) ((ch - 'A' + shift) % 26 + 'A');
                result.append(c);
            } else if (ch >= 'a' && ch <= 'z') {
                char c = (char) ((ch - 'a' + shift) % 26 + 'a');
                result.append(c);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Decrypt method
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    // Display ASCII values
    public static void displayAscii(String label, String text) {
        System.out.println(label + " : " + text);
        System.out.print("ASCII Values: ");
        for (char ch : text.toCharArray()) {
            System.out.print((int) ch + " ");
        }
        System.out.println("\n");
    }

    // Validation
    public static boolean validate(String original, String decrypted) {
        return original.equals(decrypted);
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(input, shift);
        String decrypted = decrypt(encrypted, shift);

        displayAscii("Original Text", input);
        displayAscii("Encrypted Text", encrypted);
        displayAscii("Decrypted Text", decrypted);

        System.out.println("Validation: " + validate(input, decrypted));
    }
}
