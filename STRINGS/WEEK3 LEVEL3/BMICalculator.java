import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and return status based on BMI range
    public static String calculateStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 40)
            return "Overweight";
        else
            return "Obese";
    }

    // Method to compute BMI and status
    public static String[][] computeBMI(double[][] data) {
        String[][] result = new String[10][4]; // [height, weight, BMI, status]

        for (int i = 0; i < 10; i++) {
            double heightInMeters = data[i][1] / 100.0; // cm to meters
            double weight = data[i][0];
            double bmi = weight / (heightInMeters * heightInMeters);
            String status = calculateStatus(bmi);

            // Fill result array
            result[i][0] = String.format("%.1f", data[i][1]); // height
            result[i][1] = String.format("%.1f", weight);      // weight
            result[i][2] = String.format("%.2f", bmi);         // BMI
            result[i][3] = status;                             // Status
        }
        return result;
    }

    // Method to display the results in tabular format
    public static void displayTable(String[][] result) {
        System.out.println("\nPerson\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + "\t" + result[i][0] + "\t\t" +
                               result[i][1] + "\t\t" +
                               result[i][2] + "\t" + result[i][3]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2]; // [weight, height]

        System.out.println("Enter weight (kg) and height (cm) for 10 people:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " - Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        // Compute BMI & status
        String[][] result = computeBMI(data);

        // Display table
        displayTable(result);

        sc.close();
    }
}
