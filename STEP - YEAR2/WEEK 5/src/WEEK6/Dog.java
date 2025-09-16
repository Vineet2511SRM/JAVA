package WEEK6;

public class Dog extends Mammal {
    // TODO: Dog-specific fields
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    // Constructor 1: Basic dog
    public Dog(String breed) {
        super("Dog", "Domestic", 13, false, "Brown", 60);
        this.breed = breed;
        this.isDomesticated = true;
        this.loyaltyLevel = 8;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating " + breed + " dog (basic)");
    }

    // Constructor 2: Detailed dog
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog (detailed)");
    }

    // Constructor 3: Copy constructor
    public Dog(Dog otherDog) {
        this(otherDog.species, otherDog.habitat, otherDog.lifespan, otherDog.isWildlife,
                otherDog.furColor, otherDog.gestationPeriod,
                otherDog.breed, otherDog.isDomesticated, otherDog.loyaltyLevel, otherDog.favoriteActivity);
        System.out.println("Dog constructor: Copying " + otherDog.breed + " dog");
    }

    // Override methods
    @Override
    public void eat() {
        super.eat();
        System.out.println("Wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    // Dog-specific methods
    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Loyalty level: " + loyaltyLevel + "/10");
    }

    public void demonstrateInheritance() {
        System.out.println("\n--- Demonstrating Inheritance ---");
        super.move();
        super.nurse();
        super.regulateTemperature();
        super.eat();
        this.eat();
        this.bark();
        this.fetch();
    }

    public String getBreed() { return breed; }
}
