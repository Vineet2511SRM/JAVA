
public class SmartDevice {

    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private String[] connectedDevices;
    private int connectionCount;

    // TODO: Constructor with parameter names matching field names
    public SmartDevice(String deviceName, String location, boolean isOnline, double powerConsumption) {
        // TODO: Use this keyword to distinguish between parameters and fields
        this.deviceName = deviceName;
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;

        // TODO: Initialize connectedDevices array (size 5)
        this.connectedDevices = new String[5];

        // TODO: Set connectionCount to 0
        this.connectionCount = 0;
    }

    // TODO: Method using this for parameter disambiguation
    public void updateLocation(String location) {
        // TODO: Use this.location to assign parameter value
        this.location = location;
        System.out.println(this.deviceName + " moved to " + this.location);
    }

    public void updatePowerConsumption(double powerConsumption) {
        // TODO: Use this keyword when parameter name matches field
        this.powerConsumption = powerConsumption;
        System.out.println("Power consumption updated for " + this.deviceName);
    }

    // TODO: Method returning this for chaining
    public SmartDevice setOnline(boolean isOnline) {
        // TODO: Use this keyword and return this for method chaining
        this.isOnline = isOnline;
        return this;
    }

    public SmartDevice connectToDevice(String deviceName) {
        // TODO: Add device to connectedDevices array
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to "
                    + deviceName);
        }
        return this; // Enable method chaining
    }

    public SmartDevice rename(String deviceName) {
        // TODO: Use this keyword for disambiguation
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to "
                + this.deviceName);
        return this;
    }

    public void displayDeviceInfo() {
        // TODO: Use this keyword to access instance variables
        System.out.println("\n=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + "W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println(" -> " + this.connectedDevices[i]);
        }
    }

   
    // === Method that calls other methods using this ===
    public void performInitialSetup() {
        this.setOnline(true);
        this.updatePowerConsumption(this.powerConsumption); // simulate refresh
        System.out.println(this.deviceName + " initial setup completed");
    }

    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");
        // TODO: Create devices with parameter names matching field names
        SmartDevice device1 = new SmartDevice("Living Room Light", "Living Room", true, 10.5);
        SmartDevice device2 = new SmartDevice("Kitchen Thermostat", "Kitchen", false, 5.0);
        SmartDevice device3 = new SmartDevice("Bedroom Speaker", "Bedroom", true, 15.0);

        // TODO: Test method chaining using returned this
        device1.setOnline(true).rename("Living Room Light Pro");
        device2.connectToDevice("Smart Hub").connectToDevice("Smart Speaker");
        device3.setOnline(false).rename("Bedroom Speaker Pro");

        // TODO: Show parameter disambiguation scenarios
        device1.updateLocation("Home Office");
        device2.updatePowerConsumption(6.0);
        device3.connectToDevice("Smart TV");

        // display configuration
        device1.displayDeviceInfo();
        device2.displayDeviceInfo();
        device3.displayDeviceInfo();

    }

}

