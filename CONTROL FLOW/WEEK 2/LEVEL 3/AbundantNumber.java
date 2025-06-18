// program to check if a number is an abundant number or not
import java.util.*;
public class AbundantNumber {

        public static void main(String[] args){

            Scanner obj = new Scanner(System.in);

            System.out.println("Enter an integer : ");
            int number = obj.nextInt();

            int sum = 0;

            for(int i = 1; i<number; i++){
                if(number%i==0){
                    sum+=i;
                }
            }

            if (sum>number)
                System.out.println("Abundant Number");
            else 
                System.out.println("Not an Abundant Number");

            obj.close();
        }
}