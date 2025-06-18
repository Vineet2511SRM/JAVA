import java.util.*;

public class DivisibleBy5 { 
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Please enter a number: ");
		int num = obj.nextInt();
		
		if (num%5 == 0) { // if the number is divisible by 5
			System.out.println("Is the number "+num+" is divisible by 5? Yesss it is ");} // print this
		else {
			System.out.println("Is the number "+num+" is divisible by 5? No it's not ");} // else print this
		}
}
