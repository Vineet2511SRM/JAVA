import java.util.*;

public class CharactersInString {

    // User-defined method to return characters in string (char array)
    public static char[] getCharacters(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    // Method to compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        // Check if the lengths of both arrays are equal
        if (arr1.length != arr2.length) {
            return false;
        }
        // Compare each character of both arrays
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner obj = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string: ");
        String str = obj.nextLine();

        // Call the user-defined method and store result
        char[] userDefinedChars = getCharacters(str);

        // Call the built-in method toCharArray() and store result
        char[] builtInChars = str.toCharArray();

        // Compare the two arrays
        boolean result = compareCharArrays(userDefinedChars, builtInChars);

        // Display the arrays
        System.out.println("Characters in the string using user-defined method: ");
        for (char c : userDefinedChars) {
            System.out.print(c + " ");
        }

        System.out.println("\nCharacters in the string using built-in method: ");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }

        // Display comparison result
        System.out.println("\nAre both arrays equal? " + result);

        // Close the scanner
        obj.close();
    }
}
