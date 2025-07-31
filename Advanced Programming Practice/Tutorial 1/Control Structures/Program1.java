// a program that asks the user to enter a number. Use an if statement with else if to check the number sign

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int number = sc.nextInt();

        // Check the number's sign
        if (number > 0) {
            System.out.println("The number is positive.");
        }
        else if (number < 0) {
            System.out.println("The number is negative.");
        } 
        else {
            System.out.println("The number is zero.");
        }
        
        sc.close();
    }
}
