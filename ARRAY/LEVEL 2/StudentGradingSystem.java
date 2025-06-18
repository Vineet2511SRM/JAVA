import java.util.Scanner;

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Input number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        // b. Arrays to store marks, percentages, grades
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentages = new double[n];
        String[] grades = new String[n];

        // c. Input marks, validate, calculate percentage & grade
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            System.out.print("  Physics: ");
            physics[i] = scanner.nextInt();
            while (physics[i] < 0) {
                System.out.print("  Enter positive marks for Physics: ");
                physics[i] = scanner.nextInt();
            }

            System.out.print("  Chemistry: ");
            chemistry[i] = scanner.nextInt();
            while (chemistry[i] < 0) {
                System.out.print("  Enter positive marks for Chemistry: ");
                chemistry[i] = scanner.nextInt();
            }

            System.out.print("  Maths: ");
            maths[i] = scanner.nextInt();
            while (maths[i] < 0) {
                System.out.print("  Enter positive marks for Maths: ");
                maths[i] = scanner.nextInt();
            }

            int total = physics[i] + chemistry[i] + maths[i];
            percentages[i] = total / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = "A - Level 4 (above agency-normalized standards)";
            } else if (percentages[i] >= 70) {
                grades[i] = "B - Level 3 (at agency-normalized standards)";
            } else if (percentages[i] >= 60) {
                grades[i] = "C - Level 2 (below, but approaching agency-normalized standards)";
            } else if (percentages[i] >= 50) {
                grades[i] = "D - Level 1 (well below agency-normalized standards)";
            } else if (percentages[i] >= 40) {
                grades[i] = "E - Level 1- (too below agency-normalized standards)";
            } else {
                grades[i] = "F - Remedial standards (39% and below)";
            }
        }

        // d. Display the result
        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("  Physics: " + physics[i]);
            System.out.println("  Chemistry: " + chemistry[i]);
            System.out.println("  Maths: " + maths[i]);
            System.out.printf("  Percentage: %.2f%%\n", percentages[i]);
            System.out.println("  Grade: " + grades[i]);
        }

        scanner.close();
    }
}
