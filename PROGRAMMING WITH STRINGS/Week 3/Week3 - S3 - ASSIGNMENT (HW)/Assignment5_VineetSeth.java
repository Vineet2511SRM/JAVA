/**
 * Assignment5_LibraryManagement.java
 * Author: Vineet Seth
 * Description: Library Management System with member types (Student, Faculty, General),
 * book issue/return, fine calculation, and reporting.
 */

import java.util.*;

/**
 * Represents a book in the library.
 */
class Book {
    String bookId, title, author, isbn, category;
    boolean isIssued;
    int issueDate, dueDate;
    int timesIssued = 0; // For popularity tracking

    static int totalBooks = 0;

    Book(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        totalBooks++;
    }

    @Override
    public String toString() {
        return bookId + " - " + title + " (" + category + ") | Issued: " + isIssued;
    }
}

/**
 * Base class for a library member
 */
class Member {
    String memberId, memberName, memberType, membershipDate;
    Book[] booksIssued;
    double totalFines = 0;
    int maxBooksAllowed; // dynamic per member type

    static int totalMembers = 0;
    static String libraryName = "City Central Library";
    static double finePerDay = 2.0;

    public Member(String id, String name, String type, String date, int maxBooksAllowed) {
        this.memberId = id;
        this.memberName = name;
        this.memberType = type;
        this.membershipDate = date;
        this.maxBooksAllowed = maxBooksAllowed;
        this.booksIssued = new Book[maxBooksAllowed];
        totalMembers++;
    }

    public void issueBook(Book b, int issueDate, int dueDate) {
        try {
            if (b == null) throw new IllegalArgumentException("Book is null!");
            if (b.isIssued) throw new Exception("Book already issued!");

            for (int i = 0; i < booksIssued.length; i++) {
                if (booksIssued[i] == null) {
                    booksIssued[i] = b;
                    b.isIssued = true;
                    b.issueDate = issueDate;
                    b.dueDate = dueDate;
                    b.timesIssued++;
                    System.out.println(memberName + " issued " + b.title);
                    return;
                }
            }
            System.out.println("Cannot issue book. Limit reached for " + memberName);
        } catch (Exception e) {
            System.out.println("Issue error: " + e.getMessage());
        }
    }

    public void returnBook(Book b, int returnDate) {
        try {
            if (b == null) throw new IllegalArgumentException("Book is null!");

            for (int i = 0; i < booksIssued.length; i++) {
                if (booksIssued[i] == b) {
                    booksIssued[i] = null;
                    b.isIssued = false;
                    calculateFine(b, returnDate);
                    System.out.println(memberName + " returned " + b.title);
                    return;
                }
            }
            throw new Exception("Book not found in member record!");
        } catch (Exception e) {
            System.out.println("Return error: " + e.getMessage());
        }
    }

    private void calculateFine(Book b, int returnDate) {
        if (returnDate > b.dueDate) {
            int overdue = returnDate - b.dueDate;
            double fine = overdue * finePerDay;
            totalFines += fine;
            System.out.println("Fine for " + memberName + ": ₹" + fine);
        }
    }

    public void renewBook(Book b, int newDueDate) {
        if (b != null && b.isIssued) {
            b.dueDate = newDueDate;
            System.out.println("Book renewed: " + b.title + " till day " + newDueDate);
        }
    }

    public void reserveBook(Book b) {
        if (b == null) return;
        if (b.isIssued) {
            System.out.println("Book " + b.title + " reserved for " + memberName);
        } else {
            System.out.println("Book available, no need to reserve.");
        }
    }

    public void searchBooks(String keyword) {
        for (Book b : booksIssued) {
            if (b != null && (b.title.contains(keyword) || b.author.contains(keyword))) {
                System.out.println("Found: " + b);
            }
        }
    }
}

/**
 * Student member: can borrow up to 3 books
 */
class Student extends Member {
    public Student(String id, String name, String date) {
        super(id, name, "Student", date, 3);
    }
}

/**
 * Faculty member: can borrow up to 5 books
 */
class Faculty extends Member {
    public Faculty(String id, String name, String date) {
        super(id, name, "Faculty", date, 5);
    }
}

/**
 * General member: can borrow up to 2 books
 */
class General extends Member {
    public General(String id, String name, String date) {
        super(id, name, "General", date, 2);
    }
}

/**
 * Main class
 */
public class Assignment5_VineetSeth {
    public static void main(String[] args) {
        // Books
        Book b1 = new Book("B001", "Java Basics", "Herbert", "111", "Programming");
        Book b2 = new Book("B002", "DBMS Concepts", "Korth", "222", "Database");
        Book b3 = new Book("B003", "Networking", "Tanenbaum", "333", "CS");

        // Members
        Member m1 = new Student("M001", "Aarav", "2024-01-01");
        Member m2 = new Faculty("M002", "Riya", "2024-02-15");
        Member m3 = new General("M003", "Kabir", "2024-03-01");

        // Test flow
        m1.issueBook(b1, 1, 5);
        m1.issueBook(b2, 2, 7);
        m2.issueBook(b3, 3, 10);

        m1.returnBook(b1, 8); // fine applied
        m2.renewBook(b3, 15);

        // Reserve a book
        m1.reserveBook(b3); // b3 is issued by m2, so m1 reserves it
        m3.reserveBook(b2); // b2 is returned, should print "available"

        // Reports
        generateLibraryReport(new Book[]{b1, b2, b3}, new Member[]{m1, m2, m3});
        getOverdueBooks(new Book[]{b1, b2, b3}, 12);
        getMostPopularBooks(new Book[]{b1, b2, b3});
    }

    public static void generateLibraryReport(Book[] books, Member[] members) {
        System.out.println("\n--- Library Report ---");
        System.out.println("Library: " + Member.libraryName);
        System.out.println("Total Books: " + Book.totalBooks);
        System.out.println("Total Members: " + Member.totalMembers);
        for (Member m : members) {
            System.out.println(m.memberName + " (" + m.memberType + ") | Fines: ₹" + m.totalFines);
        }
    }

    public static void getOverdueBooks(Book[] books, int currentDate) {
        System.out.println("\n--- Overdue Books ---");
        for (Book b : books) {
            if (b.isIssued && currentDate > b.dueDate) {
                System.out.println(b.title + " overdue since day " + b.dueDate);
            }
        }
    }

    public static void getMostPopularBooks(Book[] books) {
        System.out.println("\n--- Popular Books ---");
        Arrays.sort(books, (x, y) -> y.timesIssued - x.timesIssued);
        for (Book b : books) {
            System.out.println(b.title + " issued " + b.timesIssued + " times");
        }
    }
}
