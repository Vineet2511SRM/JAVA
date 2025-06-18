import java.util.*;

public class CALCULATOR {
    public static void main(String[] args) {
        float number1, number2, add, sub, multi, div = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number1: ");
        number1 = sc.nextFloat();
        
        System.out.print("Enter number2: ");
        number2 = sc.nextFloat();

        add = number1 + number2;
        sub = number1 - number2;
        multi = number1 * number2;
        
        if (number2 == 0) {
            System.out.println("Error!: Division by Zero is not possible");
        } else {
            div = number1 / number2;
        }

        System.out.print("The addition, subtraction, multiplication and division value of 2 numbers "
                + number1 + " and " + number2 + " is " + add + ", " + sub + ", " + multi);
        
        if (number2 != 0) {
            System.out.println(", and " + div);
        } else {
            System.out.println(", and undefined (division by zero)");
        }

        sc.close(); 
    }
}
