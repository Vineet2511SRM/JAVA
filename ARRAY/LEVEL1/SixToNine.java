// Java program to find multiplication table of a number entered by user from 6 to 9 using arrays

import java.util.Scanner;
public class SixToNine {

    public static void main(String[] args) {
        
        Scanner p = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = p.nextInt();

        int[] multiplicationResult = new int[4];

        for (int i = 0; i < 4; i++) {
            multiplicationResult[i] = number * (i + 6);
        }

        System.out.println("Multiplication table of " + number + " from 6 to 9:");

        for (int i = 0; i < 4; i++) {
            System.out.println(number + " x " + (i + 6) + " = " + multiplicationResult[i]);
        }

        p.close();

    }
}