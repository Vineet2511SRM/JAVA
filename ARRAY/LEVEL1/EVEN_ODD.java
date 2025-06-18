import java.util.Scanner;

public class EVEN_ODD{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter a natural number: ");
        int number = obj.nextInt();
        
        // Check if input is a natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number greater than 0.");
            obj.close();
            return; // Exit program with an error
        }
        
        // Declare arrays for odd and even numbers
        int[] evenArray = new int[number / 2 + 1];
        int[] oddArray = new int[number / 2 + 1];
        int evenIndex = 0, oddIndex = 0;
        
        // Iterate through numbers from 1 to 'number'
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenArray[evenIndex++] = i; // Store even numbers
            } else {
                oddArray[oddIndex++] = i;  // Store odd numbers
            }
        }
        
        // Print odd numbers
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddArray[i] + " ");
        }
        System.out.println();
        
        // Print even numbers
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenArray[i] + " ");
        }
        System.out.println();
        
        obj.close();
    }
}