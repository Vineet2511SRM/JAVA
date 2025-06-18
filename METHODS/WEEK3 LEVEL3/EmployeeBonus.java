import java.util.Random;

public class EmployeeBonus {

    // Method to generate salary and years of service
    public static int[][] generateData(int numEmployees) {
        Random rand = new Random();
        int[][] data = new int[numEmployees][2]; // [][0] = salary, [][1] = years

        for (int i = 0; i < numEmployees; i++) {
            int salary = 10000 + rand.nextInt(90000); // 5-digit salary (10000 to 99999)
            int years = 1 + rand.nextInt(10); // 1 to 10 years of service
            data[i][0] = salary;
            data[i][1] = years;
        }

        return data;
    }

    // Method to calculate bonus and new salary
    public static double[][] calculateBonusAndNewSalary(int[][] data) {
        double[][] result = new double[data.length][2]; // [][0] = bonus, [][1] = new salary

        for (int i = 0; i < data.length; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;
            result[i][0] = bonus;
            result[i][1] = newSalary;
        }

        return result;
    }

    // Method to print tabular report
    public static void printReport(int[][] oldData, double[][] newData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-10s %-10s %-12s\n", "ID", "Salary", "Service", "Bonus", "New Salary");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            int salary = oldData[i][0];
            int years = oldData[i][1];
            double bonus = newData[i][0];
            double newSalary = newData[i][1];

            totalOldSalary += salary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-5d %-10d %-10d %-10.2f %-12.2f\n", (i + 1), salary, years, bonus, newSalary);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("TOTAL  %-10.2f %-10s %-10.2f %-12.2f\n",
                totalOldSalary, "", totalBonus, totalNewSalary);
        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int[][] employeeData = generateData(10);
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        printReport(employeeData, bonusData);
    }
}
