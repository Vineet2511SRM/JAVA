package kingdom;

public class DragonLair {
    private final String dragonType;
    private final long treasureValue;
    private int territorialRadius;

    public DragonLair(String dragonType, long treasureValue, int territorialRadius) {
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
        this.territorialRadius = territorialRadius;
    }

    public String getDragonType() { return dragonType; }
    public long getTreasureValue() { return treasureValue; }
    public int getTerritorialRadius() { return territorialRadius; }
    public void setTerritorialRadius(int territorialRadius) { this.territorialRadius = territorialRadius; }
    public int getPower() { return (int) (treasureValue / 1000) + territorialRadius; }

    @Override public String toString() { return "Lair of a " + dragonType + " Dragon"; }
}
