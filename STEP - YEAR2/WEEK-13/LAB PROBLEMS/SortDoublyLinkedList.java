class SortDoublyLinkedList {
    Node head;

    // Node structure
    class Node {
        int data;
        Node prev, next;
        Node(int d) { data = d; }
    }

    // Insert node at end
    void insert(int d) {
        Node n = new Node(d);
        if (head == null) { head = n; return; }
        Node t = head;
        while (t.next != null) t = t.next;
        t.next = n; n.prev = t;
    }

    // Bubble sort the list
    void bubbleSort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node t = head;
            while (t.next != null) {
                if (t.data > t.next.data) {
                    int temp = t.data;
                    t.data = t.next.data;
                    t.next.data = temp;
                    swapped = true;
                }
                t = t.next;
            }
        } while (swapped);
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
        SortDoublyLinkedList list = new SortDoublyLinkedList();
        for (int x : new int[]{40, 10, 30, 20}) list.insert(x);

        System.out.println("Original List:");
        list.display();

        list.bubbleSort();

        System.out.println("Sorted List (Ascending):");
        list.display();
    }
}



