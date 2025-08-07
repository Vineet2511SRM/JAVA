public class StringManipulation {
    public static void main(String[] args) {
        // 1. Creating "Java Programming" using different methods:

        // Method 1: String literal (stored in String pool)
        String literalString = "Java Programming";

        // Method 2: new String() constructor (creates a new object in heap)
        String constructedString = new String("Java Programming");

        // Method 3: Character array converted to String
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String charArrayString = new String(charArray);

        // 2. Comparing the strings using == and .equals()

        System.out.println("Comparing literalString and constructedString:");
        System.out.println("Using ==  : " + (literalString == constructedString)); // false (different memory locations)
        System.out.println("Using .equals(): " + literalString.equals(constructedString)); // true (same content)

        System.out.println("\nComparing literalString and charArrayString:");
        System.out.println("Using ==  : " + (literalString == charArrayString)); // false (different objects)
        System.out.println("Using .equals(): " + literalString.equals(charArrayString)); // true (same content)

        System.out.println("\nComparing constructedString and charArrayString:");
        System.out.println("Using ==  : " + (constructedString == charArrayString)); // false (different objects)
        System.out.println("Using .equals(): " + constructedString.equals(charArrayString)); // true (same content)

        // 3. Creating a string with escape sequences
        String quote = "Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects";

        // Displaying the quote with proper formatting
        System.out.println("\n" + quote);

        // 4. Final Explanation
        System.out.println("\nNote:");
        System.out.println("-> '==' compares reference (memory address), so it returns false when objects are different.");
        System.out.println("-> '.equals()' compares actual string values, so it returns true if content matches.");
    }
}
