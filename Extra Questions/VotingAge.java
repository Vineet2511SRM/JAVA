import java.util.*;

public class VotingAge {
	public static void main (String[] args) {
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter age of the person: ");
		int age = obj.nextInt();
		
		if (age>=18) {
			System.out.println("The person's age is "+age+ " and can vote.");
		}
		
		else {
			System.out.println("The person's age is "+age+ " and cannot vote.");
		}
	obj.close();
	}
}