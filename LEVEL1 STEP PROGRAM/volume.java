public class volume{
	public static void main(String[] args){
		double radius = 6378;
		double pi = 3.14;
		double volume_km = (4.0/3)*pi*(radius*radius*radius);
		double volume_miles = volume_km * 0.239913;
		System.out.println("The volume of earth in cubic kilometers is "+volume_km+ " and cubic miles is "+volume_miles);
	}
}

		