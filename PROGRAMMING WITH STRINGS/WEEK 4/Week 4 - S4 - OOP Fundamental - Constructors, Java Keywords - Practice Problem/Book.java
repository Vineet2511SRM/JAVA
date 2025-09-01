
public class Book {

    String title;
    String author;
    double price;

    // TODO: Default constructor
    Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // TODO: Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // TODO: Display method
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        // TODO: Create book1 using default constructor
        Book book1 = new Book();
        

        // TODO: Create book2 using parameterized constructor
        Book book2 = new Book("1984", "George Orwell", 9.99);
        

        // TODO: Display both books
        System.out.println("Displaying both books...");
        book1.display();
        book2.display();
    }
}
