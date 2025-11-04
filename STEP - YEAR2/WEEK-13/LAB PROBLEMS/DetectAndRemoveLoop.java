class DetectAndRemoveLoop {
    Node head; // reference to first node

    // Inner Node class
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Insert new node at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Create a loop manually for testing
    public void createLoop(int position) {
        if (position <= 0) return;
        Node loopNode = head;
        for (int i = 1; i < position && loopNode != null; i++) {
            loopNode = loopNode.next;
        }
        if (loopNode == null) return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = loopNode; // last node points back to 'position' node
    }

    // Detect and remove loop using Floyd’s Algorithm
    public boolean detectAndRemoveLoop() {
        Node slow = head, fast = head;
        boolean loopExists = false;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // collision point
                loopExists = true;
                break;
            }
        }

        // Step 2: If loop exists, find and remove it
        if (loopExists) {
            System.out.println("Loop detected!");
            removeLoop(slow);
            return true;
        }
        return false;
    }

    // Helper method to remove loop
    private void removeLoop(Node loopNode) {
        Node ptr1 = head;
        Node ptr2 = loopNode;

        // Move both pointers one step at a time until they meet at the start of the loop
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Now find the node just before the start of loop
        Node last = ptr2;
        while (last.next != ptr1) {
            last = last.next;
        }

        // Break the loop
        last.next = null;
        System.out.println("Loop removed successfully!");
    }

    // Display linked list
    public void display() {
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
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();

        // Step 1: Create list
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Original List (with loop to be created):");
        list.display();

        // Step 2: Create a loop (50 → 30)
        list.createLoop(3);

        // Step 3: Detect and remove loop
        boolean loopFound = list.detectAndRemoveLoop();

        // Step 4: Show final list
        if (loopFound) {
            System.out.println("List after removing loop:");
            list.display();
        } else {
            System.out.println("No loop detected.");
        }
    }
}

