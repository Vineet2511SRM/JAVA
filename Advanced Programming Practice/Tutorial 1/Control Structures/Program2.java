// Program to check if a given year is a leap year 

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Step 1: Ask the user to enter a year
        System.out.print("Enter a year: ");
        int year = obj.nextInt();

        // Check divisibility by 4 
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " is a leap year.");
        } else if (year % 100 == 0) {
            // Check divisibility by 400
            if (year % 400 == 0) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is NOT a leap year.");
            }
        } 
        else {
            System.out.println(year + " is NOT a leap year.");
        }

        obj.close();
    }
}
