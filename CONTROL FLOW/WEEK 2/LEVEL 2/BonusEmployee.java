// this program calculates the bonus of an employee based on the years of service

import java.util.Scanner;

public class BonusEmployee {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        // Declare variables to store salary and years of service
        double salary;
        int yearsOfService;
        
        // Prompt user to enter salary
        System.out.print("Enter salary of the employee: ");
        salary = sc.nextDouble(); // Store user input
        
        // Prompt user to enter years of service
        System.out.print("Enter the years of service of the employee: ");
        yearsOfService = sc.nextInt(); // Store user input
        
        // Check if the employee has more than 5 years of service
        if (yearsOfService > 5) {
            // Calculate bonus (5% of salary)
            double bonus = salary * 0.05;
            // Display the bonus amount
            System.out.println("Bonus amount of the employee is: " + bonus);
        } else {
            // Display message if the employee is not eligible for bonus
            System.out.println("No bonus applicable as years of service is 5 or less.");
        }
        
        // Close the scanner 
        sc.close();
    }
}
