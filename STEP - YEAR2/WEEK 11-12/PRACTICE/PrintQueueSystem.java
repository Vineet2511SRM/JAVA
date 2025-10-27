import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintQueueSystem {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ADD <doc>/PRINT/EXIT): ");
            String cmd = sc.next();

            // Handle ADD - enqueue document
            if (cmd.equalsIgnoreCase("ADD")) {
                String doc = sc.next();
                printQueue.add(doc);
            }

            // Handle PRINT - dequeue and show printed document
            else if (cmd.equalsIgnoreCase("PRINT")) {
                if (printQueue.isEmpty()) {
                    System.out.println("No jobs left!");
                } else {
                    String printed = printQueue.poll();
                    System.out.println("Printing " + printed);
                }
            }

            // Handle EXIT - break loop
            else if (cmd.equalsIgnoreCase("EXIT")) {
                break;
            }

            // Handle invalid command
            else {
                System.out.println("Invalid command!");
            }
        }

        sc.close();
    }
}
