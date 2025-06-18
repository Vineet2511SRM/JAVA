import java.util.Scanner;
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number.");
        int n = sc.nextInt();

        // Checking if n is a natural number
        if (n <= 0) {
            System.out.println("Please enter a natural number.");
            return;
        }

        // Calculating the sum of the first n natural numbers
        int sum = (n * (n + 1)) / 2;

        if(n>0){
            System.out.println("The sum of " + n + " natural numbers is " + sum);
        }

        else {
            System.out.println("The number " + n + " is not a natural number.");
        }

        sc.close();
        
    }
}

