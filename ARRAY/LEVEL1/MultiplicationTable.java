import java.util.Scanner;

// Program to print multiplication table of a number using arrays
public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] table = new int[10];

        for (int i = 0; i < 10; i++) {
            table[i] = number * (i + 1);
        }

        System.out.println("Multiplication table of " + number + ":");
        for (int i = 0; i < 10; i++) {
            System.out.println(number + " x " + (i + 1) + " = " + table[i]);
        }

        sc.close();
    }
}