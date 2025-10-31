import java.util.Scanner;

class Queue {
    int size;
    int front, rear;
    int[] arr;

    // Constructor
    Queue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return (front == -1 || front > rear);
    }

    // Check if queue is full
    boolean isFull() {
        return (rear == size - 1);
    }

    // Insert element
    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full!");
        } else {
            if (front == -1) front = 0; // first element
            arr[++rear] = data;
            System.out.println(data + " inserted into queue.");
        }
    }

    // Remove element
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.println(arr[front] + " removed from queue.");
            front++;
        }
    }

    // Peek front element
    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.println("Front element: " + arr[front]);
        }
    }

    // Display all elements
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Queue: ");
        int size = sc.nextInt();

        Queue q = new Queue(size);

        int choice;
        do {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int data = sc.nextInt();
                    q.enqueue(data);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}

