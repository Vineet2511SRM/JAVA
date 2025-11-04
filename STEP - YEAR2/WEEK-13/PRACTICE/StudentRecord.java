import java.util.Scanner;

class StudentRecord {
    Node head; // Head of linked list

    // Inner class for Node
    class Node {
        int rollNo;
        Node next;
        
        Node(int r) {
            rollNo = r;
            next = null;
        }
    }

    // Insert a new student roll number at the end
    public void insert(int rollNo) {
        Node newNode = new Node(rollNo); // Create new node
        if (head == null) {
            head = newNode; // If list is empty
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next; // Traverse till last node
        }
        temp.next = newNode; // Attach new node at end
    }

    // Display all student roll numbers
    public void display() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        // Traverse the list and display each roll number
        Node temp = head;
        System.out.print("Students: ");
        while (temp != null) {
            System.out.print(temp.rollNo);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecord list = new StudentRecord();

        while (true) {
            System.out.print("Command (ADD <roll>/SHOW/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ADD")) {
                int roll = sc.nextInt();
                list.insert(roll);
            } 
            else if (cmd.equalsIgnoreCase("SHOW")) {
                list.display();
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting program...");
                break;
            } 
            else {
                System.out.println("Invalid command! Try again.");
            }
        }
        sc.close();
    }
}
