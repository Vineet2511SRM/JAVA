// Print the multiplication table of a given number using do while loop
import java.util.Scanner;
public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number.... : ");
        int num = sc.nextInt();

        int i = 1;
        
        do {
            System.out.println(num + " x " + i + " = " + (num * i));
            i++;
        } while (i <= 10); 

        sc.close(); 
    }
}
