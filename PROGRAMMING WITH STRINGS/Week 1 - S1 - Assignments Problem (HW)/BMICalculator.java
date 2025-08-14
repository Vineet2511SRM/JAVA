import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and status...
    public static String[] calculateBMIStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // convert cm to meters
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.format("%.2f", bmi), status};
    }

    // Method to process all members and store results
    public static String[][] processTeam(double[][] data) {
        String[][] result = new String[data.length][4]; // height, weight, BMI, status
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            String[] bmiStatus = calculateBMIStatus(weight, height);

            result[i][0] = String.format("%.1f", height); // height
            result[i][1] = String.format("%.1f", weight); // weight
            result[i][2] = bmiStatus[0];                  // BMI
            result[i][3] = bmiStatus[1];                  // Status
        }
        return result;
    }

    // Method to display results in table format
    public static void displayResults(String[][] table) {
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------");
        for (String[] row : table) {
            System.out.printf("%-10s %-10s %-10s %-15s%n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] members = new double[10][2]; // [weight, height]

        // Taking user inputs
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for member " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            members[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            members[i][1] = sc.nextDouble();
        }

        // Process and display
        String[][] results = processTeam(members);
        displayResults(results);
        sc.close();
    }
}
