// Java program to compare two strings given through user and check the result

import java.util.Scanner;

public class StringComparision {

    // Method to compare two string using charAt()
    public static boolean CheckString(String str1,String str2){
        
        // Check if the length of both strings are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare each character of both strings
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter first string variable : ");
        String str1 = obj.next();

        System.out.println("Enter first string variable : ");
        String str2 = obj.next();


        // Comparing using charAt()
        boolean resultCharAt = CheckString(str1, str2);

        // Comparing using equals()
        boolean resultEquals = str1.equals(str2);

         // Displaying results
        System.out.println("Comparison using charAt(): " + resultCharAt);
        System.out.println("Comparison using equals(): " + resultEquals);

        // Check if both results are same
        if (resultCharAt == resultEquals) {
            System.out.println(" Both methods gives the same result.");
        } else {
            System.out.println(" The methods gives different results.");
        }

        obj.close();
    }
}


        

    
