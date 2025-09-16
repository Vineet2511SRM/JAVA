package WEEK6;

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("--- Testing Multilevel Inheritance ---\n");

        // 1️⃣ Test constructor chaining
        System.out.println("--- Creating Basic Dog ---");
        Dog basicDog = new Dog("Beagle"); // Uses basic constructor
        System.out.println();

        System.out.println("--- Creating Detailed Dog ---");
        Dog detailedDog = new Dog(
                "Canine", "Backyard", 12, true,
                "Golden", 65, "Golden Retriever", true, 10, "Swimming"
        ); // Uses detailed constructor
        System.out.println();

        System.out.println("--- Creating Copied Dog ---");
        Dog copiedDog = new Dog(detailedDog); // Copy constructor
        System.out.println();

        // 2️⃣ Test method overriding across levels
        System.out.println("--- Method Overriding Test ---");
        basicDog.eat();   // Dog overrides eat(), also calls Animal.eat()
        basicDog.move();  // Dog overrides move()
        basicDog.sleep(); // Dog overrides sleep()
        basicDog.bark();  // Dog-specific
        basicDog.fetch(); // Dog-specific
        System.out.println();

        // 3️⃣ Access inherited members
        System.out.println("--- Accessing Inherited Fields ---");
        System.out.println("Species: " + basicDog.species); // Animal
        System.out.println("Habitat: " + basicDog.habitat); // Animal
        System.out.println("Fur Color: " + basicDog.furColor); // Mammal
        System.out.println("Warm-blooded? " + basicDog.hasWarmBlood); // Mammal
        System.out.println();

        // 4️⃣ Demonstrate super calls and chain
        System.out.println("--- Demonstrate Inheritance Chain ---");
        basicDog.demonstrateInheritance(); // Calls Animal, Mammal, Dog methods
        System.out.println();

        // 5️⃣ instanceof tests
        System.out.println("--- instanceof Checks ---");
        System.out.println("basicDog instanceof Dog: " + (basicDog instanceof Dog));
        System.out.println("basicDog instanceof Mammal: " + (basicDog instanceof Mammal));
        System.out.println("basicDog instanceof Animal: " + (basicDog instanceof Animal));
        System.out.println();

        // 6️⃣ Create multiple Dog objects with different constructor patterns
        System.out.println("--- Multiple Dog Objects ---");
        Dog dog1 = new Dog("Poodle");
        Dog dog2 = new Dog(detailedDog);
        Dog dog3 = new Dog(
                "Canine", "Farm", 14, true,
                "Black", 63, "Labrador", true, 9, "Running"
        );

        System.out.println("dog1 breed: " + dog1.getBreed());
        System.out.println("dog2 breed: " + dog2.getBreed());
        System.out.println("dog3 breed: " + dog3.getBreed());

        System.out.println("\n--- Constructor Chaining and Inheritance Test Complete ---");
    }
}
