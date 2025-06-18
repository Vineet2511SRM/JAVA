// Java program to check if a number is an Armstrong number or not
import java.util.*;
public class ArmstrongNumber {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int sum = 0;

        int originalNumber = number;

        while (number != 0) {
            int remainder = number % 10;
            sum += Math.pow(remainder, 3);
            number /= 10;
        }

        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
        
        sc.close();
    }
}