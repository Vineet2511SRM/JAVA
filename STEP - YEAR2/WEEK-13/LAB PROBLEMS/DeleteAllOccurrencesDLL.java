class DeleteAllOccurrencesDLL {
    Node head;

    // Node definition
    class Node {
        int data;
        Node prev, next;
        Node(int d) { data = d; }
    }

    // Insert at end
    void insert(int d) {
        Node n = new Node(d);
        if (head == null) { head = n; return; }
        Node t = head;
        while (t.next != null) t = t.next;
        t.next = n; n.prev = t;
    }

    // Delete all nodes with given value
    void deleteAll(int val) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == val) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
            }
            curr = curr.next;
        }
    }

    // Display list
    void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data);
            if (t.next != null) System.out.print(" ⇄ ");
            t = t.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteAllOccurrencesDLL list = new DeleteAllOccurrencesDLL();
        for (int x : new int[]{10, 20, 30, 20, 40}) list.insert(x);

        System.out.println("Original List:");
        list.display();

        int del = 20;
        System.out.println("Deleting all occurrences of " + del + "...");
        list.deleteAll(del);

        System.out.println("Updated List:");
        list.display();
    }
}


