import java.util.Scanner;

public class IllegalArgument {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = obj.nextLine();

        // First calling method that generates exception
        System.out.println("\nCalling method without exception handling:");
        generateException(input);

        // Then calling method that handles exception
        System.out.println("\nCalling method with exception handling:");
        handleException(input);

        obj.close();
    }

    // Method to generate exception without handling
    public static void generateException(String str) {
        // Trying to get substring with invalid indices
        String result = str.substring(5, 2);
        System.out.println(result);
    }

    // Method to handle the exception
    public static void handleException(String str) {
        try {
            String result = str.substring(5, 2);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
}