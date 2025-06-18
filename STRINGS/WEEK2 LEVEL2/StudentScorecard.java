import java.util.Random;

public class StudentScorecard {

    // a. Generate random 2-digit marks for PCM
    public static int[][] generateMarks(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3]; // PCM

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(41) + 60; // random 60 to 100
            }
        }

        return scores;
    }

    // b. Calculate total, average, and percentage
    public static double[][] calculateStats(int[][] scores) {
        int students = scores.length;
        double[][] result = new double[students][3]; // total, average, percentage

        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;       // 2-digit avg
            result[i][2] = Math.round(percent * 100.0) / 100.0;   // 2-digit %
        }

        return result;
    }

    // c. Assign grade based on percentage
    public static String[] assignGrades(double[][] stats) {
        String[] grades = new String[stats.length];

        for (int i = 0; i < stats.length; i++) {
            double percent = stats[i][2];

            if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 50) grades[i] = "D";
            else if (percent >= 40) grades[i] = "E";
            else grades[i] = "R";
        }

        return grades;
    }

    // d. Display scorecard in tabular format
    public static void displayScorecard(int[][] marks, double[][] stats, String[] grades) {
        System.out.println("Student | Physics | Chemistry | Maths | Total | Average | %   | Grade");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.printf("  %2d    |   %3d   |    %3d    |  %3d  |  %3.0f  |  %6.2f | %5.2f |  %s\n",
                    i + 1,
                    marks[i][0], marks[i][1], marks[i][2],
                    stats[i][0], stats[i][1], stats[i][2],
                    grades[i]);
        }
    }

    // Main function
    public static void main(String[] args) {
        int numStudents = 10;

        int[][] marks = generateMarks(numStudents);
        double[][] stats = calculateStats(marks);
        String[] grades = assignGrades(stats);

        displayScorecard(marks, stats, grades);
    }
}
