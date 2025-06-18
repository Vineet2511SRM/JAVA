import java.util.Scanner;

public class LeapYear {

    // Method to check if a year is a leap year
    public static int leap(int y) {
        if (y >= 1582) {
            if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
                return 1; // Leap year
            } else {
                return 0; // Not a leap year
            }
        } else {
            return -1; // Year is before the Gregorian calendar
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        // Check if the input is a valid year
        if (year < 0) {
            System.out.println("Invalid input! Please enter a positive year.");
            return;
        }

        int result = leap(year);

        // Show the result
        if (result == 1) {
            System.out.println(year + " is a leap year.");
        } else if (result == 0) {
            System.out.println(year + " is not a leap year.");
        } else {
            System.out.println("Leap year calculation is valid only from 1582 onwards (Gregorian calendar).");
        }

        sc.close();
    }
}
