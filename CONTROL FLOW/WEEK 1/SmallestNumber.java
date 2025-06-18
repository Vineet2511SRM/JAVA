import java.util.*;

public class SmallestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input for three numbers
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();
        
        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();
        
        // Checking if the first number is the smallest
        if (number1 < number2 && number1 < number3) {
            System.out.println("Is the first number the smallest? Yes");
        } else {
            System.out.println("Is the first number the smallest? No");
        }
        
        sc.close(); 
    }
}
