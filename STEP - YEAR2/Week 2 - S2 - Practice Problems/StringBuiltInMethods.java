// Task: Create a program that demonstrates common String methods for text analysis and manipulation.

public class StringBuiltInMethods {

    public static void main(String[] args) {
        String sampleText = "  Java Programming is Fun and Challenging!  ";

        // TODO: Use built-in methods to perform the following operations:
        // 1. Display original string length including spaces
        System.out.println("Original string length (including spaces) is : " + sampleText.length());

        // 2. Remove leading and trailing spaces, show new length
        String trimmedText = sampleText.trim(); // Remove spaces
        System.out.println("String new length after removing leading and trailing spaces is : " + trimmedText.length());

        // 3. Find and display the character at index 5
        String charAtIndex5 = trimmedText.charAt(5) + ""; // Get character at index 5
        System.out.println("Character at index 5 is : " + charAtIndex5);

        // 4. Extract substring "Programming" from the text
        String substring = trimmedText.substring(5, 16); // Extract substring from index 5 to 16
        System.out.println("Extracted substring is : " + substring);

        // 5. Find the index of the word "Fun"
        int indexOfFun = trimmedText.indexOf("Fun");
        System.out.println("Index of the word 'Fun' is : " + indexOfFun);

        // 6. Check if the string contains "Java" (case-sensitive)
        boolean containsJava = trimmedText.contains("Java");
        System.out.println("Does the string contain 'Java'? : " + containsJava);

        // 7. Check if the string starts with "Java" (after trimming)
        boolean startsWithJava = trimmedText.startsWith("Java");
        System.out.println("Does the string start with 'Java'? : " + startsWithJava);

        // 8. Check if the string ends with an exclamation mark
        boolean endsWithExclamation = trimmedText.endsWith("!");
        System.out.println("Does the string end with an exclamation mark? : " + endsWithExclamation);

        // 9. Convert the entire string to uppercase
        String upperCaseText = trimmedText.toUpperCase();
        System.out.println("String in uppercase is : " + upperCaseText);

        // 10. Convert the entire string to lowercase
        String lowerCaseText = trimmedText.toLowerCase();
        System.out.println("String in lowercase is : " + lowerCaseText);

        // TODO: Create a method that counts vowels using charAt()
        int vowelCount = countVowels(trimmedText);

        // TODO: Method to find all positions of a character
        findAllOccurrences(trimmedText, 'a');

        // TODO: Display all results in a formatted manner
        System.out.println("\n===== Summary =====");
        System.out.println("Original text   : \"" + sampleText + "\"");
        System.out.println("Trimmed text    : \"" + trimmedText + "\"");
        System.out.println("Vowel count     : " + vowelCount);
        System.out.println("Contains 'Java' : " + containsJava);
        System.out.println("Starts with 'Java': " + startsWithJava);
        System.out.println("Ends with '!'   : " + endsWithExclamation);
    }

    // TODO: Create a method that counts vowels using charAt()
    public static int countVowels(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i); // counting vowels using charAt()
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    // TODO: Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        System.out.print("All Occurrences of '" + target + "' are found at indices: ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
