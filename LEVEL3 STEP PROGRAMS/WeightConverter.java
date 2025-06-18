import java.util.*;

public class WeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double weightInPounds = sc.nextDouble();

        double weightInKg = weightInPounds / 2.2;

        System.out.println("The weight of the person in pounds is " + weightInPounds + " and in kilograms is " + weightInKg);

        sc.close();
    }
}
