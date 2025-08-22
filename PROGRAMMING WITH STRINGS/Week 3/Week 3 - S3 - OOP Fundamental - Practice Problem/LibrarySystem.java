import java.util.Scanner;

// Book class
class Book {
    String title;
    String author;
    String isbn;
    double price;
    int quantity;

    // Constructor
    Book(String title, String author, String isbn, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quantity;
    }

    // Display book info
    void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn
                + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// Library class
class Library {
    String libraryName;
    Book[] books;  // Library contains Book objects
    int totalBooks;

    Library(String libraryName, int capacity) {
        this.libraryName = libraryName;
        books = new Book[capacity];
        totalBooks = 0;
    }

    // Add a book
    void addBook(Book b) {
        if (totalBooks < books.length) {
            books[totalBooks] = b;
            totalBooks++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    // Search books by title or author
    void searchBook(String keyword) {
        boolean found = false;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].title.equalsIgnoreCase(keyword) || books[i].author.equalsIgnoreCase(keyword)) {
                books[i].displayBookInfo();  // Interacts with multiple Book objects
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for: " + keyword);
        }
    }

    // Display all books
    void displayInventory() {
        if (totalBooks == 0) {
            System.out.println("Library is empty!");
        } else {
            System.out.println("Books in " + libraryName + ":");
            for (int i = 0; i < totalBooks; i++) {
                books[i].displayBookInfo();  // Interacts with multiple Book objects
            }
        }
    }

    // Calculate total value
    void calculateTotalValue() {
        double totalValue = 0;
        for (int i = 0; i < totalBooks; i++) {
            totalValue += books[i].price * books[i].quantity;  // Works with multiple Book objects
        }
        System.out.println("Total value of all books: " + totalValue);
    }
}

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library myLibrary = new Library("City Library", 100); // Capacity 100 books

        // Create some initial books
        Book b1 = new Book("Harry Potter", "J.K. Rowling", "1234", 500, 3);
        Book b2 = new Book("Clean Code", "Robert Martin", "5678", 700, 2);
        myLibrary.addBook(b1);
        myLibrary.addBook(b2);

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Calculate Total Value");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine(); // consume newline
                    Book newBook = new Book(title, author, isbn, price, qty);
                    myLibrary.addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter Title or Author to search: ");
                    String keyword = sc.nextLine();
                    myLibrary.searchBook(keyword);
                    break;
                case 3:
                    myLibrary.displayInventory();
                    break;
                case 4:
                    myLibrary.calculateTotalValue();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
