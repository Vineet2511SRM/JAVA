// This program generates a FizzBuzz sequence based on user input

import java.util.*;

public class FizzBuzz {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); // create a scanner object

        System.out.print("Enter a number: ");
        int num = sc.nextInt(); // get the number from the user

        if (num > 0) {
            int i = 0;
            while (i <= num) {
                if (i % 3 == 0 && i % 5 == 0)
                    System.out.println("FizzBuzz"); // if the number is divisible by both 3 and 5
                else if (i % 3 == 0)
                    System.out.println("Fizz"); // if the number is divisible by 3
                else if (i % 5 == 0)
                    System.out.println("Buzz"); // if the number is divisible by 5
                else
                    System.out.println(i);
                i++;
            }
        } else {
            System.out.println("Please enter a natural number"); 
        }
        
        sc.close(); // close the scanner
    }
}
