import java.util.Scanner;

public class ShortestLongestString {

    // Method to split text into words using charAt (without split)
    public static String[] splitIntoWords(String text) {
        String[] words = new String[100]; // Assume max 100 words
        int wordCount = 0;
        String currentWord = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (!currentWord.equals("")) {
                    words[wordCount++] = currentWord;
                    currentWord = "";
                }
            }
        }

        if (!currentWord.equals("")) {
            words[wordCount++] = currentWord;
        }

        // Trim the array to the actual word count
        String[] finalWords = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            finalWords[i] = words[i];
        }

        return finalWords;
    }

    // Method to get length of a string without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Reached end of string
        }
        return count;
    }

    // Method to create a 2D array of word and their lengths
    public static String[][] mapWordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }

        return result;
    }

    // Method to find shortest and longest word from 2D array
    public static int[] findShortestAndLongest(String[][] wordLengthArray) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int minLength = Integer.parseInt(wordLengthArray[0][1]);
        int maxLength = Integer.parseInt(wordLengthArray[0][1]);

        for (int i = 1; i < wordLengthArray.length; i++) {
            int length = Integer.parseInt(wordLengthArray[i][1]);
            if (length < minLength) {
                minLength = length;
                shortestIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                longestIndex = i;
            }
        }

        // Return index of shortest and longest word
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your text: ");
        String input = sc.nextLine();

        String[] words = splitIntoWords(input);
        String[][] wordLengthArray = mapWordsWithLength(words);
        int[] resultIndexes = findShortestAndLongest(wordLengthArray);

        System.out.println("Shortest word: " + wordLengthArray[resultIndexes[0]][0]);
        System.out.println("Longest word: " + wordLengthArray[resultIndexes[1]][0]);
    }
}
