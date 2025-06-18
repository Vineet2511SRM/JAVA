import java.util.Scanner;

public class SplitTextToWords {

    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    // Method to manually split string into words
    public static String[] customSplit(String str) {
        int len = findLength(str);
        int spaceCount = 0;

        // First, count spaces to get number of words
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount];
        int index = 0;

        // Store the space indexes
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        // Now extract words using indexes
        String[] words = new String[spaceCount + 1];
        int start = 0;

        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndexes[i];
            String word = "";

            for (int j = start; j < end; j++) {
                word += str.charAt(j);
            }
            words[i] = word;
            start = end + 1;
        }

        // Last word after the last space
        String lastWord = "";
        for (int i = start; i < len; i++) {
            lastWord += str.charAt(i);
        }
        words[spaceCount] = lastWord;

        return words;
    }

    // Compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a full sentence: ");
        String input = sc.nextLine();

        // Manual split
        String[] customWords = customSplit(input);

        // Built-in split
        String[] builtInWords = input.split(" ");

        // Compare
        boolean isSame = compareArrays(customWords, builtInWords);

        // Output
        System.out.println("\n Words using custom method:");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("\n Words using built-in split() method:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\n Are both word arrays same? => " + isSame);
    }
}
