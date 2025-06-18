import java.util.Scanner;

public class Bonus_Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        // Input loop
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");

            while (true) {
                System.out.print("Salary: ");
                if (sc.hasNextDouble()) {
                    salaries[i] = sc.nextDouble();
                    if (salaries[i] > 0) break;
                }
                sc.nextLine(); // Clear invalid input
                System.out.println("Invalid salary! Please enter again.");
            }

            while (true) {
                System.out.print("Years of Service: ");
                if (sc.hasNextDouble()) {
                    yearsOfService[i] = sc.nextDouble();
                    if (yearsOfService[i] >= 0) break;
                }
                sc.nextLine(); // Clear invalid input
                System.out.println("Invalid years of service! Please enter again.");
            }
        }

        // Processing loop
        for (int i = 0; i < 10; i++) {
            bonuses[i] = (yearsOfService[i] > 5) ? (salaries[i] * 0.05) : (salaries[i] * 0.02);
            newSalaries[i] = salaries[i] + bonuses[i];

            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        // Output results
        System.out.println("\nEmployee Salary Details:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Employee %d -> Old Salary: %.2f, Bonus: %.2f, New Salary: %.2f%n",
                    (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }

        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        sc.close();
    }
}
