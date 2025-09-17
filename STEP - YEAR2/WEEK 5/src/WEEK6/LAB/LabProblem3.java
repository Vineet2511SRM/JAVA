package WEEK6.LAB;

// Base Bird class
class Bird {
    protected String name;

    public Bird(String name) {
        this.name = name;
    }

    // Method to be overridden by subclasses
    public void fly() {
        System.out.println(name + " is flying");
    }
}

// Penguin class - cannot fly
class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " is a penguin and cannot fly, but can swim!");
    }
}

// Eagle class - excellent flyer
class Eagle extends Bird {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " soars high in the sky with powerful wings!");
    }
}

// Main class to test polymorphism
public class LabProblem3 {
    public static void main(String[] args) {
        System.out.println("=== Bird Flying Behavior Demo ===\n");

        // Array of Bird references (polymorphism)
        Bird[] birds = {
                new Eagle("Golden Eagle"),
                new Penguin("Emperor Penguin"),
                new Bird("Generic Bird")
        };

        // Test polymorphism
        for (Bird bird : birds) {
            bird.fly(); // runtime polymorphism decides which fly() to run
        }
    }
}
