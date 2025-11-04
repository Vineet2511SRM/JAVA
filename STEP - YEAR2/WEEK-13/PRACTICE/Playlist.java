import java.util.Scanner;

class Playlist {
    Node head; // Head of the linked list

    // Inner Node class
    class Node {
        String song;
        Node next;
        Node(String s) {
            song = s;
            next = null;
        }
    }

    // Add song to the end of playlist
    public void addSong(String song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode; // first song
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next; // move to last node
        }
        temp.next = newNode; // link new node at end
    }

    // Remove first song (play next)
    public void playNext() {
        if (head == null) {
            System.out.println("No songs to play!");
            return;
        }
        System.out.println("Playing: " + head.song);
        head = head.next; // Move head to next node (deletion)
    }

    // Display all songs in playlist
    public void showPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Playlist: ");
        while (temp != null) {
            System.out.print(temp.song);
            if (temp.next != null)
                System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to handle commands
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist p = new Playlist();

        while (true) {
            System.out.print("Command (ADD <song>/PLAYNEXT/SHOW/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ADD")) {
                String song = sc.next(); // read next word as song title
                p.addSong(song);
            } 
            else if (cmd.equalsIgnoreCase("PLAYNEXT")) {
                p.playNext();
            } 
            else if (cmd.equalsIgnoreCase("SHOW")) {
                p.showPlaylist();
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting Playlist Manager...");
                break;
            } 
            else {
                System.out.println("Invalid command! Try again.");
            }
        }
        sc.close();
    }
}
