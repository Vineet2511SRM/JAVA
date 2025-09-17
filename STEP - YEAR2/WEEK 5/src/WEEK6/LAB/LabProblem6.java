package WEEK6.LAB;

// ==========================
// LAB PROBLEM 6: Box and Gift Box Enhancement
// Topic: Using super in overridden methods


// Base class: Box
class Box {
    protected String content;

    // Constructor
    public Box(String content) {
        this.content = content;
        System.out.println("Box constructor called");
    }

    // Method to pack the box
    public void pack() {
        System.out.println("Packing the box with: " + content);
    }

    // Method to unpack the box
    public void unpack() {
        System.out.println("Unpacking the box containing: " + content);
    }
}

// Child class: GiftBox
class GiftBox extends Box {
    private String ribbonColor;

    // Constructor
    public GiftBox(String content, String ribbonColor) {
        super(content); // call Box constructor
        this.ribbonColor = ribbonColor;
        System.out.println("GiftBox constructor called");
    }

    // Overridden pack method with enhanced behavior
    @Override
    public void pack() {
        super.pack(); // call parent pack method first
        // Add gift-specific functionality AFTER the parent method (super call)

        System.out.println("Adding a " + ribbonColor + " ribbon to the gift box!");
    }
    // Overridden unpack method with enhanced behavior
    @Override
    public void unpack() {
        super.unpack(); // call parent unpack method first
        // Add gift-specific functionality AFTER the parent method (super call)
        System.out.println("Removing the " + ribbonColor + " ribbon carefully!");
    }
}

// Main class to test Box and GiftBox
public class LabProblem6 {
    public static void main(String[] args) {
        System.out.println("=== Box and GiftBox Demo ===\n");

        // Create a normal Box
        Box simpleBox = new Box("Books");
        System.out.println("\nSimple Box:");
        simpleBox.pack();
        simpleBox.unpack();

        // Create a GiftBox
        GiftBox giftBox = new GiftBox("Chocolates", "Red");
        System.out.println("\nGift Box:");
        giftBox.pack();    // demonstrates enhanced packing
        giftBox.unpack();  // demonstrates enhanced unpacking
    }
}
