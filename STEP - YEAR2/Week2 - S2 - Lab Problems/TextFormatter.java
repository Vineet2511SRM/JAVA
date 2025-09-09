import java.util.Scanner;

public class TextFormatter {

    // Method to split text into words without using split()
    public static String[] extractWords(String text) {
        String[] words = new String[text.length()]; // max possible words
        int wordCount = 0;
        int start = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (start != i) { // avoid multiple spaces
                    words[wordCount++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }

        // last word
        if (start < text.length()) {
            words[wordCount++] = text.substring(start);
        }

        // trim array to actual size
        String[] finalWords = new String[wordCount];
        for (int i = 0; i < wordCount; i++) finalWords[i] = words[i];
        return finalWords;
    }

    // Method to justify text (extra spaces distributed evenly)
    public static String justify(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;

            // add words until limit is reached
            while (j < words.length && lineLen + 1 + words[j].length() <= width) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // Last line or single word → left align
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                // fill remaining with spaces
                while (line.length() < width) line.append(" ");
            } else {
                // distribute spaces
                int totalSpaces = width - (lineLen - gaps);
                int spaceEach = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaceEach; s++) line.append(" ");
                        if (extra > 0) {
                            line.append(" ");
                            extra--;
                        }
                    }
                }
            }

            result.append(line).append("\n");
            i = j;
        }
        return result.toString();
    }

    // Method to center align text
    public static String centerAlign(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();
        int i = 0;

        while (i < words.length) {
            if (line.length() + words[i].length() <= width) {
                if (line.length() > 0) line.append(" ");
                line.append(words[i]);
                i++;
            } else {
                int spaces = width - line.length();
                int leftPad = spaces / 2;
                StringBuilder centered = new StringBuilder();
                for (int p = 0; p < leftPad; p++) centered.append(" ");
                centered.append(line);
                result.append(centered).append("\n");
                line.setLength(0);
            }
        }

        if (line.length() > 0) {
            int spaces = width - line.length();
            int leftPad = spaces / 2;
            StringBuilder centered = new StringBuilder();
            for (int p = 0; p < leftPad; p++) centered.append(" ");
            centered.append(line);
            result.append(centered).append("\n");
        }

        return result.toString();
    }

    // Method to compare performance: StringBuilder vs String concatenation
    public static void performanceTest(String[] words, int width) {
        long start, end;

        // Using StringBuilder
        start = System.nanoTime();
        String justified1 = justify(words, width);
        end = System.nanoTime();
        long sbTime = end - start;

        // Using String concatenation
        start = System.nanoTime();
        String result = "";
        for (String w : words) result += w + " "; // simple concat
        end = System.nanoTime();
        long strTime = end - start;

        System.out.println("Performance Comparison:");
        System.out.println("StringBuilder Time   : " + sbTime + " ns");
        System.out.println("String Concatenation : " + strTime + " ns");
    }

    // Display formatted text with line numbers and char count
    public static void displayWithStats(String text) {
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.printf("Line %2d (%2d chars): %s\n", i + 1, lines[i].length(), lines[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.println("Enter the text:");
        String input = sc.nextLine();
        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        // Extract words
        String[] words = extractWords(input);

        // Justified text
        String justified = justify(words, width);

        // Center aligned text
        String centered = centerAlign(words, width);

        // Output
        System.out.println("\nOriginal Text: " + input);
        System.out.println("\n=== Justified Text ===");
        displayWithStats(justified);

        System.out.println("\n=== Center Aligned Text ===");
        displayWithStats(centered);

        System.out.println();
        performanceTest(words, width);
    }
}
