import java.util.*;

public class Program1 {
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the age of the person : ");
        int age = obj.nextInt();

        if (age >= 18) { // check if age is 18 or more
            System.out.println("Eligible to vote"); // print if eligible to vote
        }

        else {
            System.out.println("Not eligible to vote"); // print if not eligible to vote
        }
    }
}

/* Sample Input/Output:
Enter the age of the person :
20
Eligible to vote

Enter the age of the person :
17
Not eligible to vote
*/