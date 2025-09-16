package petsimulator;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class VirtualPet {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;
    private String petName;
    private int age;
    private int happiness;
    private int health;
    private String currentEvolutionStage;

    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Baby", "Teen", "Adult"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    public VirtualPet() { this("Unnamed Pet"); }
    public VirtualPet(String petName) { this(petName, new PetSpecies("Common Creature", DEFAULT_EVOLUTION_STAGES, 10, "Forest")); }
    public VirtualPet(String petName, PetSpecies species) { this(petName, species, 1, 70, 80); }

    public VirtualPet(String petName, PetSpecies species, int age, int happiness, int health) {
        if (petName == null || petName.trim().isEmpty()) throw new IllegalArgumentException("Pet name cannot be null or empty.");
        if (species == null) throw new IllegalArgumentException("Species cannot be null.");

        this.petId = generatePetId();
        this.species = species;
        this.birthTimestamp = Instant.now().toEpochMilli();
        this.setPetName(petName);
        this.setAge(age);
        this.setHappiness(happiness);
        this.setHealth(health);
        this.checkEvolution();
    }

    private void validateStat(int value, int max, String statName) {
        if (value < 0 || value > max) throw new IllegalArgumentException(statName + " must be between 0 and " + max);
    }

    private String generatePetId() {
        return "VP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private void checkEvolution() {
        String[] stages = this.species.getEvolutionStages();
        if (this.age > stages.length * 5) {
            this.currentEvolutionStage = stages[stages.length - 1];
        } else if (this.age > stages.length * 2) {
            this.currentEvolutionStage = stages.length > 1 ? stages[1] : stages[0];
        } else {
            this.currentEvolutionStage = stages[0];
        }
    }

    public void feedPet(String foodType) {
        int bonus = calculateFoodBonus(foodType);
        modifyHealth(bonus);
        modifyHappiness(bonus / 2);
    }

    public void playWithPet(String gameType) {
        int effect = calculateGameEffect(gameType);
        modifyHappiness(effect);
        modifyHealth(effect / 4);
    }

    protected int calculateFoodBonus(String foodType) { return foodType.equalsIgnoreCase("favorite") ? 20 : 10; }
    protected int calculateGameEffect(String gameType) { return gameType.equalsIgnoreCase("fetch") ? 15 : 5; }

    private void modifyHappiness(int amount) { this.happiness = Math.min(MAX_HAPPINESS, Math.max(0, this.happiness + amount)); }
    private void modifyHealth(int amount) { this.health = Math.min(MAX_HEALTH, Math.max(0, this.health + amount)); }
    private void updateEvolutionStage() { checkEvolution(); }

    String getInternalState() {
        return String.format("ID: %s, Name: %s, Age: %d, HP: %d/%d, Happy: %d/%d",
                petId, petName, age, health, MAX_HEALTH, happiness, MAX_HAPPINESS);
    }

    public String getPetId() { return petId; }
    public PetSpecies getSpecies() { return species; }
    public long getBirthTimestamp() { return birthTimestamp; }
    public String getPetName() { return petName; }
    public int getAge() { return age; }
    public int getHappiness() { return happiness; }
    public int getHealth() { return health; }
    public String getCurrentEvolutionStage() { return currentEvolutionStage; }
    public void setPetName(String petName) { this.petName = petName; }

    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be positive.");
        this.age = age;
        updateEvolutionStage();
    }

    public void setHappiness(int happiness) {
        validateStat(happiness, MAX_HAPPINESS, "Happiness");
        this.happiness = happiness;
    }

    public void setHealth(int health) {
        validateStat(health, MAX_HEALTH, "Health");
        this.health = health;
    }

    @Override
    public String toString() { return String.format("%s the %s (%s)", petName, species.getSpeciesName(), currentEvolutionStage); }

    @Override
    public boolean equals(Object o) { return this == o || (o instanceof VirtualPet that && petId.equals(that.petId)); }
    @Override
    public int hashCode() { return Objects.hash(petId); }
}
