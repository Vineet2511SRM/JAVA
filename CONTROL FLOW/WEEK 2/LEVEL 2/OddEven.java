//  print odd and even numbers between 1 to the number entered by the user.


import java.util.*;

public class OddEven {
    public static void main(String[] args) {
        
        Scanner obj = new Scanner(System.in);
        
        System.out.println("Please enter a number: ");
        int num = obj.nextInt(); // get the number from the user

        if (num <=0) { // Checking if the number is natural or not
            System.out.println("Please enter a natural number"); 
            return;
        }
        
        for (int i = 1; i <= num; i++) { // loop through the numbers from 1 to the number entered by the user
            if (i % 2 == 0) { // if the number is even
                System.out.println(i + " is an even number"); // print this
            } else { // if the number is odd
                System.out.println(i + " is an odd number"); // print this
            }
        }
    }
}