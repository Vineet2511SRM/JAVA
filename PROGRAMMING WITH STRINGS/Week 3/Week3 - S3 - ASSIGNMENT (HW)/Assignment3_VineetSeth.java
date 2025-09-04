/**
 * Assignment3_VineetSeth.java
 * Author: Vineet Seth
 * Description: A student-style Hotel Reservation System demonstrating
 * multiple classes (Room, Guest, Booking), encapsulation, static vs instance members,
 * exception handling, Javadoc comments, and a complete booking workflow
 * from room search to checkout. (No HashMap used.)
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hotel room.
 */
class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    /**
     * Constructs a Room.
     *
     * @param roomNumber   unique room number (non-null/non-empty)
     * @param roomType     type like "Single", "Double", "Suite"
     * @param pricePerNight price per night (must be >= 0)
     * @param maxOccupancy maximum number of guests allowed (must be > 0)
     * @throws IllegalArgumentException if inputs are invalid
     */
    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        if (roomNumber == null || roomNumber.isEmpty())
            throw new IllegalArgumentException("roomNumber cannot be empty");
        if (roomType == null || roomType.isEmpty())
            throw new IllegalArgumentException("roomType cannot be empty");
        if (pricePerNight < 0)
            throw new IllegalArgumentException("pricePerNight cannot be negative");
        if (maxOccupancy <= 0)
            throw new IllegalArgumentException("maxOccupancy must be positive");

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.maxOccupancy = maxOccupancy;
        this.isAvailable = true; // default available
    }

    /** @return unique room number */
    public String getRoomNumber() { return roomNumber; }

    /** @return room type label */
    public String getRoomType() { return roomType; }

    /** @return price per night */
    public double getPricePerNight() { return pricePerNight; }

    /** @return whether room is currently available */
    public boolean isAvailable() { return isAvailable; }

    /**
     * Sets availability flag.
     * @param available true if available
     */
    public void setAvailable(boolean available) { this.isAvailable = available; }

    /** @return maximum occupancy */
    public int getMaxOccupancy() { return maxOccupancy; }
}

/**
 * Represents a hotel guest.
 */
class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;

    // Booking history as a fixed-size String array as per requirement
    private String[] bookingHistory; // stores booking IDs
    private int historyCount;        // number of entries used

    /**
     * Constructs a Guest.
     *
     * @param guestId     unique id (non-empty)
     * @param guestName   guest full name (non-empty)
     * @param phoneNumber simple numeric phone check (10-15 digits recommended)
     * @param email       simple email contains '@' check
     * @throws IllegalArgumentException if inputs are invalid
     */
    public Guest(String guestId, String guestName, String phoneNumber, String email) {
        if (guestId == null || guestId.isEmpty())
            throw new IllegalArgumentException("guestId cannot be empty");
        if (guestName == null || guestName.isEmpty())
            throw new IllegalArgumentException("guestName cannot be empty");
        if (phoneNumber == null || !phoneNumber.matches("\\d{10,15}"))
            throw new IllegalArgumentException("phoneNumber must be 10-15 digits");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("email seems invalid");

        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String[20]; // capacity for 20 bookings per guest
        this.historyCount = 0;
    }

    /** @return guest name */
    public String getGuestName() { return guestName; }

    /** @return guest id */
    public String getGuestId() { return guestId; }

    /**
     * Adds a booking id to history. If full, the oldest entry is dropped (simple shift).
     * @param bookingId booking id string
     */
    public void addBookingToHistory(String bookingId) {
        if (bookingId == null || bookingId.isEmpty()) return;
        if (historyCount < bookingHistory.length) {
            bookingHistory[historyCount++] = bookingId;
        } else {
            // shift left to keep the latest 20
            for (int i = 1; i < bookingHistory.length; i++) {
                bookingHistory[i - 1] = bookingHistory[i];
            }
            bookingHistory[bookingHistory.length - 1] = bookingId;
        }
    }

    /**
     * @return a snapshot array of booking IDs (trimmed to current size)
     */
    public String[] getBookingHistory() {
        String[] copy = new String[historyCount];
        for (int i = 0; i < historyCount; i++) copy[i] = bookingHistory[i];
        return copy;
    }
}

/**
 * Represents a booking. Also carries static, hotel-wide reporting.
 */
class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    // ----- Hotel-wide static variables -----
    private static int totalBookings = 0;
    private static double hotelRevenue = 0.0;
    private static String hotelName = "Vineet Residency";

    // Collections for reporting (no HashMap used)
    private static final List<Room> allRooms = new ArrayList<>();
    private static final List<Booking> allBookings = new ArrayList<>();

    /**
     * Constructs a Booking object. Use makeReservation(...) to create bookings safely.
     *
     * @param bookingId   unique booking id
     * @param guest       non-null guest
     * @param room        non-null room (should be marked unavailable by caller)
     * @param checkInDate check-in date string
     * @param checkOutDate check-out date string
     * @param totalAmount computed total amount
     */
    private Booking(String bookingId, Guest guest, Room room,
                    String checkInDate, String checkOutDate, double totalAmount) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;

        totalBookings++;
        hotelRevenue += totalAmount;
        allBookings.add(this);
    }

    // ---------------- Reservation Management ----------------

    /**
     * Attempts to create a reservation if inputs are valid and room is available.
     *
     * @param bookingId   unique id for the booking
     * @param guest       guest object (must not be null)
     * @param room        room object (must not be null & available)
     * @param checkInDate check-in date string
     * @param checkOutDate check-out date string
     * @param nights      number of nights (must be > 0)
     * @return Booking instance on success, otherwise null (when room not available)
     * @throws IllegalArgumentException if guest/room is null or nights <= 0
     */
    public static Booking makeReservation(String bookingId, Guest guest, Room room,
                                          String checkInDate, String checkOutDate, int nights) {
        if (guest == null || room == null) {
            throw new IllegalArgumentException("Guest and Room cannot be null");
        }
        if (nights <= 0) {
            throw new IllegalArgumentException("Number of nights must be positive");
        }
        if (!room.isAvailable()) {
            System.out.println("[X] Room " + room.getRoomNumber() + " is not available!");
            return null;
        }

        double total = nights * room.getPricePerNight();
        room.setAvailable(false); // block the room

        Booking booking = new Booking(bookingId, guest, room, checkInDate, checkOutDate, total);
        guest.addBookingToHistory(bookingId);

        System.out.println("[OK] Booking Successful -> ID: " + bookingId +
                ", Guest: " + guest.getGuestName() + ", Room: " + room.getRoomNumber());
        return booking;
    }

    /**
     * Cancels this reservation and frees the room.
     */
    public void cancelReservation() {
        room.setAvailable(true);
        System.out.println("[!] Booking " + bookingId + " cancelled for guest: " + guest.getGuestName());
    }

    /**
     * Checks whether a room is currently available.
     * @param room room to check
     * @return true if available, false otherwise
     * @throws IllegalArgumentException if room is null
     */
    public static boolean checkAvailability(Room room) {
        if (room == null) throw new IllegalArgumentException("room cannot be null");
        return room.isAvailable();
    }

    /**
     * Calculates the bill (for this booking).
     * @return total amount for this booking
     */
    public double calculateBill() { return totalAmount; }

    /**
     * Performs a simple checkout: frees the room and returns the bill.
     * @return total payable amount at checkout
     */
    public double checkout() {
        room.setAvailable(true);
        System.out.println("[>] Checkout complete for booking " + bookingId + ". Room freed.");
        return totalAmount;
    }

    // ---------------- Static Reporting ----------------

    /**
     * Registers a room into the hotel inventory for reporting.
     * @param r room to add
     */
    public static void registerRoom(Room r) {
        if (r != null) allRooms.add(r);
    }

    /**
     * @return total number of bookings ever made
     */
    public static int getTotalBookings() { return totalBookings; }

    /**
     * @return total revenue earned by hotel
     */
    public static double getTotalRevenue() { return hotelRevenue; }

    /**
     * @return hotel name (static)
     */
    public static String getHotelName() { return hotelName; }

    /**
     * Computes occupancy rate as percentage of rooms currently occupied.
     *
     * @return occupancy rate in percentage (0-100)
     */
    public static double getOccupancyRate() {
        if (allRooms.isEmpty()) return 0.0;
        int occupied = 0;
        for (Room r : allRooms) {
            if (!r.isAvailable()) occupied++;
        }
        return (occupied * 100.0) / allRooms.size();
    }

    public static String getMostPopularRoomType() {
        if (allBookings.isEmpty()) return "No bookings yet";

        // Collect unique types into arrays and count occurrences
        String[] types = new String[allBookings.size()];
        int[] counts = new int[allBookings.size()];
        int unique = 0;

        for (Booking b : allBookings) {
            String type = b.room.getRoomType();
            int idx = -1;
            for (int i = 0; i < unique; i++) {
                if (types[i].equals(type)) { idx = i; break; }
            }
            if (idx == -1) {
                types[unique] = type;
                counts[unique] = 1;
                unique++;
            } else {
                counts[idx]++;
            }
        }

        // find max
        int maxIndex = 0;
        for (int i = 1; i < unique; i++) {
            if (counts[i] > counts[maxIndex]) maxIndex = i;
        }
        return types[maxIndex];
    }
}

public class Assignment3_VineetSeth {
    public static List<Room> searchRooms(List<Room> inventory, String desiredType, int minCapacity) {
        List<Room> result = new ArrayList<>();
        for (Room r : inventory) {
            if (r.isAvailable() && r.getRoomType().equalsIgnoreCase(desiredType)
                    && r.getMaxOccupancy() >= minCapacity) {
                result.add(r);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // ----- Setup Rooms -----
        Room r1 = new Room("101", "Single", 1500, 1);
        Room r2 = new Room("102", "Double", 2500, 2);
        Room r3 = new Room("201", "Suite", 5000, 4);
        Room r4 = new Room("202", "Double", 2600, 2);

        // Register inventory for reporting
        Booking.registerRoom(r1);
        Booking.registerRoom(r2);
        Booking.registerRoom(r3);
        Booking.registerRoom(r4);

        // Keep a local list for searching
        List<Room> inventory = new ArrayList<>();
        inventory.add(r1); inventory.add(r2); inventory.add(r3); inventory.add(r4);

        // ----- Setup Guests -----
        Guest g1 = new Guest("G01", "Aarav Sharma", "9876543210", "aarav@mail.com");
        Guest g2 = new Guest("G02", "Riya Verma", "9123456789", "riya@mail.com");

        // ----- Search Flow: find available Doubles for 2 people -----
        System.out.println("\n[Search] Need a 'Double' for 2 people:");
        List<Room> found = searchRooms(inventory, "Double", 2);
        for (Room r : found) {
            System.out.println("    -> Room " + r.getRoomNumber() + " (" + r.getRoomType() + ") ₹" + r.getPricePerNight());
        }

        // ----- Booking Flow -----
        Booking b1 = null;
        try {
            b1 = Booking.makeReservation("B001", g1, r2, "2025-09-05", "2025-09-07", 2);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error making reservation: " + ex.getMessage());
        }

        // Try an invalid booking (nights <= 0) to show error handling
        try {
            Booking.makeReservation("B_BAD", g2, r3, "2025-09-05", "2025-09-04", 0);
        } catch (IllegalArgumentException ex) {
            System.out.println("[Handled] Invalid reservation attempt -> " + ex.getMessage());
        }

        // Attempt to double-book the same room (should print not available)
        try {
            Booking.makeReservation("B002", g2, r2, "2025-09-05", "2025-09-06", 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // Book another available room
        Booking b3 = Booking.makeReservation("B003", g2, r4, "2025-09-06", "2025-09-08", 2);

        // ----- Availability Check -----
        System.out.println("Room 102 available? " + Booking.checkAvailability(r2));
        System.out.println("Room 201 available? " + Booking.checkAvailability(r3));

        // ----- Cancellation Flow -----
        if (b3 != null) {
            b3.cancelReservation(); // frees r4
        }

        // ----- Checkout Flow -----
        if (b1 != null) {
            double bill = b1.checkout();
            System.out.println("Bill for " + g1.getGuestName() + ": ₹" + bill);
        }

        // ----- Histories -----
        System.out.println("\n[Histories]");
        printHistory(g1);
        printHistory(g2);

        // ----- Reports -----
        System.out.println("\n[Hotel Reports]");
        System.out.println("Hotel Name: " + Booking.getHotelName());
        System.out.println("Total Bookings: " + Booking.getTotalBookings());
        System.out.println("Total Revenue: ₹" + Booking.getTotalRevenue());
        System.out.println("Current Occupancy Rate: " + String.format("%.2f", Booking.getOccupancyRate()) + "%");
        System.out.println("Most Popular Room Type: " + Booking.getMostPopularRoomType());
    }

    /** Utility to print guest booking history nicely. */
    private static void printHistory(Guest g) {
        String[] history = g.getBookingHistory();
        System.out.print(g.getGuestName() + " -> ");
        if (history.length == 0) {
            System.out.println("No bookings yet");
        } else {
            for (int i = 0; i < history.length; i++) {
                System.out.print(history[i]);
                if (i < history.length - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
