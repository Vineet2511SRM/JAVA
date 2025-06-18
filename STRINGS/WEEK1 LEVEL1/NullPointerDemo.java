public class NullPointerDemo {

    // Method to generate the NullPointerException
    public static void generateException() {
        String text = null; // text is initialized to null
        // This will cause a NullPointerException when we try to access the length of null
        System.out.println(text.length()); // This will throw NullPointerException
    }

    // Method to handle the NullPointerException
    public static void handleException() {
        String text = null; // text is initialized to null
        try {
            // Trying to access length() on a null object
            System.out.println(text.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException!");
            System.out.println("Exception Message: " + e.getMessage()); // prints exception message
        }
    }

    public static void main(String[] args) {
        // First, call the method to generate the exception (will cause the program to crash if not handled)
        try {
            generateException(); // Calling this will cause a NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Exception in generateException method: " + e.getMessage());
        }

        // Now refactor the code to call the method to handle the RuntimeException
        System.out.println("\nHandling Exception with try-catch block:\n");
        handleException(); // Calling this will handle the NullPointerException gracefully
    }
}
