import java.util.Scanner;
public class StringMethods {
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        // TODO: Ask user for their full name (first and last name)
        System.out.print("Enter your full name (first and last name): ");
        String fullName = obj.nextLine().trim(); // trim to remove leading/trailing spaces

        // TODO: Ask user for their favorite programming language
        System.out.print("Enter your favorite programming language: ");
        String favoriteLanguage = obj.nextLine().trim(); 

        // TODO: Ask user for a sentence about their programming experience
        System.out.print("Enter a sentence about your programming experience: ");
        String experienceSentence = obj.nextLine().trim();

        // TODO: Process the input:
        // 1. Extract first and last name separately
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts.length > 0 ? nameParts[0] : ""; // handle case with no first name
        String lastName = nameParts.length > 1 ? nameParts[1] : "(not provided)"; // handle case with no last name

        // 2. Count total characters in the sentence (excluding spaces)
        int charCount = experienceSentence.replace(" ", "").length();

        // 3. Convert programming language to uppercase
        String upperCaseLanguage = favoriteLanguage.toUpperCase();

        // 4. Display a formatted summary
        System.out.println("\nSummary:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Programming Language: " + upperCaseLanguage);
        System.out.println("Programming Experience Sentence: " + experienceSentence);
        System.out.println("Total Characters in Experience Sentence (excluding spaces): " + charCount);

        obj.close();
    }
}