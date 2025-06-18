import java.util.Scanner;

public class SpringSeason {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Scanner class to take input from user

        System.out.println("Enter the month: ");

        int month = sc.nextInt(); // Taking month as input

        System.out.println("Enter the day: ");

        int day = sc.nextInt(); // Taking day as input

        if ((month == 3 && day >= 20) || (month == 4 || month == 5) || (month == 6 && day <= 20)) { // Checking if the month and day lies between the Spring Season
            System.out.println("Its a Spring Season");
        } 

	else {
            System.out.println("Not a Spring Season");
        }
    }
}