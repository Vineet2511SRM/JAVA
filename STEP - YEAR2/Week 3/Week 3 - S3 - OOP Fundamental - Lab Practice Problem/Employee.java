// Employee class
class Employee {
    // Instance variables
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    // Static variable to track total employees
    private static int totalEmployees = 0;
    // Default constructor (not used here, just for flexibility)
    public Employee() {}
    // Constructor for full-time employee
    public Employee(String id, String name, String dept, double baseSalary) {
        this.empId = id;
        this.empName = name;
        this.department = dept;
        this.baseSalary = baseSalary;
        this.empType = "Full-Time";
        totalEmployees++;
    }
    // Constructor for part-time employee
    public Employee(String id, String name, String dept, double hourlyRate, int hours) {
        this.empId = id;
        this.empName = name;
        this.department = dept;
        this.baseSalary = hourlyRate * hours; // total pay
        this.empType = "Part-Time";
        totalEmployees++;
    }
    // Constructor for contract employee
    public Employee(String id, String name, String dept, double fixedPay, boolean isContract) {
        this.empId = id;
        this.empName = name;
        this.department = dept;
        this.baseSalary = fixedPay;
        this.empType = "Contract";
        totalEmployees++;
    }
    // Overloaded method: calculate salary for full-time with bonus
    public double calculateSalary(double bonus) {
        if (empType.equals("Full-Time")) {
            return baseSalary + bonus;
        }
        return baseSalary;
    }
    // Overloaded method: calculate salary for part-time
    public double calculateSalary(int hoursWorked, double hourlyRate) {
        if (empType.equals("Part-Time")) {
            return hoursWorked * hourlyRate;
        }
        return baseSalary;
    }
    // Overloaded method: calculate salary for contract
    public double calculateSalary() {
        return baseSalary;
    }
    // Overloaded method: calculate tax for full-time
    public double calculateTax(double rate) {
        return baseSalary * rate;
    }
    // Overloaded method: calculate tax for part-time (fixed 5%)
    public double calculateTax(int dummy) {
        return baseSalary * 0.05;
    }
    // Overloaded method: calculate tax for contract (no tax)
    public double calculateTax() {
        return 0;
    }
    // Method to display formatted employee data and salary info
    public void generatePaySlip() {
        System.out.println("---------- PAY SLIP ----------");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Name          : " + empName);
        System.out.println("Department    : " + department);
        System.out.println("Employee Type : " + empType);
        System.out.println("Base Salary   : ₹" + baseSalary);

        double salary = 0;
        double tax = 0;

        if (empType.equals("Full-Time")) {
            salary = calculateSalary(5000); // bonus
            tax = calculateTax(0.1); // 10%
        } else if (empType.equals("Part-Time")) {
            salary = calculateSalary(20, baseSalary / 20); // reverse calc
            tax = calculateTax(0); // dummy
        } else if (empType.equals("Contract")) {
            salary = calculateSalary();
            tax = calculateTax(); // zero
        }

        System.out.println("Calculated Pay: ₹" + salary);
        System.out.println("Tax Deducted  : ₹" + tax);
        System.out.println("Net Pay       : ₹" + (salary - tax));
        System.out.println("-------------------------------\n");
    }

    // Method to display basic employee info
    public void displayEmployeeInfo() {
        System.out.println(empId + " | " + empName + " | " + department + " | " + empType + " | ₹" + baseSalary);
    }

    // Static method to return total employee count
    public static int getTotalEmployees() {
        return totalEmployees;
    }

    // Static method to display company payroll report
    public static void showCompanyPayrollReport(Employee[] empList) {
        System.out.println("===== Company Payroll Report =====");
        for (Employee emp : empList) {
            emp.displayEmployeeInfo();
        }
        System.out.println("Total Employees: " + getTotalEmployees());
        System.out.println("==================================\n");
    }

    public static void main(String[] args) {
        // Create different types of employees
        Employee e1 = new Employee("E101", "Riya Mehra", "HR", 30000);                    // Full-Time
        Employee e2 = new Employee("E102", "Ankit Singh", "IT", 500, 80);                // Part-Time
        Employee e3 = new Employee("E103", "Kavya Rao", "Finance", 40000, true);         // Contract

        // Store in array
        Employee[] empList = {e1, e2, e3};

        // Show all employee payslips
        for (Employee emp : empList) {
            emp.generatePaySlip();
        }

        // Show company-wide report
        Employee.showCompanyPayrollReport(empList);
    }
}
