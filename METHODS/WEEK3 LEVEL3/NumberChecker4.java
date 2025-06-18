import java.util.Scanner;

public class NumberChecker4 {

    // Check if a number is Prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Check if a number is Neon
    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // Check if a number is Spy Number
    public static boolean isSpy(int number) {
        int sum = 0, product = 1, temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // Check if a number is Automorphic
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        int temp = number;
        while (temp > 0) {
            if (temp % 10 != square % 10) {
                return false;
            }
            temp /= 10;
            square /= 10;
        }
        return true;
    }

    // Check if a number is Buzz Number
    public static boolean isBuzz(int number) {
        return (number % 7 == 0 || number % 10 == 7);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input. Please enter a positive number.");
            return;
        }

        System.out.println("\nChecking properties for number: " + number);
        System.out.println("Is Prime?         " + (isPrime(number) ? "Yes" : "No"));
        System.out.println("Is Neon Number?   " + (isNeon(number) ? "Yes" : "No"));
        System.out.println("Is Spy Number?    " + (isSpy(number) ? "Yes" : "No"));
        System.out.println("Is Automorphic?   " + (isAutomorphic(number) ? "Yes" : "No"));
        System.out.println("Is Buzz Number?   " + (isBuzz(number) ? "Yes" : "No"));

        sc.close();
    }
}
