import java.util.Scanner;

public class Height_Convert {
    public static void main(String[] args) {
        double heightCm, totalInches, feet, inches;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        heightCm = input.nextDouble();
        totalInches = heightCm / 2.54;
        feet = (int)(totalInches / 12);
        inches = totalInches % 12;
        System.out.println("Your height in cm is " + heightCm + 
                           ", while in feet it is " + (int)feet + 
                           " and inches is " + String.format("%.2f", inches) + ".");
        input.close();
    }
}
