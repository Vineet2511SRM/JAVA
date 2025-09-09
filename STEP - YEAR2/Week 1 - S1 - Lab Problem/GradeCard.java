
import java.util.Scanner;

public class GradeCard {

    // a. Method to take input scores for 3 subjects for n students
    public static int[][] inputScores(int n) {
        Scanner sc = new Scanner(System.in);
        int[][] scores = new int[n][3]; // 3 subjects: Physics, Chemistry, Maths

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            System.out.print("Physics: ");
            scores[i][0] = sc.nextInt();
            System.out.print("Chemistry: ");
            scores[i][1] = sc.nextInt();
            System.out.print("Maths: ");
            scores[i][2] = sc.nextInt();
        }
        return scores;
    }

    // b. Method to calculate total, average, and percentage
    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        int n = scores.length;
        double[][] result = new double[n][3]; // total, average, percentage

        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = (double) total / 3;
            double percentage = ((double) total / 300) * 100;

            // Round to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    // c. Method to calculate grade based on percentage
    public static String[] calculateGrade(double[][] totalsAvgPerc) {
        int n = totalsAvgPerc.length;
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            double percent = totalsAvgPerc[i][2];
            if (percent >= 80) {
                grades[i] = "A"; 
            }else if (percent >= 70) {
                grades[i] = "B"; 
            }else if (percent >= 60) {
                grades[i] = "C"; 
            }else if (percent >= 50) {
                grades[i] = "D"; 
            }else if (percent >= 40) {
                grades[i] = "E"; 
            }else {
                grades[i] = "R";
            }
        }
        return grades;
    }

    // d. Method to display scorecard
    public static void displayScorecard(int[][] scores, double[][] totalsAvgPerc, String[] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-10.2f %-10s%n",
                    (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    totalsAvgPerc[i][0],
                    totalsAvgPerc[i][1],
                    totalsAvgPerc[i][2],
                    grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Step a: Input scores
        int[][] scores = inputScores(n);

        // Step b: Calculate total, average, percentage
        double[][] totalsAvgPerc = calculateTotalAveragePercentage(scores);

        // Step c: Calculate grade
        String[] grades = calculateGrade(totalsAvgPerc);

        // Step d: Display scorecard
        displayScorecard(scores, totalsAvgPerc, grades);
    }
}
