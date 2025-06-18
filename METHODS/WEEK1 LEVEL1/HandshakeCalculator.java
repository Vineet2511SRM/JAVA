import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate the number of handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Calculating the handshakes
        int totalHandshakes = calculateHandshakes(numberOfStudents);

        // Displaying the result
        System.out.println("Maximum number of handshakes possible: " + totalHandshakes);

        sc.close();
    }
}
