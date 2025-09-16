package kingdom;

import java.util.ArrayList;
import java.util.List;

public class KingdomManager {
    private final List<Object> structures = new ArrayList<>();
    private final KingdomConfig config;

    public KingdomManager(KingdomConfig config) { this.config = config; }

    public void addStructure(Object structure) {
        if (structure != null) structures.add(structure);
    }

    public static boolean canStructuresInteract(Object s1, Object s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) return true;
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) return true;
        return false;
    }

    public static String performMagicBattle(Object attacker, Object defender) {
        if (attacker instanceof WizardTower && defender instanceof DragonLair) {
            return "WizardTower casts a powerful spell against the DragonLair!";
        }
        return "The structures are incompatible for battle.";
    }

    public int calculateKingdomPower() {
        int totalPower = 0;
        for (Object s : structures) {
            if (s instanceof WizardTower) totalPower += ((WizardTower) s).getPower();
            else if (s instanceof EnchantedCastle) totalPower += ((EnchantedCastle) s).getPower();
            else if (s instanceof MysticLibrary) totalPower += ((MysticLibrary) s).getPower();
            else if (s instanceof DragonLair) totalPower += ((DragonLair) s).getPower();
        }
        return totalPower;
    }

    private String determineStructureCategory(Object structure) {
        if (structure instanceof WizardTower || structure instanceof MysticLibrary) return "Magic & Knowledge";
        if (structure instanceof EnchantedCastle || structure instanceof DragonLair) return "Military & Power";
        if (structure instanceof MagicalStructure) return "General Magical";
        return "Unknown";
    }

    public void printKingdomReport() {
        System.out.println("Report for Kingdom: " + config.getKingdomName());
        for (Object s : structures) {
            System.out.println("- " + s.toString() + " (Category: " + determineStructureCategory(s) + ")");
        }
        System.out.println("Total Kingdom Power: " + calculateKingdomPower());
    }
}
