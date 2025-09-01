public class Counter {
    // static variable to hold object count
    static int count = 0;

    // Constructor increments count each time object is created
    Counter() {
        count++;
        System.out.println("Counter object created. Current count = " + count);
    }

    // Static method to return count
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== OBJECT COUNT TRACKER ===");

        // Create several Counter objects
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        // Display number of objects created using static method
        System.out.println("\nTotal objects created: " + Counter.getCount());

        // Even after more objects
        Counter c4 = new Counter();
        Counter c5 = new Counter();

        System.out.println("Updated total objects created: " + Counter.getCount());
    }
}
