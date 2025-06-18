import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    // Generate random matrix
    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // 0-9
        return matrix;
    }

    // Add two matrices
    public static int[][] addMatrix(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    // Subtract two matrices
    public static int[][] subtractMatrix(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    // Multiply two matrices
    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int rows = a.length, cols = b[0].length, common = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < common; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    // Transpose of a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                transposed[i][j] = matrix[j][i];
        return transposed;
    }

    // Determinant of 2x2
    public static int determinant2x2(int[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    // Determinant of 3x3
    public static int determinant3x3(int[][] m) {
        int a = m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        int b = m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        int c = m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        return a - b + c;
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(int[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;

        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] = m[0][0] / det;
        return inv;
    }

    // Inverse of 3x3 matrix
    public static double[][] inverse3x3(int[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;  // Matrix is not invertible

        double[][] inv = new double[3][3];
        
        // Calculate cofactors
        inv[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inv[0][2] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;
        
        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inv[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;
        
        inv[2][0] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inv[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;
        
        return inv;
    }

    // Display any matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
        System.out.println();
    }

    // Display double matrix (inverse)
    public static void displayDoubleMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%.2f\t", val);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get matrix dimensions from user
        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt(), cols = sc.nextInt();

        // Step 2: Generate two random matrices
        int[][] A = generateMatrix(rows, cols);
        int[][] B = generateMatrix(rows, cols);

        // Step 3: Display matrices
        System.out.println("Matrix A:");
        displayMatrix(A);

        System.out.println("Matrix B:");
        displayMatrix(B);

        // Step 4: Perform and display matrix addition, subtraction, and multiplication if applicable
        System.out.println("A + B:");
        displayMatrix(addMatrix(A, B));

        System.out.println("A - B:");
        displayMatrix(subtractMatrix(A, B));

        if (cols == rows) {  // Can multiply if matrices are square
            System.out.println("A * B:");
            displayMatrix(multiplyMatrix(A, B));
        }

        // Step 5: Display transpose of A
        System.out.println("Transpose of A:");
        displayMatrix(transposeMatrix(A));

        // Step 6: Compute and display determinants and inverses if matrix is 2x2 or 3x3
        if (rows == 2 && cols == 2) {
            System.out.println("Determinant of A: " + determinant2x2(A));
            double[][] inv = inverse2x2(A);
            if (inv != null) {
                System.out.println("Inverse of A:");
                displayDoubleMatrix(inv);
            } else {
                System.out.println("Matrix A is not invertible.");
            }
        }

        if (rows == 3 && cols == 3) {
            System.out.println("Determinant of A: " + determinant3x3(A));
            double[][] inv = inverse3x3(A);
            if (inv != null) {
                System.out.println("Inverse of A:");
                displayDoubleMatrix(inv);
            } else {
                System.out.println("Matrix A is not invertible.");
            }
        }

        sc.close();
    }
}
