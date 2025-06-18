import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        System.out.println("Multiples of " + number + " below 100 are:");
        
        for (int i = 100; i >= 1; i--) {
            if (i % number != 0) {
                continue; // Skip numbers that are not multiples
            }
            System.out.println(i);
        }
        
        scanner.close();
    }
}
