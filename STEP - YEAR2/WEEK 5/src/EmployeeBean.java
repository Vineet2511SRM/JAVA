import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class EmployeeBean implements Serializable {
    private static final long serialVersionUID = 1L;

    // === Private Fields ===
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean active;

    // === Constructors ===
    public EmployeeBean() {
        // No-argument constructor (JavaBean requirement)
    }

    public EmployeeBean(String employeeId, String firstName, String lastName,
                        double salary, String department, Date hireDate, boolean active) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary); // validation
        this.department = department;
        this.hireDate = hireDate;
        this.active = active;
    }

    // === Getters (JavaBean standard) ===
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public boolean isActive() {
        return active;
    }

    // === Setters (JavaBean standard) ===
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must be non-negative");
        }
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // === Computed Properties ===
    public String getFullName() {
        return (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
    }

    public int getYearsOfService() {
        if (hireDate == null) return 0;
        LocalDate hireLocal = hireDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(hireLocal, LocalDate.now()).getYears();
    }

    public String getFormattedSalary() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(salary);
    }

    // === Derived Setter ===
    public void setFullName(String fullName) {
        if (fullName != null && fullName.contains(" ")) {
            String[] parts = fullName.split(" ", 2);
            this.firstName = parts[0];
            this.lastName = parts[1];
        } else {
            this.firstName = fullName;
            this.lastName = "";
        }
    }

    // === Overrides ===
    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employeeId='" + employeeId + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", salary=" + getFormattedSalary() +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                ", active=" + active +
                ", yearsOfService=" + getYearsOfService() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean that = (EmployeeBean) o;
        return Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    // === Demo Main ===
    public static void main(String[] args) {
        EmployeeBean emp1 = new EmployeeBean();
        emp1.setEmployeeId("E101");
        emp1.setFullName("Vineet Seth");
        emp1.setSalary(50000);
        emp1.setDepartment("Cyber Security");
        emp1.setHireDate(new Date(120, 0, 1)); // 2020-01-01
        emp1.setActive(true);

        EmployeeBean emp2 = new EmployeeBean("E102", "Riya", "Sharma", 60000,
                "Development", new Date(118, 5, 15), true);

        System.out.println("=== Employee 1 ===");
        System.out.println(emp1);

        System.out.println("=== Employee 2 ===");
        System.out.println(emp2);

        System.out.println("Full Name: " + emp2.getFullName());
        System.out.println("Years of Service: " + emp2.getYearsOfService());
        System.out.println("Formatted Salary: " + emp2.getFormattedSalary());
    }
}
