import java.util.Scanner;

public class FrequencyWithUniqueCharacters {

    // Method to find string length using charAt()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // End of string
        }
        return count;
    }

    // Method to find unique characters using charAt() and nested loops
    public static char[] getUniqueCharacters(String str) {
        int len = getLength(str);
        char[] temp = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;

            // Check if this character has appeared before
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            // If unique, add to temp array
            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Copy only unique characters to final array
        char[] unique = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    // Method to find frequencies using ASCII index and unique characters
    public static String[][] getFrequencies(String str) {
        int[] freq = new int[256];

        // Count frequency of each character
        for (int i = 0; ; i++) {
            try {
                char ch = str.charAt(i);
                freq[(int) ch]++;
            } catch (Exception e) {
                break;
            }
        }

        // Get unique characters
        char[] uniqueChars = getUniqueCharacters(str);

        // Create 2D array to store character and frequency
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = Character.toString(uniqueChars[i]);
            result[i][1] = Integer.toString(freq[(int) uniqueChars[i]]);
        }

        return result;
    }

    // Main Function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] output = getFrequencies(input);

        System.out.println("\nCharacter\tFrequency");
        System.out.println("-------------------------");
        for (int i = 0; i < output.length; i++) {
            System.out.println("   " + output[i][0] + "\t\t    " + output[i][1]);
        }

        sc.close();
    }
}
