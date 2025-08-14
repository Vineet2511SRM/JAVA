import java.util.Scanner;

public class StringSplit {

    public static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // reached end
        }
        return count;
    }

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

    public static boolean compareWords(String[] words1, String[] words2) {
        if (words1.length != words2.length) {
            return false;
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Custom length method
        int length = findLength(input);
        System.out.println("Length of the string: " + length);

        // Custom split method
        String[] customSplit = splitText(input);
        System.out.println("Words in the string (user-defined method):");
        for (String word : customSplit) {
            System.out.println(word);
        }

        // Built-in split method
        String[] builtInSplit = input.split(" ");
        System.out.println("Words in the string (built-in method):");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        // Compare both outputs
        boolean areEqual = compareWords(customSplit, builtInSplit);
        System.out.println("Are the two methods' outputs equal? " + areEqual);
    }
}
