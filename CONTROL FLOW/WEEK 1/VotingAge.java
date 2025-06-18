import java.util.*;

public class VotingAge {
	public static void main (String[] args) {
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter age of the person: ");
		int age = obj.nextInt(); // input age
		
		if (age>=18) { // if age is greater than or equal to 18
			System.out.println("The person's age is "+age+ " and can vote."); // print this
		}
		
		else {
			System.out.println("The person's age is "+age+ " and cannot vote."); // else print this
		}
	obj.close();
	}
}