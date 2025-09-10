import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SmartDevice {
    // === Read-only fields ===
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;

    // === Write-only fields (stored hashed) ===
    private int hashedEncryptionKey;
    private int hashedAdminPassword;

    // === Read-Write fields ===
    private String deviceName;
    private boolean enabled;

    // === Internal state ===
    private final LocalDateTime startupTime;

    // === Constructor ===
    public SmartDevice(String deviceName, LocalDateTime manufacturingDate) {
        this.deviceId = UUID.randomUUID().toString();
        this.serialNumber = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.manufacturingDate = manufacturingDate;
        this.deviceName = deviceName;
        this.enabled = true;
        this.startupTime = LocalDateTime.now();
    }

    // === Read-Only Getters ===
    public String getDeviceId() { return deviceId; }
    public LocalDateTime getManufacturingDate() { return manufacturingDate; }
    public String getSerialNumber() { return serialNumber; }
    public long getUptime() {
        return Duration.between(startupTime, LocalDateTime.now()).toSeconds();
    }
    public int getDeviceAge() {
        return Period.between(manufacturingDate.toLocalDate(), LocalDateTime.now().toLocalDate()).getYears();
    }

    // === Write-Only Methods ===
    public void setEncryptionKey(String key) {
        if (key == null || key.length() < 8) {
            throw new IllegalArgumentException("Encryption key must be at least 8 characters long");
        }
        this.hashedEncryptionKey = key.hashCode();
    }
    public void setAdminPassword(String password) {
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        this.hashedAdminPassword = password.hashCode();
    }
    public boolean validateEncryptionKey(String key) {
        return key.hashCode() == hashedEncryptionKey;
    }
    public boolean validateAdminPassword(String password) {
        return password.hashCode() == hashedAdminPassword;
    }

    // === Read-Write Getters/Setters ===
    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String deviceName) { this.deviceName = deviceName; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    // === Utility Methods ===
    public Map<String, String> getPropertyInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("deviceId", "Read-Only");
        info.put("manufacturingDate", "Read-Only");
        info.put("serialNumber", "Read-Only");
        info.put("uptime", "Computed Read-Only");
        info.put("deviceAge", "Computed Read-Only");
        info.put("encryptionKey", "Write-Only");
        info.put("adminPassword", "Write-Only");
        info.put("deviceName", "Read-Write");
        info.put("isEnabled", "Read-Write");
        return info;
    }

    public void resetDevice() {
        this.hashedEncryptionKey = 0;
        this.hashedAdminPassword = 0;
        this.enabled = false;
        this.deviceName = "RESET-" + this.deviceName;
    }

    @Override
    public String toString() {
        return "SmartDevice{" +
                "deviceId='" + deviceId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", enabled=" + enabled +
                ", deviceAge=" + getDeviceAge() + " years" +
                ", uptime=" + getUptime() + "s" +
                '}';
    }

    public static void main(String[] args) {
        SmartDevice vineetDevice = new SmartDevice("VineetPhone", LocalDateTime.of(2022, 1, 15, 10, 0));

        // Read-only properties
        System.out.println("=== Vineet's Device ===");
        System.out.println("Device ID: " + vineetDevice.getDeviceId());
        System.out.println("Manufacturing Date: " + vineetDevice.getManufacturingDate());
        System.out.println("Serial Number: " + vineetDevice.getSerialNumber());
        System.out.println("Device Age: " + vineetDevice.getDeviceAge() + " years");
        System.out.println("Uptime: " + vineetDevice.getUptime() + " seconds");

        // Write-only properties
        vineetDevice.setEncryptionKey("vineetKey123");
        vineetDevice.setAdminPassword("vineetPass");
        System.out.println("Encryption validation: " + vineetDevice.validateEncryptionKey("vineetKey123"));
        System.out.println("Admin password validation: " + vineetDevice.validateAdminPassword("vineetPass"));

        // Read-write properties
        System.out.println("Device Name: " + vineetDevice.getDeviceName());
        vineetDevice.setDeviceName("VineetLaptop");
        System.out.println("Updated Device Name: " + vineetDevice.getDeviceName());
        System.out.println("Enabled: " + vineetDevice.isEnabled());

        // Utility info
        System.out.println("Property Info: " + vineetDevice.getPropertyInfo());

        // Reset test
        vineetDevice.resetDevice();
        System.out.println("After Reset: " + vineetDevice);
    }
}
