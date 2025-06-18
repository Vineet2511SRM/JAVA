import java.util.Scanner;

class BMI {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter number of persons: ");
        int n = obj.nextInt();

        // Declare arrays
        double[] height = new double[n]; // in meters
        double[] weight = new double[n]; // in kg
        double[] bmi = new double[n];
        String[] status = new String[n];

        // Take height and weight input for each person
        for (int i = 0; i < n; i++) {
            System.out.println("\nDetails for Person " + (i + 1));
            System.out.print("Enter height in meters: ");
            height[i] = obj.nextDouble();

            System.out.print("Enter weight in kilograms: ");
            weight[i] = obj.nextDouble();

            // Calculate BMI
            bmi[i] = weight[i] / (height[i] * height[i]);

            // Determine status based on BMI
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display the BMI report
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.printf("Height: %.2f m\n", height[i]);
            System.out.printf("Weight: %.2f kg\n", weight[i]);
            System.out.printf("BMI: %.2f\n", bmi[i]);
            System.out.println("Status: " + status[i]);
        }

        obj.close();
    }
}
