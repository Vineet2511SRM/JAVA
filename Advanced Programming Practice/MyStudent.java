class Student {
    private String name;
    private int rollNo;

    public void setvalues(){
        this.name = "Vineet Seth";
        this.rollNo = 101;
    }

    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Roll No: " + this.rollNo);
    }
}

public class MyStudent {
    public static void main(String[] args) {
        // Creating object of Student class
        Student s1 = new Student();
        s1.setvalues(); // Setting values
        s1.display(); // Displaying values
    }
}