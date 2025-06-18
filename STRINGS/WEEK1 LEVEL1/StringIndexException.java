// Java program to demonstrate StringIndexOutOfBoundsException and handle it using try-catch block

import java.util.Scanner;
public class StringIndexException{
    // Method to generate exception by accessing index using charAt() beyond string length
    public static void generateException(String str, int index) {
        // This will cause StringIndexOutOfBoundsException when index is out of bounds
        System.out.println("Character at index " + index + ": " + str.charAt(index)); // This will throw StringIndexOutOfBoundsException
    }

    // Method to handle the StringIndexOutOfBoundsException
    public static void handleException(String str, int index) {
        try {
            // Trying to access charAt() on an invalid index
            System.out.println("Character at index " + index + ": " + str.charAt(index)); // This will throw StringIndexOutOfBoundsException
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught a StringIndexOutOfBoundsException!");
            System.out.println("Exception Message: " + e.getMessage()); // prints exception message
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        // Prompt the user to enter a string
        System.out.println("Enter a string: ");
        String str = obj.nextLine();

        // First, call the method to generate the exception (will cause the program to crash if not handled)
        try {
            generateException(str, 20); // Calling this will cause StringIndexOutOfBoundsException
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception in generateException method: " + e.getMessage());
        }

        // Now refactor the code to call the method to handle the RuntimeException
        System.out.println("\nHandling Exception with try-catch block:\n");
        handleException(str, 20); // Calling this will handle the StringIndexOutOfBoundsException gracefully
    }
     
}

