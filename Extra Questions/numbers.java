//Performing Logical operators 
import java.util.Scanner;
public class numbers{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Number : ");
		int number = input.nextInt();
		System.out.println("Is the number even ? " + (number%2 == 0));
		System.out.println("Is the number positive ? " +(number>0));
		System.out.println("Is the number zero ? "+(number == 0));
		input.close();
	}
}