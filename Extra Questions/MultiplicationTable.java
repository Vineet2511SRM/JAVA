import java.util.*;

public class MultiplicationTable {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner obj = new Scanner(System.in);
        
        // Prompt user for a number
        System.out.print("Enter a number: ");
        int number = obj.nextInt(); // Store user input
        
        // Loop to generate multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        
        // Close the scanner to prevent resource leaks
        obj.close();
    }
}
