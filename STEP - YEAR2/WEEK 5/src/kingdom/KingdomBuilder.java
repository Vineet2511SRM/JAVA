package kingdom;

import java.util.ArrayList;
import java.util.HashMap;

public class KingdomBuilder {
    public static void main(String[] args) {
        System.out.println("--- Kingdom Management System v" + MagicalStructure.MAGIC_SYSTEM_VERSION + " ---");

        KingdomConfig config = KingdomConfig.createDefaultKingdom("Aethelgard");
        KingdomManager manager = new KingdomManager(config);

        System.out.println("\nBuilding structures for the kingdom of " + config.getKingdomName());
        WizardTower tower = new WizardTower(50, new ArrayList<>(), "Merlin");
        EnchantedCastle castle = new EnchantedCastle("Royal", 95, true);
        MysticLibrary library = new MysticLibrary(new HashMap<>(), 88);
        DragonLair lair = new DragonLair("Golden", 50000L, 20);

        manager.addStructure(tower);
        manager.addStructure(castle);
        manager.addStructure(library);
        manager.addStructure(lair);

        System.out.println("\n--- Testing Interactions ---");
        System.out.println("Can Tower and Library interact? " + KingdomManager.canStructuresInteract(tower, library));
        System.out.println("Can Castle and Library interact? " + KingdomManager.canStructuresInteract(castle, library));

        System.out.println("\n--- Simulating a Battle ---");
        System.out.println(KingdomManager.performMagicBattle(tower, lair));
        System.out.println(KingdomManager.performMagicBattle(castle, lair));

        System.out.println("\n--- Kingdom Status Report ---");
        manager.printKingdomReport();
    }
}
