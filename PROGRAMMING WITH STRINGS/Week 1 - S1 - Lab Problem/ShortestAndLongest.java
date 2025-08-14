
import java.util.Scanner;

// Java program to find the shortest and longest strings in a given text
public class ShortestAndLongest {

    // Method to find and return string's length without using length() method
    public static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Handles exception
        }
        return count;
    }

    // Method to split the text into words using the charAt() method without using the String built-in split() method and return the words.
    public static String[] splitText(String s) {
        int length = findLength(s);

        // Count number of words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store space indexes
        int[] spaceIndexes = new int[wordCount];
        int currentIndex = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                spaceIndexes[currentIndex] = i;
                currentIndex++;
            }
        }
        spaceIndexes[currentIndex] = length; // end of last word

        // Extract words
        String[] words = new String[wordCount];
        int startIndex = 0;
        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = startIndex; j < spaceIndexes[i]; j++) {
                word += s.charAt(j);
            }
            words[i] = word;
            startIndex = spaceIndexes[i] + 1;
        }

        return words;
    }

    // method to take the word array and return a 2D String array of the word and its corresponding length. Use String built-in function String.valueOf() to generate the String value for the number
    public static String[][] getWordsAndLengths(String[] words) {
        String[][] result = new String[words.length][2]; // 2D array to hold words and their lengths 
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i]; // Word
            result[i][1] = String.valueOf(findLength(words[i])); // Length
        }
        return result;
    }

    // Method that takes the 2D array of word and corresponding length as parameters, find the shortest and longest string and return them in an 1D int array.
    public static int[] findShortestAndLongest(String[][] wordsAndLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordsAndLengths.length; i++) {
            if (Integer.parseInt(wordsAndLengths[i][1]) < Integer.parseInt(wordsAndLengths[shortestIndex][1])) {
                shortestIndex = i;
            }
            if (Integer.parseInt(wordsAndLengths[i][1]) > Integer.parseInt(wordsAndLengths[longestIndex][1])) {
                longestIndex = i;
            }
        }

        // Integer.parseInt is used to convert the String representation of the length to an int for comparison.
        return new int[]{shortestIndex, longestIndex}; // 1D array containing the indices of the shortest and longest words
    }

    // main method that calls all methods and shows the result
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = obj.nextLine();

        // Length of the string
        int length = findLength(input);
        System.out.println("Length of the string: " + length);

        // Split the text into words
        String[] words = splitText(input);
        System.out.println("Words in the string: ");
        for (String word : words) {
            System.out.println(word);
        }

        // Get words and their lengths
        String[][] wordsAndLengths = getWordsAndLengths(words);

        // Find shortest and longest words
        int[] shortestAndLongest = findShortestAndLongest(wordsAndLengths);
        System.out.println("Shortest word: " + words[shortestAndLongest[0]]+ " (" + wordsAndLengths[shortestAndLongest[0]][1] + " letters)"); // displays shortest word along with its length

        System.out.println("Longest word: " + words[shortestAndLongest[1]]+ " (" + wordsAndLengths[shortestAndLongest[1]][1] + " letters)"); // displays longest word along with its length

    }
}
