import java.util.Scanner;

public class ArraysOutOfBound {

    // method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        System.out.println("\nTrying to access index beyond array size...");
        // deliberately accessing a wrong index
        System.out.println("Name at invalid index: " + names[names.length]);
    }

    // method to handle ArrayIndexOutOfBoundsException properly
    public static void handleException(String[] names) {
        try {
            System.out.println("\nTrying to access invalid index safely...");
            System.out.println("Name at invalid index: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops! You tried to access an index that doesn't exist.");
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            // just in case kuch aur random problem ho
            System.out.println("Some runtime issue: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking size from user
        System.out.print("How many names you want to store? ");
        int size = sc.nextInt();
        sc.nextLine(); // consume leftover new line

        String[] names = new String[size];

        // input names
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        // first calling the method that will crash
        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Caught an exception while generating error!");
        }

        // now calling the method that handles the exception
        handleException(names);

        sc.close();
    }
}
