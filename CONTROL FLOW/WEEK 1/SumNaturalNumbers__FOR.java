import java.util.Scanner;

public class SumNaturalNumbers__FOR {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        // Taking user input
        System.out.print("Enter a natural number: ");
        int num = obj.nextInt();
        
        // Checking if the input is a natural number
        if (num > 0) {
            // Computing sum using for loop
            int sumForLoop = 0;
            for (int i=1; i<=num; i++) {
                sumForLoop += i;
            }

            // Computing sum using formula
            int sumFormula = num*(num+1)/2;

            // Display results
            System.out.println("Sum using for loop: " + sumForLoop);
            System.out.println("Sum using formula: " + sumFormula);

            // Verifying if both results are the same
            if (sumForLoop == sumFormula) {
                System.out.println("Both computations are correct...");
            } else {
                System.out.println("Mismatch in results....");
            }
        } else {
            System.out.println("Please enter a valid natural number (n > 0).");
        }

        obj.close();
    }
}
