import java.util.*;

public class QuotientRemainder{
		public static void main(String[] args){
		int number1,number2;
		int quotient;
		int remainder;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter number1 : ");
		number1 = obj.nextInt();
		System.out.println("Enter number2 : ");
		number2 = obj.nextInt();
		
		quotient = number1/number2;
		remainder = number1%number2;
		
		System.out.println("The Quotient is "+quotient+" and Remainder is "+remainder+" of two number "+number1+" and "+number2);

		obj.close();
	}
}
