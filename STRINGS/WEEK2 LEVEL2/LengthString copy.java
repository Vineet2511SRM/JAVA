// java program to find the length of a string without using length() method
import java.util.Scanner;

public class LengthString{
    public static int Length(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // Accessing each character in the string
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) { // Exception when index is out of bounds
            return count;
        }
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String input = sc.nextLine();
    
    System.out.println("Length without using length(): " + Length(input));
    System.out.println("Length using length(): " + input.length());
    
    sc.close();
}
}