import java.util.Scanner;

public class StudentVoteChecker {

    // Method to check if a student is eligible to vote
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            // Invalid age
            return false;
        } else if (age >= 18) {
            // Eligible to vote
            return true;
        } else {
            // Not eligible to vote
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] studentAges = new int[10];

        System.out.println("=== Voter Eligibility Checker for 10 Students ===");

        // Loop to take input and check eligibility
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            studentAges[i] = sc.nextInt();

            boolean canVote = canStudentVote(studentAges[i]);

            if (studentAges[i] < 0) {
                System.out.println("Invalid age! Age cannot be negative.");
            } else if (canVote) {
                System.out.println("Student " + (i + 1) + " is eligible to vote.");
            } else {
                System.out.println("Student " + (i + 1) + " is not eligible to vote.");
            }

            System.out.println(); // Just for spacing
        }

        System.out.println("=== Check Completed ===");
        sc.close();
    }
}
// This program checks if students are eligible to vote based on their age.