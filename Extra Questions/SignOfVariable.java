import java.util.*;

public class SignOfVariable {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//Taking user input for the number variable
		
		System.out.println("Enter the number: ");
		int number = sc.nextInt();
		
		//Checking if number is positive 
		if (number > 0) {
			System.out.println("The given number is positive...");
		}
		
		else if (number<0) {
			System.out.println("The given number is negative...");
		}

		else {
			System.out.println("The given number is 0...");
	}
}
}