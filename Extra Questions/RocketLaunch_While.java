import java.util.*;

public class RocketLaunch_While {
	public static void main (String[] args) {
		Scanner obj = new Scanner(System.in);
		
		//Taking user input for countdown
		System.out.print("Enter the countdown start value: ");
		int counter = obj.nextInt();
		
		int i = counter;
		while(i>=1) {
			System.out.println(i);
			i--;
		}		
		System.out.println("Launching rocket.... " );
		
		obj.close();
	}
}
	