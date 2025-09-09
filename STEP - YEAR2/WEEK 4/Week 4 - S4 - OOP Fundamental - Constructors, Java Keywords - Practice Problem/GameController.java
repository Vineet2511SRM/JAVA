public class GameController {

    // === Instance variables for controller configuration ===
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;      // 0 - 100
    private double sensitivity;    // 0.1 - 3.0

    // === Default constructor (standard setup) ===
    public GameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // === Fully parameterized constructor (custom config) ===
    public GameController(String controllerBrand, String connectionType,
                          boolean hasVibration, int batteryLevel,
                          double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;

        // Validation for battery
        if (batteryLevel < 0) {
            this.batteryLevel = 0;
        } else if (batteryLevel > 100) {
            this.batteryLevel = 100;
        } else {
            this.batteryLevel = batteryLevel;
        }

        // Validation for sensitivity
        if (sensitivity < 0.1) {
            this.sensitivity = 0.1;
        } else if (sensitivity > 3.0) {
            this.sensitivity = 3.0;
        } else {
            this.sensitivity = sensitivity;
        }
    }

    // === Two-parameter constructor (brand + connection only) ===
    public GameController(String brand, String connectionType) {
        this.controllerBrand = brand;
        this.connectionType = connectionType;

        // use default values for rest
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // === Methods to test functionality ===
    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
        System.out.println("Sensitivity set to: " + sensitivity);
    }

    public void displayConfiguration() {
        System.out.println("----- Controller Configuration -----");
        System.out.println("Brand: " + controllerBrand);
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
        System.out.println("------------------------------------");
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    // === Main method to test constructors and methods ===
    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        // 1. Default constructor
        GameController defaultController = new GameController();
        System.out.println("\n>> Default Controller:");
        defaultController.displayConfiguration();
        defaultController.calibrateController();
        defaultController.testVibration();

        // 2. Fully parameterized constructor
        GameController customController = new GameController(
                "ProXPad", "Bluetooth", false, 75, 2.5
        );
        System.out.println("\n>> Custom Controller:");
        customController.displayConfiguration();
        customController.calibrateController();
        customController.testVibration();

        // 3. Convenience constructor
        GameController miniController = new GameController("MiniJoy", "Wireless");
        System.out.println("\n>> Mini Controller:");
        miniController.displayConfiguration();
        miniController.calibrateController();
        miniController.testVibration();

        // Comparison
        System.out.println("\n=== Comparing Different Configurations ===");
        System.out.println("Default vs Custom: Sensitivity difference = " +
                (customController.sensitivity - defaultController.sensitivity));
    }
}
