import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for a positive number less than 100
        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt(); // Store user input
        
        // Validate input
        if (number <= 0 || number >= 100) {
            System.out.println("Invalid Input. Please enter a positive number less than 100.");
        } else {
            // Loop backwards from 100 to 1
            System.out.println("Multiples of " + number + " below 100 are.....:");
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        }
        
        // Close the scanner 
        sc.close();
    }
}
