import java.util.Scanner;

public class Height_Players {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        double[] heights = new double[11]; // Array to store heights of 11 players
        double sum = 0.0; // Variable to store the total sum of heights

        // Taking input for the heights of 11 players
        System.out.println("Enter the heights (in cm) of 11 football players:");
        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i]; // Adding each height to the sum
        }

        // Calculating the mean height
        double meanHeight = sum / 11.0;

        // Displaying the mean height
        System.out.println("\nThe mean height of the football team is: " + meanHeight + " cm");

        scanner.close(); // Closing the scanner to prevent resource leaks
    }
}
