import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    // Generate random marks for Physics, Chemistry, and Maths
    public static int[][] generateMarks(int n) {
        Random rand = new Random();
        int[][] marks = new int[n][3];

        for (int i = 0; i < n; i++) {
            marks[i][0] = rand.nextInt(100); // Physics
            marks[i][1] = rand.nextInt(100); // Chemistry
            marks[i][2] = rand.nextInt(100); // Maths
        }

        return marks;
    }

    // Calculate total, average, and percentage
    public static double[][] calculateStats(int[][] marks) {
        int n = marks.length;
        double[][] stats = new double[n][3]; // [][0]=Total, [][1]=Average, [][2]=Percentage

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Rounding to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            stats[i][0] = total;
            stats[i][1] = average;
            stats[i][2] = percentage;
        }

        return stats;
    }

    // Display in tabular format
    public static void displayScorecard(int[][] marks, double[][] stats) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.println((i + 1) + "\t" +
                marks[i][0] + "\t" +
                marks[i][1] + "\t\t" +
                marks[i][2] + "\t" +
                (int) stats[i][0] + "\t" +
                stats[i][1] + "\t" +
                stats[i][2] + "%");
        }

        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = generateMarks(n);
        double[][] stats = calculateStats(marks);
        displayScorecard(marks, stats);
    }
}
