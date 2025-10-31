import java.util.Scanner;

class CircularQueue {
    int size;
    int front, rear;
    int[] queue;

    // Constructor
    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if queue is full
    boolean isFull() {
        return (front == (rear + 1) % size);
    }

    // Check if queue is empty
    boolean isEmpty() {
        return (front == -1);
    }

    // Insert element
    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full!");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            queue[rear] = data;
            System.out.println(data + " inserted into queue.");
        }
    }

    // Delete element
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.println(queue[front] + " removed from queue.");
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
        }
    }

    // Display queue elements
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            while (true) {
                System.out.print(queue[i] + " ");
                if (i == rear)
                    break;
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Circular Queue: ");
        int size = sc.nextInt();

        CircularQueue cq = new CircularQueue(size);
        int choice;

        do {
            System.out.println("\n--- Circular Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int data = sc.nextInt();
                    cq.enqueue(data);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}

