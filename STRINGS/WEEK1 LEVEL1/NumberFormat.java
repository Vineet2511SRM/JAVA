import java.util.Scanner;

public class NumberFormat {

    // just a simple method to generate NumberFormatException
    public static void generateException(String text) {
        int number = Integer.parseInt(text); // this can throw exception if text is not a number
        System.out.println("Converted number: " + number);
    }

    // this method properly handles NumberFormatException
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Oops! Can't convert that text into a number.");
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            // just in case some other runtime exception pops up
            System.out.println("Runtime problem: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter something: ");
        String input = sc.nextLine();

        System.out.println("\nTrying without handling exceptions:");
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Caught an exception in generateException!");
        }

        System.out.println("\nTrying with proper handling:");
        handleException(input);

        sc.close();
    }
}
