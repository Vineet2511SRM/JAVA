import java.util.*;

public class TravelComputation {
    public static void main(String[] args) {
        // Creation of scanner object
        Scanner sc = new Scanner(System.in);

        // Asking for the user's name
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // prompting user for the city details
        System.out.print("Enter From City: ");
        String fromCity = sc.nextLine();
        
        System.out.print("Enter Via City: ");
        String viaCity = sc.nextLine();
        
        System.out.print("Enter To City: ");
        String toCity = sc.nextLine();
        
        // prompting user to input the distances (in miles)
        System.out.print("Enter Distance From To Via (in miles): ");
        double fromToVia = sc.nextDouble();
        
        System.out.print("Enter Distance Via To Final City (in miles): ");
        double viaToFinalCity = sc.nextDouble();

        // propmting user to input the time taken for the journey (in hours)
        System.out.print("Enter Time Taken (in hours): ");
        double timeTaken = sc.nextDouble();

        // Conversion of time from hours to minutes
        double totalTime = timeTaken * 60;

        // Calculating total distance traveled
        double totalDistance = fromToVia + viaToFinalCity;

        // Calculating speed based on total distance and time taken
        double speed = totalDistance / totalTime;

        // Displaying the proper results
        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity +
                           " is " + totalDistance + " miles and the Total Time taken is " + totalTime + " minutes");

        // Closing the scanner to avoid resource leaks
        sc.close();
    }
}
