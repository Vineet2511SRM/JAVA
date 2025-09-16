package petsimulator;

public class DragonPet {
    private final VirtualPet corePet;
    private final String dragonType;
    private final String breathWeapon;

    public DragonPet(String name, String dragonType, String breathWeapon) {
        PetSpecies dragonSpecies = new PetSpecies("Dragon", new String[]{"Hatchling", "Drake", "Elder Dragon"}, 500, "Volcano");
        this.corePet = new VirtualPet(name, dragonSpecies);
        this.dragonType = dragonType;
        this.breathWeapon = breathWeapon;
    }

    public void unleashBreathWeapon() {
        System.out.println(corePet.getPetName() + " unleashes its " + this.breathWeapon + " breath!");
        corePet.setHappiness(corePet.getHappiness() - 5);
    }

    public String getDragonType() { return dragonType; }
    public String getBreathWeapon() { return breathWeapon; }
    public VirtualPet getCorePet() { return corePet; }

    @Override
    public String toString() { return String.format("%s the %s Dragon", corePet.getPetName(), this.dragonType); }
}
