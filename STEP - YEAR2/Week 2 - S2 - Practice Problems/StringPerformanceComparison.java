public class StringPerformanceComparison {

    public static void main(String[] args) {

        // TODO: Implement performance tests for different approaches
        // Test 1: String concatenation performance
        System.out.println("=== PERFORMANCE COMPARISON ===");

        // TODO: Test string concatenation with regular String (slow method)
        long startTime = System.nanoTime();
        String result1 = concatenateWithString(1000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns"); // Slow method

        // TODO: Test string concatenation with StringBuilder (fast method)
        long startTime2 = System.nanoTime();
        String result2 = concatenateWithStringBuilder(1000);
        long endTime2 = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime2 - startTime2) + " ns"); // Fast method

        // TODO: Test string concatenation with StringBuffer (thread-safe)
        long startTime3 = System.nanoTime();
        String result3 = concatenateWithStringBuffer(1000);
        long endTime3 = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime3 - startTime3) + " ns"); // Thread-safe method

        // TODO: Compare memory usage (approximate)
        System.out.println("Approximate memory usage:");
        System.out.println("String: " + (result1.length() * 2) + " bytes");
        System.out.println("StringBuilder: " + (result2.length() * 2) + " bytes");
        System.out.println("StringBuffer: " + (result3.length() * 2) + " bytes");

        // TODO: Demonstrate thread safety differences
        demonstrateThreadSafety();

        // TODO: Create practical examples showing when to use each approach
        demonstratePracticalUseCases();

       

        // TODO: Method to demonstrate StringBuilder methods
        demonstrateStringBuilderMethods();

        // TODO: Method to compare string comparison methods
        compareStringComparisonMethods();

        // TODO: Method to demonstrate memory efficiency
        demonstrateMemoryEfficiency();
    }

    // TODO: Method using String concatenation (inefficient)
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " "; // Inefficient string concatenation
        }
        return result;
    }

    // TODO: Method using StringBuilder (efficient, not thread-safe)
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" "); // Efficient string concatenation
        }
        return sb.toString(); // Convert StringBuilder to String
    }

    // TODO: Method using StringBuffer (efficient, thread-safe)
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" "); // Efficient string concatenation with thread safety
        }
        return sb.toString(); // Convert StringBuffer to String
    }

    // TODO: Method to demonstrate StringBuilder methods
    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World"); // Create a StringBuilder with initial content as "Hello World"

        // TODO: Use the following StringBuilder methods:
        // 1. append() - Add text to end
        sb.append(" I'm Vineet Seth");
        System.out.println(sb.toString());

        // 2. insert() - Insert text at specific position
        sb.insert(6, "Beautiful ");
        System.out.println(sb.toString());

        // 3. delete() - Remove characters from range
        String r = sb.delete(0, 6).toString(); // Remove "Hello "
        System.out.println(r);

        // 4. deleteCharAt() - Remove character at index
        sb.deleteCharAt(0); // Remove ' '
        System.out.println(sb.toString());

        // 5. reverse() - Reverse the string
        String x = sb.reverse().toString(); // Reverse the string and stores it in x
        System.out.println(x);

        // 6. replace() - Replace substring
        sb.replace(0, 5, "Hi"); // Replace "Hello" with "Hi"
        System.out.println(sb.toString());

        // 7. setCharAt() - Change character at index
        sb.setCharAt(0, 'h'); // Change 'H' to 'h'
        System.out.println(sb.toString());

        // 8. capacity() - Show current capacity
        System.out.println("Capacity: " + sb.capacity());

        // 9. ensureCapacity() - Set minimum capacity
        sb.ensureCapacity(100); // Ensure capacity is at least 100
        System.out.println("New Capacity: " + sb.capacity());

        // 10. trimToSize() - Reduce capacity to current length
        sb.trimToSize();
        System.out.println("Trimmed Capacity: " + sb.capacity());
    }

    // TODO: Method to demonstrate StringBuffer thread safety
    public static void demonstrateThreadSafety() {
        StringBuffer buffer = new StringBuffer("Start-"); // shared resource

        // Create a Runnable task that appends to the buffer
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                buffer.append(Thread.currentThread().getName()).append(" ");
            }
        };

        // Create multiple threads sharing the same task
        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for all to finish before printing result
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final content of buffer
        System.out.println("Final StringBuffer content: " + buffer);

        // Show that StringBuffer is thread-safe while StringBuilder is not
        StringBuilder builder = new StringBuilder("Start-"); // not thread-safe
        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                builder.append(Thread.currentThread().getName()).append(" ");
            }
        };
        Thread t4 = new Thread(task2, "T4");
        Thread t5 = new Thread(task2, "T5");
        Thread t6 = new Thread(task2, "T6");
        t4.start();
        t5.start();
        t6.start();
        try {
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final StringBuilder content: " + builder);
        System.out.println("Note: StringBuilder is not thread-safe, so results may vary.");

    }

    // TODO: Method to compare string comparison methods
    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello"); // Creates a new String object

        // TODO: Compare using:
        // 1. == operator (reference comparison)
        System.out.println("Using == operator:");
        System.out.println("str1 == str2: " + (str1 == str2)); // true
        System.out.println("str1 == str3: " + (str1 == str3)); // false

        // 2. equals() method (content comparison)
        System.out.println("Using equals() method:");
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true

        // 3. equalsIgnoreCase() method
        System.out.println("Using equalsIgnoreCase() method:");
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2)); // true
        System.out.println("str1.equalsIgnoreCase(str3): " + str1.equalsIgnoreCase(str3)); // true

        // 4. compareTo() method (lexicographic comparison)
        System.out.println("Using compareTo() method:");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // 0
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // 0

        // 5. compareToIgnoreCase() method
        System.out.println("Using compareToIgnoreCase() method:");
        System.out.println("str1.compareToIgnoreCase(str2): " + str1.compareToIgnoreCase(str2)); // 0
        System.out.println("str1.compareToIgnoreCase(str3): " + str1.compareToIgnoreCase(str3)); // 0

        // TODO: Explain the differences and when to use each
        System.out.println("1. == operator: Use this for reference comparison (checking if two references point to the same object).");
        System.out.println("2. equals() method: Use this for content comparison (checking if two strings have the same content).");
        System.out.println("3. equalsIgnoreCase() method: Use this for case-insensitive content comparison.");
        System.out.println("4. compareTo() method: Use this for lexicographic comparison (dictionary order) of strings.");
        System.out.println("5. compareToIgnoreCase() method: Use this for case-insensitive lexicographic comparison.");
        System.out.println();

    }

    // TODO: Method to demonstrate memory efficiency
    public static void demonstrateMemoryEfficiency() {
        // TODO: Show memory usage before and after different string operations
        String str = "Hello";
        StringBuilder builder = new StringBuilder("Hello");
        System.out.println("Memory usage before operations:");
        System.out.println("String: " + getMemoryUsage(str));
        System.out.println("StringBuilder: " + getMemoryUsage(builder));

        // Perform some operations
        str += " World";
        builder.append(" World");

        System.out.println("Memory usage after operations:");
        System.out.println("String: " + getMemoryUsage(str));
        System.out.println("StringBuilder: " + getMemoryUsage(builder));

        String s1 = "Vineet";         // goes into String Pool
        String s2 = "Vineet";         // reuses same object from pool
        String s3 = new String("Vineet"); // creates a NEW object in heap

        System.out.println("s1 == s2 : " + (s1 == s2)); // true (same pool object)
        System.out.println("s1 == s3 : " + (s1 == s3)); // false (different objects)
        System.out.println("s1.equals(s3) : " + s1.equals(s3)); // true (values match)

        // TODO: Show StringBuilder capacity management
        System.out.println("StringBuilder capacity before operations: " + builder.capacity());
        builder.append(" World");
        System.out.println("StringBuilder capacity after operations: " + builder.capacity());

    }

    // TODO: Create practical examples showing when to use each approach
    public static void demonstratePracticalUseCases() {
        System.out.println("\n=== PRACTICAL USE CASES ===");

        // Using String for constants/small immutable text
        String appName = "StudentPortal";
        String version = "v1.0";
        String about = appName + " - " + version;
        System.out.println("App Info (String): " + about);

        // Using StringBuilder for single-threaded dynamic operations
        StringBuilder query = new StringBuilder("SELECT * FROM students WHERE ");
        query.append("branch='CSE' ").append("AND year=2 ");
        query.append("ORDER BY cgpa DESC;");
        System.out.println("Generated SQL (StringBuilder): " + query);

        // Using StringBuffer for multi-threaded safe operations
        StringBuffer logBuffer = new StringBuffer("Logs:\n");
        Runnable logTask = () -> {
            for (int i = 0; i < 3; i++) {
                logBuffer.append(Thread.currentThread().getName()).append(" logged an event\n");
            }
        };
        Thread t1 = new Thread(logTask, "Thread-1");
        Thread t2 = new Thread(logTask, "Thread-2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread-safe Logs (StringBuffer):\n" + logBuffer);
    }

    public static int getMemoryUsage(Object obj) {
        return obj.toString().length() * 2; // rough approximation
    }
}
