package petsimulator;

public class PetSimulator {
    public static void main(String[] args) {
        System.out.println("--- Virtual Pet System v" + VirtualPet.PET_SYSTEM_VERSION + " ---");

        PetSpecies fireLizardSpecies = new PetSpecies(
                "Fire Lizard",
                new String[]{"Spark", "Ember", "Blaze"},
                15,
                "Volcanic Plains"
        );

        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Sparky");
        VirtualPet pet3 = new VirtualPet("Inferno", fireLizardSpecies);

        System.out.println("\n--- Created Pets ---");
        System.out.println("Pet 1 (Default): " + pet1);
        System.out.println("Pet 2 (Named): " + pet2);
        System.out.println("Pet 3 (Custom Species): " + pet3);

        System.out.println("\n--- Interacting with " + pet3.getPetName() + " ---");
        System.out.println("Initial State: " + pet3.getInternalState());
        pet3.feedPet("favorite");
        pet3.playWithPet("fetch");
        System.out.println("Final State: " + pet3.getInternalState());

        System.out.println("\n--- Specialized Pets ---");
        DragonPet dragon = new DragonPet("Ignis", "Red", "Fireball");
        RobotPet robot = new RobotPet("Unit 734");

        System.out.println(dragon);
        dragon.unleashBreathWeapon();
        System.out.println("Dragon's Core State: " + dragon.getCorePet().getInternalState());

        System.out.println(robot);
        robot.performTask();
        System.out.println("Robot needs charging? " + robot.getNeedsCharging());

        System.out.println("\n--- Simulating a few days with " + pet2.getPetName() + " ---");
        for (int day = 1; day <= 3; day++) {
            System.out.println("\n--- Day " + day + " ---");
            System.out.println("Morning State: " + pet2.getInternalState());
            pet2.feedPet("normal");
            System.out.println(pet2.getPetName() + " has been fed.");
            pet2.playWithPet("ball");
            System.out.println(pet2.getPetName() + " played with a ball.");
            pet2.setHappiness(pet2.getHappiness() - 5);
            pet2.setHealth(pet2.getHealth() - 3);
            System.out.println("Evening State: " + pet2.getInternalState());
        }

        System.out.println("\nSimulation complete for " + pet2.getPetName() + "!");
    }
}
