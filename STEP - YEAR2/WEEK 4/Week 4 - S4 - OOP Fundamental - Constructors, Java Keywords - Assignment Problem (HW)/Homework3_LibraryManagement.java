/**
 * Program Name: Homework3_LibraryManagement.java
 * Author: Vineet Seth
 * Description: Library Book Management System demonstrating constructor overloading,
 * borrow/return functionality, and displaying book information.
 */

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Default constructor
    public Book() {
        this("", "", "", true);
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this(title, author, "Unknown", true);
    }

    // Full constructor
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // Borrow the book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully: " + title);
        } else {
            System.out.println("Book is already borrowed: " + title);
        }
    }

    // Return the book
    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned successfully: " + title);
    }

    // Display book information
    public void displayBookInfo() {
        System.out.println("----------- Book Info -----------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("--------------------------------\n");
    }

    public String getTitle() {
        return title;
    }
}

// Main class
public class Homework3_LibraryManagement {
    public static void main(String[] args) {
        // Creating books
        System.out.println("Creating books...");
        Book book1 = new Book(); // default empty book
        Book book2 = new Book("Harry Potter", "J.K. Rowling"); // title + author
        Book book3 = new Book("The Alchemist", "Paulo Coelho", "12345", true); // full details

        // Borrowing books
        System.out.println("\nBorrowing books...");
        book2.borrowBook();
        book3.borrowBook();

        // Returning a book
        System.out.println("\nReturning a book...");
        book3.returnBook();

        // Displaying book information
        System.out.println("\nDisplaying all book information:");
        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();
    }
}
