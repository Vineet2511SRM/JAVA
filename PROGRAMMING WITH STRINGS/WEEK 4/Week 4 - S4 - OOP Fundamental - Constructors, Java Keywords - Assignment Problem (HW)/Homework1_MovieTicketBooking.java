/**
 * Program Name: Homework1_MovieTicketBooking.java
 * Author: Vineet Seth
 * Description: Movie Ticket Booking System demonstrating constructor overloading
 * and ticket printing.
 */

class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;

    // 1. Default constructor
    public MovieTicket() {
        this("Unknown", "PVR", 0, 200.0);
    }

    // 2. Constructor with movie name
    public MovieTicket(String movieName) {
        this(movieName, "PVR", 0, 200.0);
    }

    // 3. Constructor with movie name and seat number
    public MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200.0);
    }

    // 4. Full constructor
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Method to print ticket details
    public void printTicket() {
        System.out.println("----------- Movie Ticket -----------");
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat No.: " + seatNumber);
        System.out.println("Price: Rs " + price);
        System.out.println("-----------------------------------\n");
    }
}

// Main class
public class Homework1_MovieTicketBooking {
    public static void main(String[] args) {
        // Creating tickets with different constructors
        MovieTicket t1 = new MovieTicket(); // default
        MovieTicket t2 = new MovieTicket("Avengers: Endgame"); // movie only
        MovieTicket t3 = new MovieTicket("Spider-Man: No Way Home", 15); // movie + seat
        MovieTicket t4 = new MovieTicket("Inception", "INOX", 23, 350.0); // full constructor

        // Printing tickets
        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
