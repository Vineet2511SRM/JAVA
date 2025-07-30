public class Program5 {
    public static void main(String[] args) {
        int x = 5;

        System.out.println("Initial value of x: " + x);

        // Post-increment: value is used first, then incremented
        System.out.println("Post-increment (x++): " + (x++)); // prints 5, then x becomes 6
        System.out.println("Value of x after post-increment: " + x); // prints 6

        // Pre-increment: value is incremented first, then used
        System.out.println("Pre-increment (++x): " + (++x)); // x becomes 7, then prints 7
        System.out.println("Value of x after pre-increment: " + x); // prints 7
    }
}

/* Sample Input/Output:
Initial value of x: 5
Post-increment (x++): 5
Value of x after post-increment: 6
Pre-increment (++x): 7
Value of x after pre-increment: 7
*/