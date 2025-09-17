package WEEK6.LAB;

// ==========================
// LAB PROBLEM 4: Color Hierarchy Chain
// Topic: Multilevel Inheritance


// Base class
class Color {
    // Field for color name
    protected String name;

    // Constructor for Color
    public Color(String name) {
        this.name = name; // initialize name
        // Print statement to show constructor chaining
        System.out.println("Color constructor called: name = " + name);
    }

    // Method to display color name
    public void showColor() {
        System.out.println("Color Name: " + name);
    }
}

// Intermediate class - PrimaryColor inherits from Color
class PrimaryColor extends Color {
    // Field for intensity of the color
    protected int intensity;

    // Constructor for PrimaryColor
    public PrimaryColor(String name, int intensity) {
        super(name); // call Color constructor (constructor chaining)
        this.intensity = intensity; // initialize intensity
        System.out.println("PrimaryColor constructor called: intensity = " + intensity);
    }

    // Method to display primary color details
    public void showPrimaryColor() {
        System.out.println("Primary Color Name: " + name + ", Intensity: " + intensity);
    }
}

// Leaf class - RedColor inherits from PrimaryColor
class RedColor extends PrimaryColor {
    // Field for shade of red
    private String shade;

    // Constructor for RedColor
    public RedColor(String name, int intensity, String shade) {
        super(name, intensity); // call PrimaryColor constructor
        this.shade = shade; // initialize shade
        System.out.println("RedColor constructor called: shade = " + shade);
    }

    // Method to display full red color details
    public void showRedColor() {
        System.out.println("Red Color Name: " + name +
                ", Intensity: " + intensity +
                ", Shade: " + shade);
    }
}

// Main class to test multilevel inheritance
public class LabProblem4 {
    public static void main(String[] args) {
        System.out.println("=== Multilevel Inheritance Demo ===\n");

        // Create RedColor object
        // This triggers constructor chaining:
        // 1. Color constructor → 2. PrimaryColor constructor → 3. RedColor constructor
        RedColor red = new RedColor("Red", 80, "Crimson");

        System.out.println("\n--- Displaying properties ---");
        red.showRedColor(); // show all properties of RedColor object
    }
}
