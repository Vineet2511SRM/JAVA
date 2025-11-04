class ReverseLinkedList {
    Node head; // Head of linked list

    // Inner class for Node
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Insert node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // First node
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next; // Move to last node
        }
        temp.next = newNode; // Link new node
    }

    // Reverse the linked list (Iterative method)
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;  // Store next node
            curr.next = prev;  // Reverse current node’s pointer
            prev = curr;       // Move prev to current
            curr = next;       // Move to next node
        }
        head = prev; // Update head to new first node
    }

    // Display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Original List:");
        list.display();

        list.reverse();

        System.out.println("Reversed List:");
        list.display();
    }
}
