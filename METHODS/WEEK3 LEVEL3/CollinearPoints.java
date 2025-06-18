import java.util.Scanner;

public class CollinearPoints {

    // Method 1: Using Slope Method
    public static boolean isCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        return slopeAB == slopeBC;
    }

    // Method 2: Using Area of Triangle Method
    public static boolean isCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for 3 points
        System.out.println("Enter coordinates of Point A (x1 y1):");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Enter coordinates of Point B (x2 y2):");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.println("Enter coordinates of Point C (x3 y3):");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        // Check collinearity using both methods
        boolean bySlope = isCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean byArea = isCollinearByArea(x1, y1, x2, y2, x3, y3);

        // Display results
        System.out.println("\n--- RESULT ---");
        if (bySlope)
            System.out.println("Points are collinear (using slope method)");
        else
            System.out.println("Points are NOT collinear (using slope method)");

        if (byArea)
            System.out.println("Points are collinear (using area method)");
        else
            System.out.println("Points are NOT collinear (using area method)");
    }
}
