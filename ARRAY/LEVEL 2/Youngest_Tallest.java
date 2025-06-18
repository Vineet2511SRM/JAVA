import java.util.Scanner;

public class Youngest_Tallest {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in); // Create a Scanner object for user input

        int [] ages = new int[3]; // Array to store ages of 3 friends Amar, Akbar, and Anthony
        double [] heights = new double[3]; // Array to store heights of 3 friends Amar, Akbar, and Anthony

        for(int i = 0; i < 3; i++){
            System.out.print("Enter the age of friend " + (i + 1) + ": ");
            ages[i] = input.nextInt(); // Read age from user input
            System.out.print("Enter the height of friend " + (i + 1) + ": ");
            heights[i] = input.nextDouble(); // Read height from user input
        }

        // Finding youngest of the three friends
        for(int i=0; i<3; i++){
            if(ages[i] < ages[0]){
                ages[0] = ages[i]; // Update the youngest age
            }
        }
        System.out.println("The youngest friend is " + ages[0] + " years old.");

        // Finding the tallest of the three friends
        for(int i=0 ;i<3; i++){
            if(heights[i] > heights[0]){
                heights[0] = heights[i]; // Update the tallest height
            }

        }
        System.out.println("The tallest friend is " + heights[0] + " cm tall.");

        // Close the scanner to prevent resource leaks
        input.close(); // Close the Scanner object


    }
}