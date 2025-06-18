import java.util.*;

public class Factorial_For {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = obj.nextInt();
        
        if (number < 0) {
            System.out.println("Error: Please enter a positive integer.");  // Checking whether the number is positive or not.....
        } else {
            int fact = 1;
	    //computation of fact using for loop
            for (int i = 1; i <= number; i++) {
                fact*= i;                   
            }
            System.out.println("Factorial of " + number + " is: " + fact);
        }
        
        obj.close();
    }
}
