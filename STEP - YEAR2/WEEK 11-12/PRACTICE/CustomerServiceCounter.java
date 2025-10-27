import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerServiceCounter {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ARRIVE <name>/SERVE/STATUS/EXIT): ");
            String cmd = sc.next();

            // Handle ARRIVE - add to queue
            if (cmd.equalsIgnoreCase("ARRIVE")) {
                String name = sc.next();
                queue.add(name);
            }

            // Handle SERVE - remove from queue
            else if (cmd.equalsIgnoreCase("SERVE")) {
                if (queue.isEmpty()) {
                    System.out.println("No customers to serve!");
                } else {
                    String served = queue.poll();
                    System.out.println("Serving " + served);
                }
            }

            // Handle STATUS - display waiting list
            else if (cmd.equalsIgnoreCase("STATUS")) {
                if (queue.isEmpty()) {
                    System.out.println("No customers waiting.");
                } else {
                    System.out.println("Waiting: " + queue);
                }
            }

            // Handle EXIT - break loop
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting system...");
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
