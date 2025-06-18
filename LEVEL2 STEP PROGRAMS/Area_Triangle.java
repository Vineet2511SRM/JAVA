import java.util.*;

class Area_Triangle {
	public static void main(String[] args){
		int base,height;
		double area_cm;
		double area_inches;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter base in cm: ");
		base = obj.nextInt();
		System.out.println("Enter height in cm : ");
		height = obj.nextInt();
		area_cm = (1/2.0)*base*height;
		area_inches = area_cm * 6.4516;
		System.out.println("Area of triangle in square inches is "+area_inches+" while in square cm is "+area_cm);
		
		obj.close();
}
}