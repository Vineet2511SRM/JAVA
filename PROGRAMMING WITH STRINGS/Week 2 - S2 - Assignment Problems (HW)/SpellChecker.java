import java.util.Scanner;
public class SpellChecker {

    // Method to split a sentence into words without using split()
    public static String[] extractWords(String sentence) {
        String[] words = new String[sentence.length()]; // maximum possible words
        int wordCount = 0;
        int start = -1;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            // Consider letters and apostrophe as part of a word
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '\'') {
                if (start == -1) {
                    start = i; // start of a word
                }
            } else {
                if (start != -1) {
                    // extract word using substring
                    words[wordCount++] = sentence.substring(start, i);
                    start = -1;
                }
            }
        }

        // handle last word
        if (start != -1) {
            words[wordCount++] = sentence.substring(start);
        }

        // create exact-sized array
        String[] result = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            result[i] = words[i];
        }

        return result;
    }

    // Method to calculate string distance between two words
    public static int stringDistance(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();
        int distance = 0;

        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                distance++;
            }
        }

        // add difference in length as insertions/deletions
        distance += Math.abs(len1 - len2);

        return distance;
    }

    // Method to find the closest matching word from dictionary
    public static String findClosestWord(String word, String[] dictionary) {
        String closest = word; // default: no suggestion
        int minDistance = Integer.MAX_VALUE;

        for (String dictWord : dictionary) {
            int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (dist < minDistance) {
                minDistance = dist;
                closest = dictWord;
            }
        }

        // return suggestion only if distance <= 2
        return (minDistance <= 2) ? closest : word;
    }

    // Method to display spell check results
    public static void displayResults(String[] words, String[] dictionary) {
        System.out.println("Word\t\tSuggestion\tDistance\tStatus");
        System.out.println("------------------------------------------------------");

        for (String word : words) {
            String suggestion = findClosestWord(word, dictionary);
            int distance = stringDistance(word.toLowerCase(), suggestion.toLowerCase());
            String status = (distance == 0) ? "Correct" : "Misspelled";

            System.out.printf("%-10s\t%-10s\t%-8d\t%-10s\n", word, suggestion, distance, status);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input sentence from user
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        // Input dictionary words
        System.out.println("Enter number of words in dictionary:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] dictionary = new String[n];
        System.out.println("Enter dictionary words:");
        for (int i = 0; i < n; i++) {
            dictionary[i] = sc.nextLine();
        }

        // Extract words from sentence
        String[] words = extractWords(sentence);

        // Display spell check report
        displayResults(words, dictionary);

        sc.close();
    }
}
