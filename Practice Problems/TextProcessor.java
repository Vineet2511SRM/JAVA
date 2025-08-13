import java.util.Scanner;
public class TextProcessor {

    // TODO: Method to clean and validate input
    public static String cleanInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        // Remove extra spaces
        input = input.trim().replaceAll("\\s+", " ");

        // Convert to Proper Case (capitalize first letter of each word)
        String[] words = input.split(" ");
        StringBuilder properCase = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                properCase.append(Character.toUpperCase(word.charAt(0)))
                          .append(word.substring(1).toLowerCase())
                          .append(" ");
            }
        }
        return properCase.toString().trim();
    }

    // TODO: Method to analyze text
    public static void analyzeText(String text) {
        if (text.isEmpty()) {
            System.out.println("No text to analyze.");
            return;
        }

        // Count: words
        String[] words = text.split("\\s+");
        int wordCount = words.length;

        // Count: sentences
        String[] sentences = text.split("[.!?]+");
        int sentenceCount = 0;
        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                sentenceCount++;
            }
        }

        // Count: characters (excluding spaces)
        int charCount = text.replace(" ", "").length();

        // Find: longest word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // Find: most common character
        int[] freq = new int[256];
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                freq[c]++;
            }
        }
        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mostCommonChar = (char) i;
            }
        }

        // Display statistics
        System.out.println("\n--- TEXT ANALYSIS ---");
        System.out.println("Word count: " + wordCount);
        System.out.println("Sentence count: " + sentenceCount);
        System.out.println("Character count (no spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommonChar + "' (" + maxFreq + " times)");
    }

    // TODO: Method to create word array and sort alphabetically
    public static String[] getWordsSorted(String text) {
        // Remove punctuation
        text = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = text.split("\\s+");

        // Simple selection sort (case-insensitive)
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareToIgnoreCase(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Create a text processor that:
        // 1. Asks user for a paragraph of text
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.println("Enter a paragraph:");
        String input = scanner.nextLine();

        // 2. Cleans and validates the input
        String cleaned = cleanInput(input);
        if (cleaned.isEmpty()) {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }

        // 3. Analyzes the text
        analyzeText(cleaned);

        // 4. Shows the words in alphabetical order
        System.out.println("\n--- SORTED WORDS ---");
        String[] sortedWords = getWordsSorted(cleaned);
        for (String word : sortedWords) {
            System.out.println(word);
        }

        // 5. Allows user to search for specific words
        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.nextLine().trim();
        boolean found = false;
        for (String word : sortedWords) {
            if (word.equalsIgnoreCase(searchWord)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("'" + searchWord + "' was found in the text.");
        } else {
            System.out.println("'" + searchWord + "' was NOT found in the text.");
        }

        scanner.close();
    }
}
