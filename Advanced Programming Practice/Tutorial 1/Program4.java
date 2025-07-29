// Java program to display words of a sentence using for Loop

import java.util.*;

public class Program4 {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter a sentence:");

        String sent = ob.nextLine();

        String[] words = sent.split(" ");
        System.out.println("Words in the sentence are:");

        for(String word:words) { // for-each loop to iterate through each word
            System.out.println(word);
        }

    ob.close();
    }
}