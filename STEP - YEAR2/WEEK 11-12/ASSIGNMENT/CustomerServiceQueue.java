import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerServiceQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();

        int choice;
        do {
            System.out.println("\n===== Customer Service System =====");
            System.out.println("1. Add Customer (Enqueue)");
            System.out.println("2. Serve Customer (Dequeue)");
            System.out.println("3. Display Waiting Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    queue.add(name);
                    System.out.println(name + " added to the queue.");
                    displayQueue(queue);
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No customers in queue to serve.");
                    } else {
                        String served = queue.remove();
                        System.out.println("Served Customer: " + served);
                        displayQueue(queue);
                    }
                    break;

                case 3:
                    displayQueue(queue);
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    // Helper method to display queue
    public static void displayQueue(Queue<String> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Current Waiting Queue: " + queue);
        }
    }
}
