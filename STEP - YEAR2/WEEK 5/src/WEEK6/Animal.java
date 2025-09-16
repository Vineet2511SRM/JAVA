package WEEK6;

public class Animal {
    // TODO: Create protected fields:
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    // Constructor
    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    // Methods
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return String.format("Species: %s, Habitat: %s, Lifespan: %d, Wildlife: %b",
                species, habitat, lifespan, isWildlife);
    }
}
