// This program reverses array in java

import java.util.Scanner;

public class Reverse_Array {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        //Take user input from the user
        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        

        //Counting digits
        int tempNum = num;
        int count = 0;
        while(tempNum!=0){
            tempNum/=10;
            count++;
        }

        //storing digits in a new array
        int[] digits = new int[count];
        tempNum = num;

        for(int i = count-1; i>=0; i--){
            digits[i] = tempNum%10;
            tempNum/=10;
        }

        //Creating an array for storing digits in reverse order
        int[] reversedDigits = new int[count];
        for(int i = 0; i<count; i++){
            reversedDigits[i] = digits[count-i-1];
        }

        //Printing the reversed array
        System.out.print("Elements of array in reversed order : ");
        for(int i = 0; i<count; i++){
            System.out.print(reversedDigits[i] + "");
        }

        sc.close();


    }
}