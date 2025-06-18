import java.util.*;

public class TriangularRun {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);   // Object Creatin

        System.out.print("Enter side 1 (meters): ");
        double side1 = obj.nextDouble();  //prompting user to input first side of the traingle in meters

        System.out.print("Enter side 2 (meters): ");
        double side2 = obj.nextDouble();   //prompting user to input second side of the traingle in meters

        System.out.print("Enter side 3 (meters): ");
        double side3 = obj.nextDouble();  //prompting user to input third side of the traingle in meters

        double perimeter = side1 + side2 + side3;    //calculating perimeter of the traingle
        double rounds = 5000 / perimeter;            // finding total number of rounds ran by the athele to complete 5km(5000m)

        System.out.println("The total number of rounds the athlete will run is " + Math.ceil(rounds) + " to complete 5 km.");   //printing total number of rounds 

        obj.close();
    }
}
