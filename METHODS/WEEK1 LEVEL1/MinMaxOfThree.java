import java.util.Scanner;

public class MinMaxOfThree {

    // Method to find smallest and largest
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = number1;
        int largest = number1;

        if (number2 < smallest) smallest = number2;
        if (number3 < smallest) smallest = number3;

        if (number2 > largest) largest = number2;
        if (number3 > largest) largest = number3;

        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Taking input
        System.out.print("Enter first number: ");
        int num1 = obj.nextInt();

        System.out.print("Enter second number: ");
        int num2 = obj.nextInt();

        System.out.print("Enter third number: ");
        int num3 = obj.nextInt();

        // Calling the method
        int[] result = findSmallestAndLargest(num1, num2, num3);

        // Displaying result
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);

        obj.close();
    }
}
