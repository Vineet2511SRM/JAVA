import java.util.*;

public class SquarePerimeter{
	public static void main(String[] args){
		int perimeter;
		System.out.println("Enter perimeter of square in cm : ");
		Scanner sc = new Scanner(System.in);
		perimeter = sc.nextInt();
		
		int side;
		side = perimeter/4;
	
		System.out.println("The length of the side is "+side+" cm whose perimeter is "+perimeter);
		
		sc.close();
}
}