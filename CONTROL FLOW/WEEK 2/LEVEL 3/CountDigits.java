// Java program to count the number of digits in an integer

import java.util.*;

public class CountDigits {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: "); // Prompt the user to enter a number
        int number = sc.nextInt();

        int count = 0; // Initialize count to 0

        while (number != 0) { // Loop until number is not equal to 0
            number /= 10;
            count++;    // Increment count by 1
        }

        System.out.println("Number of digits: " + count); // Print the number of digits
        
        sc.close();
    }
}

