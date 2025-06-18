import java.util.Scanner;

public class AtheleteRound {

    // Method to calculate the number of rounds user needs to run to complete 5km run
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distanceToRun = 5000; // 5km in meters
        double rounds = distanceToRun / perimeter;
        return rounds;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = sc.nextDouble();
        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = sc.nextDouble();
        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = sc.nextDouble();

        // Calculating the number of rounds
        double totalRounds = calculateRounds(side1, side2, side3);

        // Displaying the result
        System.out.println("Number of rounds to complete 5km run: " + totalRounds);

        sc.close();
    }
}