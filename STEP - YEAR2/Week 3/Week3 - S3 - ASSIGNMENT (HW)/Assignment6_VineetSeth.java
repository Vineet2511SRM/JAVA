/**
 * Assignment6_EmployeePayroll.java
 * Author: Vineet Seth
 * Description: Integrated Employee Management System for Payroll,
 * Attendance, and Performance Tracking with static vs instance members.
 */

/**
 * Represents an employee in the company.
 */
class Employee {
    private String empId;
    private String empName;
    private String department;
    private String designation;
    protected double baseSalary;
    private String joinDate;
    private boolean[] attendanceRecord; // 30 days
    private int leavesTaken;

    // Static variables
    static int totalEmployees = 0;
    static String companyName = "Tech Solutions Pvt Ltd";
    static double totalSalaryExpense = 0;
    static int workingDaysPerMonth = 30;

    /**
     * Constructor for Employee
     * @param empId employee id
     * @param empName employee name
     * @param department employee department
     * @param designation employee designation
     * @param baseSalary employee base salary
     * @param joinDate employee joining date
     */
    public Employee(String empId, String empName, String department,
                    String designation, double baseSalary, String joinDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.attendanceRecord = new boolean[workingDaysPerMonth];
        this.leavesTaken = 0;
        totalEmployees++;
    }

    /**
     * Mark attendance for a day.
     * @param day day of the month (1-30)
     * @param present whether employee is present
     */
    public void markAttendance(int day, boolean present) {
        try {
            if (day < 1 || day > workingDaysPerMonth) {
                throw new IllegalArgumentException("Invalid day: " + day);
            }
            attendanceRecord[day - 1] = present;
            if (!present) {
                leavesTaken++;
            }
        } catch (Exception e) {
            System.out.println("Error marking attendance: " + e.getMessage());
        }
    }

    /**
     * Calculate monthly salary (default = prorated by attendance).
     * Can be overridden in subclasses.
     * @return calculated salary
     */
    public double calculateSalary() {
        int daysPresent = 0;
        for (boolean present : attendanceRecord) {
            if (present) daysPresent++;
        }
        double salary = (baseSalary / workingDaysPerMonth) * daysPresent;
        totalSalaryExpense += salary;
        return salary;
    }

    /**
     * Calculate performance bonus.
     * @return bonus amount
     */
    public double calculateBonus() {
        int daysPresent = 0;
        for (boolean present : attendanceRecord) {
            if (present) daysPresent++;
        }
        double attendanceRate = (daysPresent * 100.0) / workingDaysPerMonth;
        return (attendanceRate >= 90) ? 0.1 * baseSalary : 0;
    }

    /**
     * Generate employee payslip.
     */
    public void generatePaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        System.out.println("\n--- Pay Slip ---");
        System.out.println("Company: " + companyName);
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Leaves Taken: " + leavesTaken);
        System.out.println("Net Salary: " + (salary + bonus));
    }

    /**
     * Request leave.
     * @param days number of leave days
     */
    public void requestLeave(int days) {
        try {
            if (days < 0) throw new IllegalArgumentException("Leave days cannot be negative");
            if (days > 5) {
                System.out.println(empName + " leave request denied (exceeds limit).");
            } else {
                System.out.println(empName + " leave request approved for " + days + " days.");
                leavesTaken += days;
            }
        } catch (Exception e) {
            System.out.println("Error in leave request: " + e.getMessage());
        }
    }

    // Getters
    public String getDepartment() { return department; }
    public String getEmpName() { return empName; }
    public double getBaseSalary() { return baseSalary; }
}

/**
 * Represents a department in the company.
 */
class Department {
    private String deptId;
    private String deptName;
    private Employee manager;
    private Employee[] employees;
    private double budget;

    public Department(String deptId, String deptName, Employee manager,
                      Employee[] employees, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.employees = employees;
        this.budget = budget;
    }

    public double getDepartmentExpense() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    public String getDeptName() { return deptName; }
}

/**
 * Subclass for Full-time Employee
 */
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String empId, String empName, String department,
                            String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }

    @Override
    public double calculateSalary() {
        // Full salary guaranteed, no deduction
        totalSalaryExpense += baseSalary;
        return baseSalary;
    }
}

/**
 * Subclass for Part-time Employee
 */
class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String empId, String empName, String department,
                            String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }

    @Override
    public double calculateSalary() {
        // Half salary
        double salary = baseSalary / 2;
        totalSalaryExpense += salary;
        return salary;
    }
}

/**
 * Subclass for Contract Employee
 */
class ContractEmployee extends Employee {
    public ContractEmployee(String empId, String empName, String department,
                            String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }

    @Override
    public double calculateSalary() {
        // Daily wage calculation (15 days assumed)
        double salary = (baseSalary / 30) * 15;
        totalSalaryExpense += salary;
        return salary;
    }
}

/**
 * Main driver class
 */
public class Assignment6_VineetSeth {
    /**
     * Calculate total payroll for all employees.
     * @param employees list of employees
     * @return total payroll
     */
    public static double calculateCompanyPayroll(Employee[] employees) {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    /**
     * Get expenses grouped by department.
     * @param departments list of departments
     */
    public static void getDepartmentWiseExpenses(Department[] departments) {
        System.out.println("\n--- Department Expenses ---");
        for (Department d : departments) {
            System.out.println(d.getDeptName() + " -> Expense: " + d.getDepartmentExpense());
        }
    }

    /**
     * Generate attendance report.
     */
    public static void getAttendanceReport(Employee[] employees) {
        System.out.println("\n--- Attendance Report ---");
        for (Employee e : employees) {
            System.out.println("Employee: " + e.getEmpName() + " | Base Salary: " + e.getBaseSalary());
        }
    }

    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("E001", "Aarav", "IT", "Developer", 50000, "2022-01-01");
        Employee e2 = new PartTimeEmployee("E002", "Riya", "HR", "Assistant", 30000, "2023-02-01");
        Employee e3 = new ContractEmployee("E003", "Kabir", "Finance", "Analyst", 40000, "2024-03-01");

        Employee[] employees = {e1, e2, e3};
        Department d1 = new Department("D001", "IT", e1, new Employee[]{e1}, 200000);
        Department d2 = new Department("D002", "HR", e2, new Employee[]{e2}, 100000);
        Department d3 = new Department("D003", "Finance", e3, new Employee[]{e3}, 150000);
        Department[] departments = {d1, d2, d3};

        // Mark attendance
        e1.markAttendance(1, true);
        e2.markAttendance(1, false);
        e3.markAttendance(1, true);

        // Request leaves
        e1.requestLeave(3);
        e2.requestLeave(6); // should deny

        // Generate payslips
        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();

        // Reports
        System.out.println("\nTotal Payroll: " + calculateCompanyPayroll(employees));
        getDepartmentWiseExpenses(departments);
        getAttendanceReport(employees);
    }
}
