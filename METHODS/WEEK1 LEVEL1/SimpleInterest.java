import java.util.Scanner;

public class SimpleInterest {

    // method to calculate the simple interest given principle, rate and time as parameters

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Input values
        System.out.print("Enter Principal amount: ");
        double principal = obj.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = obj.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = obj.nextDouble();

        // Calculate simple interest
        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        // Display result
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f years\n",
                          simpleInterest, principal, rate, time);

        obj.close();
    }
}
