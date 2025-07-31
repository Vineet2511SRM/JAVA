
import java.util.Scanner;

// Print all odd numbers from 1 to a given number using for loop
public class Program2 {
    public static void main(String[] args) {

        Scanner ob = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = ob.nextInt();

        System.out.println("Printing all odd numbers from 1 to " + num + ":");
        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) { // Checking if the number is odd
                System.out.print(i + " ");
            }
        }
    }
}