package kingdom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WizardTower {
    private final int maxSpellCapacity;
    private List<String> knownSpells;
    private String currentWizard;

    public WizardTower() { this(10, new ArrayList<>(), "Novice"); }

    public WizardTower(int maxSpellCapacity, List<String> knownSpells, String currentWizard) {
        this.maxSpellCapacity = maxSpellCapacity;
        this.knownSpells = new ArrayList<>(knownSpells);
        this.currentWizard = currentWizard;
    }

    public int getMaxSpellCapacity() { return maxSpellCapacity; }
    public List<String> getKnownSpells() { return Collections.unmodifiableList(knownSpells); }
    public String getCurrentWizard() { return currentWizard; }
    public void setCurrentWizard(String currentWizard) { this.currentWizard = currentWizard; }
    public int getPower() { return knownSpells.size() * 10; }

    @Override public String toString() { return "WizardTower of " + currentWizard; }
}
