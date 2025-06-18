import java.util.Scanner;

public class DistanceAndLineEquation {

    // Method to calculate Euclidean Distance
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance;
    }

    // Method to calculate slope (m) and y-intercept (b) of line
    public static double[] getLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];  // result[0] = slope (m), result[1] = y-intercept (b)
        
        if (x2 == x1) {
            // Vertical line, slope is infinite
            throw new IllegalArgumentException("Slope is undefined for vertical lines (x1 = x2).");
        }

        double m = (y2 - y1) / (x2 - x1); // Slope
        double b = y1 - m * x1;          // y-intercept

        result[0] = m;
        result[1] = b;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input coordinates
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Calculate and display Euclidean distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("\nEuclidean Distance between points: %.2f\n", distance);

        try {
            // Calculate and display line equation
            double[] equation = getLineEquation(x1, y1, x2, y2);
            System.out.printf("Equation of the line: y = %.2fx + %.2f\n", equation[0], equation[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}
