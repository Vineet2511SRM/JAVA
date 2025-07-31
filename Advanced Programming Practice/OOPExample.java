class Student {
    // Data members (Encapsulation)
    private String name;
    private int age;

    // Constructor (Parameterized)
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Default constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Display method (Now with styling!)
    public void displayInfo(String title) {
        System.out.println("══════════════════════════════");
        System.out.println(" " + title);
        System.out.println("──────────────────────────────");
        System.out.println(" Name : " + name);
        System.out.println(" Age  : " + age);
        System.out.println("══════════════════════════════\n");
    }
}

public class OOPExample {
    public static void main(String[] args) {
        // Creating students
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Charlie", 23);

        // Displaying first student's initial info
        student1.displayInfo("Student 1 - Initial Info");

        // Updating student1
        student1.setName("Bob");
        student1.setAge(22);
        student1.displayInfo("Student 1 - After Updates");

        // Displaying second student's info
        student2.displayInfo("Student 2 - Initial Info");

        // Updating student2
        student2.setName("David");
        student2.setAge(25);
        student2.displayInfo("Student 2 - After Updates");

        // Demonstrating default constructor
        Student defaultStudent = new Student();
        defaultStudent.displayInfo("Default Student - Initial Info");
        defaultStudent.setName("Eve");
        defaultStudent.setAge(18);
        defaultStudent.displayInfo("Default Student - After Updates");
        
    }
}
