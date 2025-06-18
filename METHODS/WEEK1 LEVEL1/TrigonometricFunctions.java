import java.util.Scanner;

public class TrigonometricFunctions {

    // Method to calculate sine, cosine, and tangent
    public double[] calculateTrigonometricFunctions(double angle) {
        // Convert angle from degrees to radians
        double radians = Math.toRadians(angle);

        // Calculate sine, cosine, and tangent
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Input from user
        System.out.print("Enter the angle in degrees: ");
        double angle = obj.nextDouble();

        // Create an object of TrigonometricFunctions
        TrigonometricFunctions calculator = new TrigonometricFunctions();

        // Call the method to calculate trigonometric functions
        double[] result = calculator.calculateTrigonometricFunctions(angle);

        // Display the results
        System.out.println("Sine of " + angle + "°: " + result[0]);
        System.out.println("Cosine of " + angle + "°: " + result[1]);
        System.out.println("Tangent of " + angle + "°: " + result[2]);

        obj.close();
    }
}
