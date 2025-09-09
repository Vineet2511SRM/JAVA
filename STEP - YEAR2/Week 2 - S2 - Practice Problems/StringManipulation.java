//Task: Create a text processing utility that uses various string manipulation methods.

import java.util.Scanner;

public class StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Ask user to enter a sentence with mixed formatting
        System.out.println("Enter a sentence with mixed formatting : ");
        String inputSentence = scanner.nextLine();

        // TODO: Process the input using the following methods:
        // 1. trim() - Remove extra spaces
        String trimmedSentence = inputSentence.trim();
        System.out.println("Trimmed sentence is : " + trimmedSentence); // Display trimmed sentence

        // 2. replace() - Replace all spaces with underscores
        String spaceToUnderscore = trimmedSentence.replace(" ", "_");
        System.out.println("Replacing Space to underscore and the sentence is : " + spaceToUnderscore); // Display modified sentence

        // 3. replaceAll() - Remove all digits using regex
        String noDigits = spaceToUnderscore.replaceAll("[0-9]", "");
        System.out.println("Removing all digits and the sentence is : " + noDigits); // Display modified sentence

        // 4. split() - Split sentence into words array
        String[] wordsArray = noDigits.split("_");
        System.out.println("Splitting the sentence into words : ");
        for (String word : wordsArray) {
            System.out.println(word);
        }

        // 5. join() - Rejoin words with " | " separator
        String joinedWords = String.join(" | ", wordsArray);
        System.out.println("Joining words with ' | ' separator : " + joinedWords); // Display joined words

        // TODO: Create additional processing methods:
        // - Remove all punctuation
        String noPunctuation = removePunctuation(noDigits);

        // - Capitalize first letter of each word
        String capitalizedWords = capitalizeWords(noPunctuation);
        System.out.println("Capitalized words are : " + capitalizedWords);

        // - Reverse the order of words
        String reversedWords = reverseWordOrder(capitalizedWords);
        System.out.println("Reversed words are : " + reversedWords);
        
        // - Count word frequency
        countWordFrequency(reversedWords);
        scanner.close();
    }

    // TODO: Method to remove punctuation
    public static String removePunctuation(String text) {
        // Code
        String replace = text.replaceAll("[^a-zA-Z0-9 ]", ""); // replace punctuation with empty string
        return replace;
    }

    // TODO: Method to capitalize each word 
    public static String capitalizeWords(String text) {
        String[] words = text.trim().split("\\s+"); // split on spaces/tabs
        String result = "";

        for (String word : words) {
            if (word.length() > 0) {
                result += Character.toUpperCase(word.charAt(0)) // first letter
                        + word.substring(1).toLowerCase() // rest in lowercase
                        + " ";
            }
        }
        return result.trim(); // remove extra space at the end
    }

    // TODO: Method to reverse word order
    public static String reverseWordOrder(String text) {
        String[] words = text.trim().split("\\s+"); // split on spaces/tabs
        String reversed = "";

        for (int i = words.length - 1; i >= 0; i--) {
            reversed += words[i] + " ";
        }
        return reversed.trim(); // remove last extra space
    }

    // TODO: Method to count word frequency
    public static void countWordFrequency(String text) {
        String[] words = text.trim().toLowerCase().split("\\s+");
        boolean[] visited = new boolean[words.length]; // to mark counted words

        System.out.println("Word Frequency:");
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int count = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        visited[j] = true; // mark as counted
                    }
                }
                System.out.println(words[i] + " : " + count);
            }
        }
    }
}
