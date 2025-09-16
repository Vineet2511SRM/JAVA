package kingdom;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;
    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;

    static final int MIN_MAGIC_POWER = 0;
    static final int MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "1.0";

    public MagicalStructure(String name, String location) {
        this(name, location, 50, true);
    }

    public MagicalStructure(String name, String location, int power) {
        this(name, location, power, true);
    }

    public MagicalStructure(String name, String location, int power, boolean active) {
        if (name == null || location == null) throw new IllegalArgumentException("Name and location are required.");
        this.structureId = "MS-" + UUID.randomUUID().toString().substring(0, 8);
        this.constructionTimestamp = Instant.now().toEpochMilli();
        this.structureName = name;
        this.location = location;
        this.setMagicPower(power);
        this.setActive(active);
        this.currentMaintainer = "None";
    }

    public String getStructureId() { return structureId; }
    public long getConstructionTimestamp() { return constructionTimestamp; }
    public String getStructureName() { return structureName; }
    public String getLocation() { return location; }
    public int getMagicPower() { return magicPower; }
    public boolean isActive() { return isActive; }
    public String getCurrentMaintainer() { return currentMaintainer; }

    public void setMagicPower(int magicPower) {
        if (magicPower < MIN_MAGIC_POWER || magicPower > MAX_MAGIC_POWER) {
            throw new IllegalArgumentException("Magic power out of range.");
        }
        this.magicPower = magicPower;
    }

    public void setActive(boolean active) { this.isActive = active; }
    public void setCurrentMaintainer(String currentMaintainer) { this.currentMaintainer = currentMaintainer; }

    @Override
    public String toString() { return String.format("%s at %s", structureName, location); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MagicalStructure)) return false;
        return structureId.equals(((MagicalStructure) o).structureId);
    }

    @Override
    public int hashCode() { return Objects.hash(structureId); }
}
