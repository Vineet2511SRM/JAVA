package WEEK6.LAB;

// Parent class
class Phone {
    protected String brand;
    protected String model;

    // Default constructor
    public Phone() {
        System.out.println("-- Phone default constructor called --");
    }

    // Parameterized constructor
    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("-- Phone parameterized constructor called --");
    }

    public void showPhoneInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model);
    }
}

// Child class
class SmartPhone extends Phone {
    private String operatingSystem;

    // Default constructor
    public SmartPhone() {
        super(); // calls Phone default constructor
        System.out.println("-- SmartPhone default constructor called --");
    }

    // Parameterized constructor
    public SmartPhone(String brand, String model, String os) {
        super(brand, model); // calls Phone parameterized constructor
        this.operatingSystem = os;
        System.out.println("-- SmartPhone parameterized constructor called --");
    }

    public void showSmartPhoneInfo() {
        System.out.println("Brand: " + brand +
                ", Model: " + model +
                ", OS: " + operatingSystem);
    }
}

// Tester class
public class LabProblem2 {
    public static void main(String[] args) {
        System.out.println("---- Case 1: Using default constructors ----");
        SmartPhone s1 = new SmartPhone();   // Calls default constructors
        s1.showSmartPhoneInfo();

        System.out.println("\n---- Case 2: Using parameterized constructors ----");
        SmartPhone s2 = new SmartPhone("Apple", "iPhone 15", "iOS");
        s2.showSmartPhoneInfo();

        System.out.println("\n---- Case 3: Another parameterized object ----");
        SmartPhone s3 = new SmartPhone("Samsung", "Galaxy S25", "Android");
        s3.showSmartPhoneInfo();
    }
}
