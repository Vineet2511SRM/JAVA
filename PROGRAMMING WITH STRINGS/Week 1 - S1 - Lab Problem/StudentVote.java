import java.util.Scanner;

public class StudentVote {

    // a. Method to take user input for n students (no negative ages allowed)
    public static int[] inputAges(int n) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            int age;
            do {
                System.out.print("Enter age of student " + (i + 1) + ": ");
                age = sc.nextInt();
                if (age < 0) {
                    System.out.println("Invalid age! Age cannot be negative. Please enter again.");
                }
            } while (age < 0);
            ages[i] = age;
        }

        return ages;
    }

    // b. Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18) {
                result[i][1] = "true"; // Can vote
            } else {
                result[i][1] = "false"; // Cannot vote
            }
        }

        return result;
    }

    // c. Method to display a 2D array in tabular format
    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-10s%n", "Age", "Can Vote");
        System.out.println("--------------------");

        for (String[] row : data) {
            System.out.printf("%-10s %-10s%n", row[0], row[1]);
        }
    }

    // d. Main method
    public static void main(String[] args) {
        int numStudents = 10;

        // Step 1: Take user input for ages
        int[] studentAges = inputAges(numStudents);

        // Step 2: Check voting eligibility
        String[][] votingStatus = checkVotingEligibility(studentAges);

        // Step 3: Display results
        displayTable(votingStatus);
    }
}
