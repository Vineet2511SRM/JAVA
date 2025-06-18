import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI
    public static double calculateBMI(double weight, double heightCm) {
        double heightMeters = heightCm / 100.0;
        return weight / (heightMeters * heightMeters);
    }

    // Method to get BMI status based on new logic
    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi <= 24.9) return "Normal weight";
        else if (bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] members = new double[10][3];  // [weight, height_cm, BMI]
        String[] status = new String[10];        // BMI status for each member

        System.out.println("=== BMI Calculator for 10 Team Members ===");

        // Take input and calculate BMI for each member
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            members[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            members[i][1] = sc.nextDouble();

            // Calculate BMI
            members[i][2] = calculateBMI(members[i][0], members[i][1]);

            // Determine BMI status
            status[i] = getBMIStatus(members[i][2]);
        }

        // Display results
        System.out.println("\n=== BMI Results ===");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", 
                members[i][0], members[i][1], members[i][2], status[i]);
        }

        sc.close();
    }
}
