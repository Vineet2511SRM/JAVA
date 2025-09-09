public class Student {
    // TODO: Define private instance variables:
    private String studentId;
    private String name;
    private double grade;
    private String course;

    // TODO: Create a default constructor (no parameters)
    Student(){
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }

    // TODO: Create a parameterized constructor that accepts all attributes
    Student(String studentId, String name, double grade, String course){
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // TODO: Create getter and setter methods for all attributes
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // TODO: Create a method calculateLetterGrade() that returns:
    // A (90-100), B (80-89), C (70-79), D (60-69), F (below 60)
    public String calculateLetterGrade() {
        if (grade >= 90 && grade <= 100) {
            return "A";
        } else if (grade >= 80 && grade < 90) {
            return "B";
        } else if (grade >= 70 && grade < 80) {
            return "C";
        } else if (grade >= 60 && grade < 70) {
            return "D";
        } else {
            return "F";
        }
    }

    // TODO: Create a method displayStudent() that shows all information
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("Course: " + course);
        System.out.println("Letter Grade: " + calculateLetterGrade());
    }

    public static void main(String[] args) {
        // TODO: Create one student using default constructor, then set values
        Student student1 = new Student();
        student1.setStudentId("S001");
        student1.setName("John Doe");
        student1.setGrade(85.5);
        student1.setCourse("Computer Science");

        // Display student information
        student1.displayStudent();

        // TODO: Create another student using parameterized constructor
        Student student2 = new Student("S002", "Jane Smith", 92.0, "Mathematics");
        student2.displayStudent();

        // TODO: Demonstrate all getter/setter methods
        System.out.println("Student ID: " + student1.getStudentId());
        System.out.println("Name: " + student1.getName());
        System.out.println("Grade: " + student1.getGrade());
        System.out.println("Course: " + student1.getCourse());

        // Update student1's information
        student1.setName("Johnathan Doe");
        student1.setGrade(90.0);
        System.out.println("Updated Name: " + student1.getName());
        System.out.println("Updated Grade: " + student1.getGrade());

        // TODO: Show both students' information and letter grades
        System.out.println("Student 1 Letter Grade: " + student1.calculateLetterGrade());
        System.out.println("Student 2 Letter Grade: " + student2.calculateLetterGrade());
    }
}