import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object

        System.out.print("Enter a year: ");
        int year = sc.nextInt(); // Read user input

        // Using multiple if-else statements
        if (year >= 1582) { // Leap year was introduced in 1582
            if (year % 4 == 0) { // If year is divisible by 4
                if (year % 100 == 0) { // If year is divisible by 100
                    if (year % 400 == 0) { // If year is divisible by 400
                        System.out.println(year + " is a Leap Year."); // Leap year
                    } else {
                        System.out.println(year + " is not a Leap Year."); // Not a leap year
                    }
                } else {
                    System.out.println(year + " is a Leap Year."); // Leap year
                }
            } else {
                System.out.println(year + " is not a Leap Year."); // Not a leap year
            }
        } else {
            System.out.println("Year must be greater than or equal to 1582."); // Leap year was introduced in 1582
        }

        sc.close(); // Close the Scanner
    }
}
