import java.util.Scanner;

public class WordLengthInfo {

    // Find length of a string without using length()
    public static int getLength(String text) {
        int size = 0;
        try {
            while (true) {
                text.charAt(size);
                size++;
            }
        } catch (Exception e) {
            return size;
        }
    }

    // Manually split string into words
    public static String[] manualSplit(String input) {
        int totalLength = getLength(input);
        int countSpaces = 0;

        // Count number of spaces
        for (int i = 0; i < totalLength; i++) {
            if (input.charAt(i) == ' ') {
                countSpaces++;
            }
        }

        int[] positions = new int[countSpaces];
        int posIndex = 0;

        // Store space positions
        for (int i = 0; i < totalLength; i++) {
            if (input.charAt(i) == ' ') {
                positions[posIndex++] = i;
            }
        }

        // Create array for words
        String[] resultWords = new String[countSpaces + 1];
        int start = 0;

        for (int i = 0; i < countSpaces; i++) {
            int end = positions[i];
            String word = "";

            for (int j = start; j < end; j++) {
                word += input.charAt(j);
            }

            resultWords[i] = word;
            start = end + 1;
        }

        // Last word
        String last = "";
        for (int i = start; i < totalLength; i++) {
            last += input.charAt(i);
        }

        resultWords[countSpaces] = last;
        return resultWords;
    }

    // Create 2D array of word and its length
    public static String[][] wordLengthData(String[] wordsList) {
        int count = wordsList.length;
        String[][] info = new String[count][2];

        for (int i = 0; i < count; i++) {
            info[i][0] = wordsList[i];
            int len = getLength(wordsList[i]);
            info[i][1] = String.valueOf(len);
        }

        return info;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Type your sentence here: ");
        String line = input.nextLine();

        String[] words = manualSplit(line);
        String[][] table = wordLengthData(words);

        // Display as table
        System.out.println("\n Words and Lengths:");
        System.out.println("----------------------------------");
        System.out.println("|     Word     |     Length      |");
        System.out.println("----------------------------------");

        for (int i = 0; i < table.length; i++) {
            String w = table[i][0];
            int l = Integer.parseInt(table[i][1]);
            System.out.printf("| %-12s|     %-10d|\n", w, l);
        }

        System.out.println("----------------------------------");
    }
}
