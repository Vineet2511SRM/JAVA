import java.util.*;

public class DistanceFinder{
	public static void main(String[] args){
		int distanceInfeet;
		System.out.println("Enter distance in feets : ");
		Scanner sc = new Scanner(System.in);
		distanceInfeet = sc.nextInt();
		
		// 1 mile = 1760 yards 1 yard = 3 feet => 1 mile = 5280 feet
		
		int distanceInYards = 3*distanceInfeet;
		
		int distaneInMiles = 1760*distanceInYards;
		
		System.out.println("Distance in feet is "+distanceInfeet+" while in miles is "+distaneInMiles+" and in yards is "+distanceInYards);

		sc.close();
}
}