import java.util.Scanner;

public class CharFrequency {

    // Method to find the frequency of characters using charAt()
    public static String[][] getCharFrequencies(String str) {
        int[] freq = new int[256]; // ASCII size

        // First loop: Count frequency of each character
        for (int i = 0; ; i++) {
            try {
                char ch = str.charAt(i);
                freq[(int) ch]++;
            } catch (Exception e) {
                break; // Reached end of string
            }
        }

        // Now create a 2D array to store characters and their frequencies
        String[][] result = new String[256][2];
        int count = 0;

        // Loop again through the string to store only unique characters and their frequency
        for (int i = 0; ; i++) {
            try {
                char ch = str.charAt(i);
                if (freq[(int) ch] > 0) {
                    result[count][0] = Character.toString(ch); // character
                    result[count][1] = Integer.toString(freq[(int) ch]); // frequency
                    freq[(int) ch] = 0; // to avoid duplicates in result
                    count++;
                }
            } catch (Exception e) {
                break;
            }
        }

        // Final trimmed array
        String[][] finalResult = new String[count][2];
        for (int i = 0; i < count; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }

        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] frequencies = getCharFrequencies(input);

        System.out.println("\nCharacter\tFrequency");
        System.out.println("-------------------------");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println("   " + frequencies[i][0] + "\t\t    " + frequencies[i][1]);
        }

        sc.close();
    }
}
