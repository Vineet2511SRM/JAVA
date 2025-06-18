import java.util.*;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  //object creation

        System.out.print("Enter Principal Amount: ");
        double principal = sc.nextDouble();  //prompting user to input principal amount

        System.out.print("Enter Rate of Interest (% per annum): ");
        double rate = sc.nextDouble();  //prompting user to input rate of interest(per annum)

        System.out.print("Enter Time (years): ");
        double time = sc.nextDouble();  //prompting user to input time in years

        double simpleInterest = (principal * rate * time) / 100;    // Simple Interest Calculation

	//Printing calculated Simple Interest from the principal amount,rate of interest and time given by the user

        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + ", Rate of Interest " + rate + "%, and Time " + time + " years.");

        scanner.close();
    }
}
