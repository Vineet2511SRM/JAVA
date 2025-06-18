// Java program to find BMI of a person

import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter weight of the person (in kg) : ");
        double weight = sc.nextDouble();

        System.out.println("Enter height of the person (in cm) : ");
        double height = sc.nextDouble();

        double bmi = weight / ((height / 100) * (height / 100)); // Calculate BMI converting height to meters

        if (bmi <= 18.4)
            System.out.println("Status : Underweight");
        else if (bmi >= 18.5 && bmi <= 24.9)
            System.out.println("Status : Normal");
        else if (bmi >= 25.0 && bmi <= 39.9)
            System.out.println("Status : Overweight");
        else if (bmi >= 40.0)
            System.out.println("Status : Obese");
        else
            System.out.println("Enter correct input values......");
        
        sc.close();
    }
}