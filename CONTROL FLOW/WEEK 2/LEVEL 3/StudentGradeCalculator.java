import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for three subjects
        System.out.print("Enter marks in Physics: ");
        int physics = scanner.nextInt(); 
        
        System.out.print("Enter marks in Chemistry: ");
        int chemistry = scanner.nextInt();
        
        System.out.print("Enter marks in Maths: ");
        int maths = scanner.nextInt();  

        // Calculate average percentage
        double average = (physics + chemistry + maths) / 3.0;
        
        // Determine grade and remarks
        String grade, remarks; 

        if (average >= 80) { 
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Level 2, below, but approaching agency-normalized standards";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        } else if (average >= 40) {
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        // Display the results
        System.out.println("\nAverage Marks: " + average); // Printing average marks
        System.out.println("Grade: " + grade); // Printing grade
        System.out.println("Remarks: " + remarks); // Printing remarks

        scanner.close();
    }
}
