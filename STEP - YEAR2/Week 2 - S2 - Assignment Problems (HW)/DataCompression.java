
import java.util.*;

public class DataCompression {

    // Count frequency of each character in a string
    static Object[] countFreq(String text) {
        char[] chars = new char[text.length()];
        int[] freq = new int[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int idx = -1;
            for (int j = 0; j < count; j++) {
                if (chars[j] == c) {
                    idx = j;
                    break;
                }
            }
            if (idx == -1) {
                chars[count] = c;
                freq[count++] = 1;
            } else {
                freq[idx]++;
            }
        }
        char[] uniqueChars = new char[count];
        int[] frequencies = new int[count];
        for (int i = 0; i < count; i++) {
            uniqueChars[i] = chars[i];
            frequencies[i] = freq[i];
        }
        return new Object[]{uniqueChars, frequencies};
    }

    // Create compression codes using StringBuilder
    static String[][] makeCodes(char[] chars, int[] freq) {
        Integer[] idx = new Integer[chars.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> freq[b] - freq[a]); // descending frequency

        String[][] map = new String[chars.length][2];
        int codeLen = 1, counter = 0;

        for (int i = 0; i < chars.length; i++) {
            if (counter >= (int) Math.pow(10, codeLen)) {
                codeLen++;
                counter = 0;
            }
            StringBuilder code = new StringBuilder();
            code.append(String.format("%0" + codeLen + "d", counter));
            map[i][0] = String.valueOf(chars[idx[i]]);
            map[i][1] = code.toString();
            counter++;
        }
        return map;
    }

    // Compress text using mapping table
    static String compressText(String text, String[][] codes) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (String[] pair : codes) {
                if (pair[0].charAt(0) == c) {
                    compressed.append(pair[1]);
                    break;
                }
            }
        }
        return compressed.toString();
    }

    // Decompress text using mapping table
    static String decompressText(String compressed, String[][] codes) {
        StringBuilder decompressed = new StringBuilder();
        int maxCodeLen = 0;
        for (String[] pair : codes) {
            maxCodeLen = Math.max(maxCodeLen, pair[1].length());
        }

        for (int i = 0; i < compressed.length();) {
            boolean matched = false;
            for (String[] pair : codes) {
                String code = pair[1];
                if (i + code.length() <= compressed.length() && compressed.substring(i, i + code.length()).equals(code)) {
                    decompressed.append(pair[0]);
                    i += code.length();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                i++; // safety, should not happen

                    }}
        return decompressed.toString();
    }

    // Display analysis
    static void displayAnalysis(String text, char[] chars, int[] freq, String[][] codes, String compressed, String decompressed) {
        System.out.println("=== Character Frequency Table ===");
        System.out.printf("%-10s %-10s\n", "Char", "Frequency");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%-10s %-10d\n", chars[i], freq[i]);
        }

        System.out.println("\n=== Compression Mapping ===");
        System.out.printf("%-10s %-10s\n", "Char", "Code");
        for (String[] pair : codes) {
            System.out.printf("%-10s %-10s\n", pair[0], pair[1]);
        }

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);

        double origBits = text.length() * 8;
        double compBits = compressed.length() * 4; // assume each digit is 4 bits
        double eff = (1 - (compBits / origBits)) * 100;
        System.out.printf("Compression Efficiency: %.2f%%\n", eff);
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to compress: ");
        String text = sc.nextLine();

        Object[] freqData = countFreq(text);
        char[] chars = (char[]) freqData[0];
        int[] freq = (int[]) freqData[1];

        String[][] codes = makeCodes(chars, freq);
        String compressed = compressText(text, codes);
        String decompressed = decompressText(compressed, codes);

        displayAnalysis(text, chars, freq, codes, compressed, decompressed);

        sc.close();
    }
}
