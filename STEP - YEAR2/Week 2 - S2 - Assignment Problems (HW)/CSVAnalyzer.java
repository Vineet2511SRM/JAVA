import java.util.Scanner;
public class CSVAnalyzer {

    // Method to parse CSV into 2D array without split()
    static String[][] parseCSV(String input, int maxRows, int maxCols) {
        String[][] table = new String[maxRows][maxCols];
        int row = 0, col = 0, start = 0;
        boolean inQuotes = false;

        for (int i = 0; i <= input.length(); i++) {
            char c = (i < input.length()) ? input.charAt(i) : '\n';
            if (c == '"') inQuotes = !inQuotes;
            else if ((c == ',' && !inQuotes) || (c == '\n')) {
                table[row][col++] = input.substring(start, i);
                if (c == '\n') { row++; col = 0; }
                start = i + 1;
            }
        }
        return table;
    }

    // Clean and trim data fields
    static void cleanData(String[][] table, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (table[r][c] == null) table[r][c] = "";
                table[r][c] = table[r][c].trim();
                if (table[r][c].startsWith("\"") && table[r][c].endsWith("\""))
                    table[r][c] = table[r][c].substring(1, table[r][c].length() - 1);
            }
        }
    }

    // Check if string is numeric
    static boolean isNumeric(String s) {
        if (s.equals("")) return false;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        return true;
    }

    // Analyze numeric columns (min, max, avg)
    static void analyze(String[][] table, int rows, int cols) {
        for (int c = 0; c < cols; c++) {
            int sum = 0, count = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int r = 1; r < rows; r++) {
                String val = table[r][c];
                if (isNumeric(val)) {
                    int num = Integer.parseInt(val);
                    sum += num; min = Math.min(min, num); max = Math.max(max, num); count++;
                }
            }
            if (count > 0) { // atleast one numeric found
                System.out.println("Column " + table[0][c] +
                        " : Min=" + min + " Max=" + max +
                        " Avg=" + String.format("%.2f", (double) sum / count));
            }
        }
    }

    // Format table neatly with fixed width
    static void printTable(String[][] table, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        int width = 15;
        sb.append("+"); for (int c = 0; c < cols; c++) sb.append("-".repeat(width)).append("+"); sb.append("\n");
        for (int r = 0; r < rows; r++) {
            sb.append("|");
            for (int c = 0; c < cols; c++)
                sb.append(String.format("%-" + width + "s", (table[r][c] == null ? "" : table[r][c]))).append("|");
            sb.append("\n+"); for (int c = 0; c < cols; c++) sb.append("-".repeat(width)).append("+"); sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    // Data summary report
    static void summary(String[][] table, int rows, int cols) {
        int missing = 0, total = rows * cols;
        for (int r = 1; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (table[r][c] == null || table[r][c].trim().equals("")) missing++;
        double completeness = 100.0 * (total - missing) / total;
        System.out.println("\nData Summary Report");
        System.out.println("Total Records: " + (rows - 1));
        System.out.println("Columns: " + cols);
        System.out.println("Missing Values: " + missing);
        System.out.println("Completeness: " + String.format("%.2f", completeness) + "%");
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV-like data (end with empty line):");
        StringBuilder input = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.equals("")) break;
            input.append(line).append("\n");
        }

        String[][] table = parseCSV(input.toString(), 50, 10);

        // Count rows & cols correctly
        int rows = 0, cols = 0;
        while (rows < table.length && table[rows][0] != null) rows++;
        while (cols < table[0].length && table[0][cols] != null) cols++;

        cleanData(table, rows, cols);
        System.out.println("\nFormatted Table:");
        printTable(table, rows, cols);

        System.out.println("\nAnalysis:");
        analyze(table, rows, cols);

        summary(table, rows, cols);
    }
}