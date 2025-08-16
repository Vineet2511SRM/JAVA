import java.util.Scanner;

public class ASCIIProcessor {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Ask user to enter a string
        System.out.print("Enter a string: ");
        String input = obj.nextLine();

        // 1. Display each character and ASCII code
        System.out.println("\nCharacter & ASCII Codes:");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            System.out.println("Character: " + c + ", ASCII: " + (int) c);
        }

        // 2. Classify each character
        System.out.println("\nCharacter Classification:");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            System.out.println("Character: " + c + ", Classification: " + classifyCharacter(c));
        }

        // 3. Case conversion and ASCII values
        System.out.println("\nCase Conversion:");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                char upper = Character.toUpperCase(c);
                char lower = Character.toLowerCase(c);
                System.out.println("Character: " + c + ", Uppercase: " + upper + ", Lowercase: " + lower);
                System.out.println("ASCII - Uppercase: " + (int) upper + ", Lowercase: " + (int) lower);
            }
        }

        // 4. ASCII differences
        System.out.println("\nASCII Differences between Uppercase & Lowercase:");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                int difference = (int) Character.toUpperCase(c) - (int) Character.toLowerCase(c);
                System.out.println("Character: " + c + ", Difference: " + difference);
            }
        }

        // 5. ASCII Art
        System.out.println("\nASCII Art:");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int repeat = (int) c % 10 + 1;
            for (int j = 0; j < repeat; j++) {
                System.out.print(c);
            }
            System.out.print(" ");
        }
        System.out.println();

        // 6. Caesar Cipher
        System.out.print("\nEnter shift value for Caesar cipher: ");
        int shift = obj.nextInt();
        String encrypted = caesarCipher(input, shift);
        System.out.println("Encrypted (Caesar Cipher): " + encrypted);

        // 7. Display ASCII Table (example range 32-126)
        System.out.println("\nASCII Table (32 to 40):");
        displayASCIITable(32, 40);

        // 8. Convert string to ASCII array and back
        System.out.println("\nString to ASCII Array:");
        int[] asciiArr = stringToASCII(input);
        for (int val : asciiArr) System.out.print(val + " ");
        System.out.println();

        System.out.println("ASCII Array back to String: " + asciiToString(asciiArr));

        obj.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        if (Character.isLowerCase(ch)) return "Lowercase Letter";
        if (Character.isDigit(ch)) return "Digit";
        return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32);
        if (Character.isLowerCase(ch)) return (char) (ch - 32);
        return ch;
    }

    public static String caesarCipher(String text, int shift) {
        String shifted = "";
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (Character.isLetter(current)) {
                char base = Character.isLowerCase(current) ? 'a' : 'A';
                current = (char) ((current - base + shift + 26) % 26 + base);
            }
            shifted += current;
        }
        return shifted;
    }

    public static void displayASCIITable(int start, int end) {
        System.out.println("-----------------------------");
        System.out.println(" Code | Char ");
        System.out.println("-----------------------------");
        for (int i = start; i <= end; i++) {
            System.out.printf(" %5d | %4c \n", i, (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int) text.charAt(i);
        }
        return asciiValues;
    }

    public static String asciiToString(int[] asciiValues) {
        String result = "";
        for (int val : asciiValues) {
            result += (char) val;
        }
        return result;
    }
}
