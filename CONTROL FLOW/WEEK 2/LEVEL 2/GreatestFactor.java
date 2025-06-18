import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Start checking from number - 1
        int greatestFactor = 1;
        for (int i = number - 1; i > 0; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }
        
        // Print the greatest factor found
        System.out.println("Greatest factor (excluding itself): " + greatestFactor);
        
        sc.close();
    }
}