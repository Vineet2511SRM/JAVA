import java.util.Scanner;
import java.util.Stack;

public class TextEditorUndo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> textStack = new Stack<>();
        String currentText = "";
        int choice;

        do {
            System.out.println("\n--- Simple Text Editor ---");
            System.out.println("1. Type Text");
            System.out.println("2. Undo Last Action");
            System.out.println("3. Show Current Text");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    String newText = sc.nextLine();
                    textStack.push(currentText);  // Save current state
                    currentText += newText;       // Update text
                    System.out.println("Text added successfully.");
                    break;

                case 2:
                    if (!textStack.isEmpty()) {
                        currentText = textStack.pop(); // Revert to last state
                        System.out.println("Undo successful!");
                    } else {
                        System.out.println("Nothing to undo!");
                    }
                    break;

                case 3:
                    System.out.println("Current Text: \"" + currentText + "\"");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}

