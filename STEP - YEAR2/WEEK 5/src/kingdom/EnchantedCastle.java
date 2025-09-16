package kingdom;

public class EnchantedCastle {
    private final String castleType;
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String castleType, int defenseRating, boolean hasDrawbridge) {
        this.castleType = castleType;
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    public String getCastleType() { return castleType; }
    public int getDefenseRating() { return defenseRating; }
    public boolean getHasDrawbridge() { return hasDrawbridge; }
    public void setDefenseRating(int defenseRating) { this.defenseRating = defenseRating; }
    public int getPower() { return defenseRating * 5; }

    @Override public String toString() { return castleType + " EnchantedCastle"; }
}
