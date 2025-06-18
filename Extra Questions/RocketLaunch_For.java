import java.util.*;

public class RocketLaunch {
	public static void main (String[] args) {
		Scanner obj = new Scanner(System.in);
		
		//Taking user input for countdown
		System.out.print("Enter the countdown start value: ");
		int counter = obj.nextInt();
		
		for (int i = counter; i>=1; i--) {
			System.out.println(i);
		}
		
		System.out.println("Launching rocket.... " );
		
		obj.close();
	}
}
	