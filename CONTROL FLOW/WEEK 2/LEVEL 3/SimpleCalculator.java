import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input from user
        System.out.print("Enter first number: ");
        double firstNumber = sc.nextDouble();
        
        System.out.print("Enter an operator (+, -, *, /): ");
        String op = sc.next();
        
        System.out.print("Enter second number: ");
        double secondNumber = sc.nextDouble();
        
        double result;
        
        // Performing calculation based on the operator
        switch (op) {
            case "+":
                result = firstNumber + secondNumber;
                System.out.println("Result: " + result);
                break;
            case "-":
                result = firstNumber - secondNumber;
                System.out.println("Result: " + result);
                break;
            case "*":
                result = firstNumber * secondNumber;
                System.out.println("Result: " + result);
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operator. Please enter one of +, -, *, /");
        }
        
        sc.close();
    }
}
