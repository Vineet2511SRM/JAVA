import java.util.Scanner;

class BMI_2dArray {
    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter number of persons: ");
        int number = obj.nextInt();

        // Create multi-dimensional array: 0 - Height, 1 - Weight, 2 - BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Take input and calculate BMI
        for (int i = 0; i < number; i++) {
            System.out.println("\nDetails for Person " + (i + 1));

            // Height input with validation
            do {
                System.out.print("Enter height in meters: ");
                personData[i][0] = obj.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Please enter a positive value for height.");
                }
            } while (personData[i][0] <= 0);

            // Weight input with validation
            do {
                System.out.print("Enter weight in kilograms: ");
                personData[i][1] = obj.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Please enter a positive value for weight.");
                }
            } while (personData[i][1] <= 0);

            // Calculate BMI and store
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            // Determine status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display BMI Report
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.printf("Height: %.2f m\n", personData[i][0]);
            System.out.printf("Weight: %.2f kg\n", personData[i][1]);
            System.out.printf("BMI: %.2f\n", personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
        }

        obj.close();
    }
}
