import java.util.*;

public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);  //object creation

        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = obj.nextInt();  //user input for numberOfChocolates

        System.out.print("Enter number of children: ");
        int numberOfChildren = obj.nextInt();  //user input for numberOfChildren

        int chocolatesPerChild = numberOfChocolates / numberOfChildren;   //finding chocolatesPerChild
        int remainingChocolates = numberOfChocolates % numberOfChildren;  //finding number of remaining chocolates

        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild + " and the number of remaining chocolates are " + remainingChocolates);  //printing number of chocolates each child gets and number of remaining chocolates....

        obj.close();
    }
}
