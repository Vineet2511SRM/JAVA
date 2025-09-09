import java.util.Scanner;

public class EmailAnalysis {

    // b. Method to validate email format
    public static boolean isValidEmail(String email) {
        int atPos = email.indexOf('@');
        int lastAtPos = email.lastIndexOf('@');
        int dotPos = email.lastIndexOf('.');

        // i. Check for exactly one '@'
        if (atPos == -1 || atPos != lastAtPos) return false;

        // ii. At least one '.' after '@'
        if (dotPos == -1 || dotPos < atPos) return false;

        // iii. Username and domain should not be empty
        if (atPos == 0 || atPos == email.length() - 1) return false;

        return true;
    }

    // c. Method to extract components
    public static String[] extractComponents(String email) {
        int atPos = email.indexOf('@');
        int dotPos = email.lastIndexOf('.');

        String username = email.substring(0, atPos);
        String domain = email.substring(atPos + 1);
        String domainName = email.substring(atPos + 1, dotPos);
        String extension = email.substring(dotPos + 1);

        return new String[]{username, domain, domainName, extension};
    }

    // d. Analyze email statistics
    public static void analyzeStats(String[] emails, boolean[] validity) {
        int validCount = 0, invalidCount = 0, totalUsernameLength = 0;

        // For tracking domains
        String[] domains = new String[emails.length];
        int[] domainFreq = new int[emails.length];
        int domainTypes = 0;

        for (int i = 0; i < emails.length; i++) {
            if (validity[i]) {
                validCount++;

                int atPos = emails[i].indexOf('@');
                String username = emails[i].substring(0, atPos);
                totalUsernameLength += username.length();

                // Count domain frequency
                String domain = emails[i].substring(atPos + 1);
                boolean found = false;
                for (int j = 0; j < domainTypes; j++) {
                    if (domains[j].equals(domain)) {
                        domainFreq[j]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    domains[domainTypes] = domain;
                    domainFreq[domainTypes] = 1;
                    domainTypes++;
                }

            } else {
                invalidCount++;
            }
        }

        // Find most common domain
        String mostCommonDomain = "-";
        int maxFreq = 0;
        for (int i = 0; i < domainTypes; i++) {
            if (domainFreq[i] > maxFreq) {
                maxFreq = domainFreq[i];
                mostCommonDomain = domains[i];
            }
        }

        // Print stats
        System.out.println("\n=== Email Statistics ===");
        System.out.println("Total Valid Emails   : " + validCount);
        System.out.println("Total Invalid Emails : " + invalidCount);
        if (validCount > 0) {
            System.out.println("Average Username Length : " + (totalUsernameLength / validCount));
            System.out.println("Most Common Domain      : " + mostCommonDomain + " (" + maxFreq + " times)");
        }
    }

    // e. Display results in tabular format
    public static void displayResults(String[] emails, boolean[] validity) {
        System.out.printf("\n%-25s %-15s %-20s %-15s %-10s %-10s\n",
                "Email", "Username", "Domain", "Domain Name", "Extension", "Valid?");
        System.out.println("------------------------------------------------------------------------------------------");

        for (int i = 0; i < emails.length; i++) {
            if (validity[i]) {
                String[] parts = extractComponents(emails[i]);
                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s\n",
                        emails[i], parts[0], parts[1], parts[2], parts[3], "YES");
            } else {
                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s\n",
                        emails[i], "-", "-", "-", "-", "NO");
            }
        }
    }

    // f. Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter number of emails: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] emails = new String[n];
        boolean[] validity = new boolean[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter email " + (i + 1) + ": ");
            emails[i] = sc.nextLine();
            validity[i] = isValidEmail(emails[i]);
        }

        // e. Display table
        displayResults(emails, validity);

        // d. Analyze statistics
        analyzeStats(emails, validity);
    }
}
