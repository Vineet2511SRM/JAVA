// Using single if statement with logical operators

import java.util.*;

public class LeapYear_Logical { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object

        System.out.print("Enter a year: ");
        int year = sc.nextInt(); // Read user input

        // Using single if statement with logical operators
        if (year >= 1582 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            System.out.println(year + " is a Leap Year."); // Leap year
        } else {
            System.out.println(year + " is not a Leap Year."); // Not a leap year
        }

        sc.close(); // Close the Scanner
    }
}
