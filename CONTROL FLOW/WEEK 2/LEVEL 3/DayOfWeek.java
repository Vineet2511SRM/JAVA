import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input from user
        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();
        
        System.out.print("Enter day (1-31): ");
        int d = sc.nextInt();
        
        System.out.print("Enter year: ");
        int y = sc.nextInt(); 
        
        sc.close();
        
        // Applying formula to calculate the day of the week
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        
        // Printing result
        System.out.println("The day of the week is: " + d0);
    }
}
