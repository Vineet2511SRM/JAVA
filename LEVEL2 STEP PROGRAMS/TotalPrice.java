import java.util.*;

public class TotalPrice{
	public static void main(String[] args){
		double unitPrice,totalPrice;
		int quantity;
		
		Scanner obj = new Scanner(System.in);
	
		System.out.println("Enter unit price of the item: ");
		unitPrice = obj.nextDouble();
		
		System.out.println("Enter total number of quantities of the item: ");
		quantity = obj.nextInt();
		
		totalPrice = (unitPrice*quantity);
		
		System.out.println("The total purchase price is INR "+totalPrice+" if the quantity is "+quantity+" and unit price is INR "+unitPrice);

		obj.close();
	}
}

		