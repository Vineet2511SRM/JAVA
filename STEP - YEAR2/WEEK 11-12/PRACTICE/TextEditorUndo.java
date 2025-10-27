import java.util.Scanner;
import java.util.Stack;

public class TextEditorUndo {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (TYPE word>/UNDO/PRINT/EXIT): ");
            String cmd = sc.next();

            // TODO: Handle TYPE - push word
            if (cmd.equals("TYPE")) {
                String word = sc.next();
                stack.push(word);
            }

            // TODO: Handle UNDO - pop last word
            else if (cmd.equals("UNDO")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    System.out.println("Nothing to undo.");
                }
            }

            // TODO: Handle PRINT - display full sentence
            else if (cmd.equals("PRINT")) {
                if (stack.isEmpty()) {
                    System.out.println("No text.");
                } else {
                    StringBuilder sentence = new StringBuilder();
                    for (String word : stack) {
                        sentence.append(word).append(" ");
                    }
                    System.out.println(sentence.toString().trim());
                }
            }

            // Exit the program
            else if (cmd.equals("EXIT")) {
                break;
            }
        }
    }
}