import java.util.*;

public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);  //creation of object

        System.out.print("Enter number of students: ");
        int numberOfStudents = obj.nextInt(); //taking user input for total number of students

        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2; //calculation for finding maximum handshakes

        System.out.println("The maximum number of possible handshakes is " + maxHandshakes);  //printing maximum possible handshakes

        obj.close();
    }
}
