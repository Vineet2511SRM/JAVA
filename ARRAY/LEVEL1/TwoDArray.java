// Working with Multi-Dimensional Arrays

import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter rows for the matrix : ");
        int rows = obj.nextInt();
        System.out.println("Enter columns for the matrix : ");
        int columns = obj.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println("Enter elements for the matrix : ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = obj.nextInt();
            }
        }
        int [] array = new int[rows*columns];

        int index = 0;
        // Copy elements from 2D matrix to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index++] = matrix[i][j];
            }
        }

        // Display the 1D array
        System.out.println("Elements of the 1D array are : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        obj.close();

    }
}