package kingdom;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MysticLibrary {
    private Map<String, String> bookCollection;
    private int knowledgeLevel;

    public MysticLibrary(Map<String, String> bookCollection, int knowledgeLevel) {
        this.bookCollection = new HashMap<>(bookCollection);
        this.knowledgeLevel = knowledgeLevel;
    }

    public Map<String, String> getBookCollection() { return Collections.unmodifiableMap(bookCollection); }
    public int getKnowledgeLevel() { return knowledgeLevel; }
    public int getPower() { return knowledgeLevel * 2; }

    @Override public String toString() { return "MysticLibrary (Knowledge: " + knowledgeLevel + ")"; }
}
