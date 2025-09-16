package petsimulator;

public class RobotPet {
    private final VirtualPet corePet;
    private boolean needsCharging;
    private int batteryLevel;

    public RobotPet(String name) {
        PetSpecies robotSpecies = new PetSpecies("Robot", new String[]{"Mk I", "Mk II", "Mk III"}, 9999, "Cyber City");
        this.corePet = new VirtualPet(name, robotSpecies);
        this.batteryLevel = 100;
        this.needsCharging = false;
    }

    public void performTask() {
        this.setBatteryLevel(this.batteryLevel - 10);
        System.out.println(corePet.getPetName() + " performed a task. Battery is now " + this.batteryLevel + "%.");
    }

    public boolean getNeedsCharging() { return needsCharging; }
    public int getBatteryLevel() { return batteryLevel; }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0 || batteryLevel > 100) throw new IllegalArgumentException("Battery level must be between 0-100.");
        this.batteryLevel = batteryLevel;
        this.needsCharging = this.batteryLevel < 20;
    }

    public VirtualPet getCorePet() { return corePet; }

    @Override
    public String toString() { return String.format("%s the Robot Pet (Battery: %d%%)", corePet.getPetName(), this.batteryLevel); }
}
