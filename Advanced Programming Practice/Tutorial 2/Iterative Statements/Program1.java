// Calculate and print the factorial of a non negative integer using a for loop
import java.util.Scanner;
public class Program1 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a non negative integer.");
        int num = obj.nextInt();

        if(num < 0){
            System.out.println("Error! Please enter a non negative integer.");
        }

        else {
            int fact = 1;
            for(int i = 1; i <= num; i++) {
                fact *= i;
            }
            System.out.println("The factorial of " + num + " is: " + fact);
        }
    }
}