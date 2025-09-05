/**
 * Program Name: LabProblem1_VirtualPetSimulator.java
 * Author: Vineet Seth
 * Description: A Tamagotchi-style Virtual Pet Evolution Simulator
 * demonstrating constructor overloading, this() chaining,
 * use of final, static members, exception handling, and custom methods.
 */

import java.util.*;

class VirtualPet {
    // ------------------ Fields ------------------
    private final String petId; // unique ID, final once set
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private int evolutionStageIndex;

    // Static members
    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder", "Ghost"};
    static int totalPetsCreated = 0;

    // ------------------ Constructors ------------------

    // Default constructor (mysterious egg)
    public VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, 0);
    }

    // Constructor with name only (starts as baby)
    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 0, 60, 60, 1);
    }

    // Constructor with name and species (starts as child)
    public VirtualPet(String petName, String species) {
        this(petName, species, 1, 70, 70, 2);
    }

    // Main Constructor
    public VirtualPet(String petName, String species, int age, int happiness, int health, int stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStageIndex = stage;
        totalPetsCreated++;
    }

    // ------------------ Unique Methods ------------------

    // Generate unique ID
    public static String generatePetId() {
        return "PET-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
    }

    // Random species generator
    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Kitten", "Puppy"};
        Random rand = new Random();
        return speciesList[rand.nextInt(speciesList.length)];
    }

    // Feed Pet
    public void feedPet() {
        if (isAlive()) {
            health += 10;
            happiness += 5;
            System.out.println(petName + " enjoyed the food!");
        } else {
            System.out.println(petName + " is a ghost and cannot eat!");
        }
    }

    // Play with Pet
    public void playWithPet() {
        if (isAlive()) {
            happiness += 15;
            health -= 5;
            System.out.println(petName + " had fun playing!");
        } else {
            System.out.println(petName + " is haunting you instead!");
        }
    }

    // Heal Pet
    public void healPet() {
        if (isAlive()) {
            health += 20;
            System.out.println(petName + " feels better!");
        } else {
            System.out.println(petName + " is a ghost... medicine has no effect!");
        }
    }

    // Simulate a day
    public void simulateDay() {
        if (isAlive()) {
            age++;
            Random rand = new Random();
            health -= rand.nextInt(10);
            happiness -= rand.nextInt(10);
            evolvePet();

            if (health <= 0) {
                System.out.println(petName + " has died and become a ghost...");
                evolutionStageIndex = 6; // Ghost stage
            }
        } else {
            System.out.println(petName + " is roaming as a ghost today...");
        }
    }

    // Evolve Pet
    private void evolvePet() {
        if (isAlive() && evolutionStageIndex < 5) {
            if (age >= 2 && evolutionStageIndex == 1) evolutionStageIndex = 2;
            else if (age >= 4 && evolutionStageIndex == 2) evolutionStageIndex = 3;
            else if (age >= 6 && evolutionStageIndex == 3) evolutionStageIndex = 4;
            else if (age >= 8 && evolutionStageIndex == 4) evolutionStageIndex = 5;
        }
    }

    // Status
    public String getPetStatus() {
        return String.format("[%s] Name: %s | Species: %s | Age: %d | Health: %d | Happiness: %d | Stage: %s",
                petId, petName, species, age, health, happiness, EVOLUTION_STAGES[evolutionStageIndex]);
    }

    // Alive check
    private boolean isAlive() {
        return evolutionStageIndex != 6; // Not Ghost
    }
}

// ------------------ Main Class ------------------

public class LabProblem1_VirtualPetSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<VirtualPet> daycare = new ArrayList<>();

        try {
            // Create some pets
            daycare.add(new VirtualPet()); // Egg
            daycare.add(new VirtualPet("Luna")); // Baby
            daycare.add(new VirtualPet("Blaze", "Dragon")); // Child
            daycare.add(new VirtualPet("Shadow", "Phoenix", 3, 80, 80, 2)); // Full custom

            System.out.println("\n-- Welcome to Virtual Pet Daycare! --");
            for (VirtualPet pet : daycare) {
                System.out.println(pet.getPetStatus());
            }

            // Simulate 5 days
            for (int day = 1; day <= 5; day++) {
                System.out.println("\n----- Day " + day + " -----");
                for (VirtualPet pet : daycare) {
                    pet.simulateDay();
                    pet.feedPet();
                    pet.playWithPet();
                    System.out.println(pet.getPetStatus());
                }
            }

            System.out.println("\nTotal Pets Created: " + VirtualPet.totalPetsCreated);

        } catch (Exception e) {
            System.out.println("Error occurred in simulation: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
