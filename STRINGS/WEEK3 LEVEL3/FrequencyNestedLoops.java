import java.util.Scanner;

public class FrequencyNestedLoops {

    // Method to find frequency of characters using nested loops
    public static String[] findFrequencies(String str) {
        char[] chars = str.toCharArray();
        int[] freq = new int[chars.length];

        // Outer loop for each character
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1; // initialize frequency to 1

            if (chars[i] == '0') continue; // already counted, skip

            // Inner loop to check duplicates
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Store results in a 1D String array (char = freq)
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " = " + freq[i];
                index++;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[] frequencies = findFrequencies(input);

        System.out.println("\nCharacter Frequencies:");
        System.out.println("----------------------");
        for (String s : frequencies) {
            System.out.println(s);
        }

        sc.close();
    }
}
