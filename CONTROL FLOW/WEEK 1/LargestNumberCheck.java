import java.util.Scanner;

public class LargestNumberCheck {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter first number: ");
        int number1 = obj.nextInt();
        System.out.print("Enter second number: ");
        int number2 = obj.nextInt();
        System.out.print("Enter third number: ");
        int number3 = obj.nextInt();
        
        // Computing the largest number
        System.out.println("Is the first number the largest? " + (number1 > number2 && number1 > number3));
        System.out.println("Is the second number the largest? " + (number2 > number1 && number2 > number3));
        System.out.println("Is the third number the largest? " + (number3 > number1 && number3 > number2));
        
        obj.close();
    }
}