import java.util.Scanner;

public class StringPerformance {

    // Method 1: String concatenation using '+'
    public static long StringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a"; // creates new String every time
        }
        long end = System.currentTimeMillis();
        System.out.println("Final String Length (String): " + str.length());
        return end - start;
    }

    // Method 2: StringBuilder
    public static long StringBuilder(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("Final String Length (StringBuilder): " + sb.length());
        return end - start;
    }

    // Method 3: StringBuffer
    public static long StringBuffer(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("Final String Length (StringBuffer): " + sb.length());
        return end - start;
    }

    // Display results in tabular format
    public static void displayResults(long stringTime, long builderTime, long bufferTime) {
        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("%-20s %-20s %-20s\n", "Method", "Time (ms)", "Memory Efficiency");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-20s %-20d %-20s\n", "String (+)", stringTime, "Low");
        System.out.printf("%-20s %-20d %-20s\n", "StringBuilder", builderTime, "High");
        System.out.printf("%-20s %-20d %-20s\n", "StringBuffer", bufferTime, "Medium");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations (e.g., 1000, 10000, 100000): ");
        int iterations = sc.nextInt();

        long stringTime = StringConcat(iterations);
        long builderTime = StringBuilder(iterations);
        long bufferTime = StringBuffer(iterations);

        displayResults(stringTime, builderTime, bufferTime);
    }
}
