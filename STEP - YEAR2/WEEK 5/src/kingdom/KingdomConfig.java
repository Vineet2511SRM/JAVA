package kingdom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String, Integer> resourceLimits;

    public KingdomConfig(String kingdomName, int foundingYear, String[] allowedStructureTypes, Map<String, Integer> resourceLimits) {
        if (kingdomName == null || kingdomName.trim().isEmpty()) {
            throw new IllegalArgumentException("Kingdom name cannot be empty.");
        }
        this.kingdomName = kingdomName;
        this.foundingYear = foundingYear;
        this.allowedStructureTypes = Arrays.copyOf(allowedStructureTypes, allowedStructureTypes.length);
        this.resourceLimits = new HashMap<>(resourceLimits);
    }

    public static KingdomConfig createDefaultKingdom(String name) {
        String[] defaultTypes = {"WizardTower", "EnchantedCastle"};
        Map<String, Integer> defaultLimits = new HashMap<>();
        defaultLimits.put("Gold", 10000);
        defaultLimits.put("Mana", 5000);
        return new KingdomConfig(name, 2025, defaultTypes, defaultLimits);
    }

    public static KingdomConfig createFromTemplate(String type) {
        if ("Magic".equalsIgnoreCase(type)) {
            return createDefaultKingdom("Arcane Kingdom");
        }
        return createDefaultKingdom("Default Kingdom");
    }

    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedStructureTypes() { return Arrays.copyOf(allowedStructureTypes, allowedStructureTypes.length); }
    public Map<String, Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }

    @Override
    public String toString() {
        return "KingdomConfig for " + kingdomName;
    }
}

