package petsimulator;

import java.util.Arrays;
import java.util.Objects;

public final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
        if (speciesName == null || speciesName.trim().isEmpty()) {
            throw new IllegalArgumentException("Species name cannot be null or empty.");
        }
        if (evolutionStages == null || evolutionStages.length == 0) {
            throw new IllegalArgumentException("Evolution stages must be provided.");
        }
        if (maxLifespan <= 0) {
            throw new IllegalArgumentException("Max lifespan must be positive.");
        }
        this.speciesName = speciesName;
        this.evolutionStages = Arrays.copyOf(evolutionStages, evolutionStages.length);
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() { return speciesName; }
    public String[] getEvolutionStages() { return Arrays.copyOf(evolutionStages, evolutionStages.length); }
    public int getMaxLifespan() { return maxLifespan; }
    public String getHabitat() { return habitat; }

    @Override
    public String toString() {
        return "PetSpecies{speciesName='" + speciesName + "', maxLifespan=" + maxLifespan + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetSpecies)) return false;
        PetSpecies that = (PetSpecies) o;
        return speciesName.equals(that.speciesName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speciesName);
    }
}
