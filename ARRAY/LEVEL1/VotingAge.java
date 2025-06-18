import java.util.Scanner;

public class VotingAge {
    public static void main(String[] args) {
        // Create a scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Define an array to store the ages of 10 students
        int[] ages = new int[10];

        // Loop to take input from the user
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = sc.nextInt();
        }

        // Check voting eligibility
        System.out.println("\nVoting Eligibility Results:");
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                System.out.println("Invalid age entered: " + ages[i]);
            } else if (ages[i] >= 18) {
                System.out.println("The student with the age " + ages[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + ages[i] + " cannot vote.");
            }
        }

        // Close the scanner
        sc.close();
    }
}
