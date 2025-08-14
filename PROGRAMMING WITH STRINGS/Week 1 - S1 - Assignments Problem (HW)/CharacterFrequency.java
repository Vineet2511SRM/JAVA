import java.util.Scanner;

public class CharacterFrequency {

    public static int[][] findCharFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        int[][] charFreqArr = new int[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            charFreqArr[i][0] = text.charAt(i);
            charFreqArr[i][1] = freq[text.charAt(i)];
        }
        return charFreqArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int[][] result = findCharFrequency(input);
        boolean[] printed = new boolean[256]; // to track printed characters

        System.out.println("Character Frequencies:");
        for (int i = 0; i < result.length; i++) {
            if (!printed[result[i][0]]) { // if not printed before
                System.out.println("'" + (char) result[i][0] + "' : " + result[i][1]);
                printed[result[i][0]] = true; // mark as printed
            }
        }
    }
}