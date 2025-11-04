import java.util.Scanner;

class SinglyLinkedList {
    Node head; // reference to the first node

    // Inner Node class
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Insert a node at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        // Case 1: Insert at the beginning
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Inserted " + data + " at position " + position);
            display();
            return;
        }

        Node temp = head;
        int count = 1;

        // Traverse until (position - 1)th node
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        // Case 2: Invalid position (greater than size)
        if (temp == null) {
            System.out.println("Invalid position! List size is smaller than " + (position - 1));
            return;
        }

        // Case 3: Insert in middle or end
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted " + data + " at position " + position);
        display();
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        // Initial list
        list.insertAtPosition(10, 1);
        list.insertAtPosition(20, 2);
        list.insertAtPosition(30, 3);
        list.insertAtPosition(40, 4);

        System.out.println("Current List:");
        list.display();

        // User input
        System.out.print("\nEnter element to insert: ");
        int data = sc.nextInt();
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        list.insertAtPosition(data, pos);

        sc.close();
    }
}

