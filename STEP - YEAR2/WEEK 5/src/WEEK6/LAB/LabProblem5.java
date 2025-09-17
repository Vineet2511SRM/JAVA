package WEEK6.LAB;

// ==========================
// LAB PROBLEM 5: Musical Instrument Family
// Topic: Hierarchical Inheritance

// Base class
class Instrument {
    protected String name;      // Instrument name
    protected String material;  // Material of instrument

    // Constructor
    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
        System.out.println("Instrument constructor called: " + name);
    }

    // Method to display basic instrument info
    public void displayInfo() {
        System.out.println("Instrument Name: " + name);
        System.out.println("Material: " + material);
    }
}

// Child class 1 - Piano
class Piano extends Instrument {
    private int keys;  // Number of keys

    public Piano(String name, String material, int keys) {
        super(name, material); // Call Instrument constructor
        this.keys = keys;
        System.out.println("Piano constructor called: Keys = " + keys);
    }

    public void play() {
        System.out.println(name + " is being played with " + keys + " keys!");
    }
}

// Child class 2 - Guitar
class Guitar extends Instrument {
    private int strings; // Number of strings

    public Guitar(String name, String material, int strings) {
        super(name, material); // Call Instrument constructor
        this.strings = strings;
        System.out.println("Guitar constructor called: Strings = " + strings);
    }

    public void play() {
        System.out.println(name + " is being strummed with " + strings + " strings!");
    }
}

// Child class 3 - Drum
class Drum extends Instrument {
    private String drumType; // e.g., Bass, Snare

    public Drum(String name, String material, String drumType) {
        super(name, material); // Call Instrument constructor
        this.drumType = drumType;
        System.out.println("Drum constructor called: Type = " + drumType);
    }

    public void play() {
        System.out.println(name + " is being played as a " + drumType + " drum!");
    }
}

// Main class to test hierarchical inheritance
public class LabProblem5 {
    public static void main(String[] args) {
        System.out.println("=== Musical Instrument Family Demo ===\n");

        // Array of Instrument references (polymorphism)
        Instrument[] instruments = new Instrument[3];

        instruments[0] = new Piano("Grand Piano", "Wood", 88);
        instruments[1] = new Guitar("Acoustic Guitar", "Wood", 6);
        instruments[2] = new Drum("Bass Drum", "Metal", "Bass");

        System.out.println("\n--- Testing polymorphic behavior ---");
        for (Instrument inst : instruments) {
            inst.displayInfo(); // show base info

            // Check actual object type and call specific play method
            if (inst instanceof Piano) {
                ((Piano) inst).play();
            } else if (inst instanceof Guitar) {
                ((Guitar) inst).play();
            } else if (inst instanceof Drum) {
                ((Drum) inst).play();
            }

            System.out.println(); // blank line for readability
        }
    }
}
