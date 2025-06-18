import java.util.Random;
import java.util.Scanner;

public class VotingEligibility {

    // Public static method to generate random 2-digit ages
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10; // Ages from 10 to 99
        }

        return ages;
    }

    // Public static method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);

            if (age < 0) {
                result[i][1] = "false";
            } else if (age >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    // Public static method to display 2D array in tabular format
    public static void displayTable(String[][] data) {
        System.out.println("\nStudent | Age | Can Vote");
        System.out.println("-----------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("   %2d    | %2s  |   %s\n", i + 1, data[i][0], data[i][1]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = generateAges(n);
        String[][] votingInfo = checkVotingEligibility(ages);
        displayTable(votingInfo);
    }
}
