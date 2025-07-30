import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer number :");
        int num = sc.nextInt();

        if(num%2==0){
            System.out.println("The given number "+num+" is even");
        }

        else{
            System.out.println("The given number "+num+" is odd");
        }
    }
}

/* Sample Input/Output:
Enter an integer number :
4
The given number 4 is even

Enter an integer number :
5
The given number 5 is odd
*/

