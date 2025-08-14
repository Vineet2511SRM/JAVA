import java.util.Scanner;

public class StringLength {

    public static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } 
        catch (IndexOutOfBoundsException e) {
            // Handles exception
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String str = sc.next();

            int lengthUsingMethod = findLength(str);
            int lengthUsingBuiltIn = str.length();

            System.out.println("Length found using custom method: " + lengthUsingMethod);
            System.out.println("Length found using built-in length(): " + lengthUsingBuiltIn);
        }
    }
}
