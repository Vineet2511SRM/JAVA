
import java.util.Scanner;
import java.util.Stack;

public class BrowserNavigation {

    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String current = "Home";

        while (true) {
            System.out.println("Command (VISIT/BACK/FORWARD/PRINT/EXIT): ");
            String cmd = sc.next();

            // TODO: Implement VISIT - push to backStack
            if (cmd.equals("VISIT")) {
                backStack.push(current);
                current = sc.next();
                forwardStack.clear();
            }

            // TODO: Implement BACK - move from backStack to forwardStack
            else if (cmd.equals("BACK")) {
                if (!backStack.isEmpty()) {
                    forwardStack.push(current);
                    current = backStack.pop();
                } else {
                    System.out.println("No page to go back to.");
                }
            }

            // TODO: Implement FORWARD - move from forwardStack to backStack
            else if (cmd.equals("FORWARD")) {
                if (!forwardStack.isEmpty()) {
                    backStack.push(current);
                    current = forwardStack.pop();
                } else {
                    System.out.println("No page to go forward to.");
                }
            }

            // TODO: PRINT current page
            else if (cmd.equals("PRINT")) {
                System.out.println("Current page: " + current);
            }

            // Exit the program
            else if (cmd.equals("EXIT")) {
                break;
            }
        }
    }
}