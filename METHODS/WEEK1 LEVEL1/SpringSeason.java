public class SpringSeason {

    // Method to check if the given date is in Spring Season
    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20 && day <= 31) ||
            (month == 4 && day >= 1 && day <= 30) ||
            (month == 5 && day >= 1 && day <= 31) ||
            (month == 6 && day >= 1 && day <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Ensure two command line arguments are passed
        if (args.length != 2) {
            System.out.println("Please provide two integers: month and day.");
            return;
        }

        // Parse command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if it's spring season
        boolean result = isSpringSeason(month, day);

        // Display result
        if (result) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
