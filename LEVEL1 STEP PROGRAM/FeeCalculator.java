import java.util.Scanner;

public class FeeCalculator {
    public static void main(String[] args) {
        
        double fee, discountPercent, discount, discounted_Fee;

        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the student fee (INR): ");
        fee = input.nextDouble();

        System.out.print("Enter the university discount percentage: ");
        discountPercent = input.nextDouble();

        
        discount = (fee * discountPercent) / 100;

        
        discounted_Fee = fee - discount;

        
        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + discounted_Fee + ".");

        
        input.close();
    }
}
