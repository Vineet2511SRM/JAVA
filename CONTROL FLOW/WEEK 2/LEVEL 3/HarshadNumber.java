// Program to check if a number taken from the user is a Harshad Number 
import java.util.Scanner;

public class HarshadNumber {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer input : "); // Taking an integer input from the user
        int number = sc.nextInt();
        
        int sumOfDigits = 0;
        int temp = number;
        
        while (temp != 0) {
            sumOfDigits += temp % 10; 
            temp /= 10;
        }
        
        if (number % sumOfDigits == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }
        
        sc.close();
    }
}
