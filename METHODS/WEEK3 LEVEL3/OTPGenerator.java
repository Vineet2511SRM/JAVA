
public class OTPGenerator{

    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);  // Range: 100000 to 999999
    }

    // Method to check if all elements in the array are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;  // Duplicate found
                }
            }
        }
        return true;  // All elements are unique
    }

    // Main method
    public static void main(String[] args) {
        int[] otpArray = new int[10];

        // Generate 10 OTPs and store them in the array
        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }

        // Display generated OTPs
        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.println(otp);
        }

        // Check uniqueness
        boolean unique = areOTPsUnique(otpArray);
        System.out.println("\nAre all OTPs unique? " + (unique ? "Yes ✅" : "No ❌"));
    }
}
