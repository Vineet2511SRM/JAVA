// File: AccessModifierDemo.java
package com.company.security;

public class AccessModifierDemo {
    // Fields with different access levels
    private int privateField;          // only within this class
    String defaultField;               // package-private (default)
    protected double protectedField;   // package + subclasses
    public boolean publicField;        // accessible everywhere

    // Methods with different access levels
    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Constructor to initialize fields
    public AccessModifierDemo(int privateField, String defaultField,
                              double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    // Method to show internal access to everything
    public void testInternalAccess() {
        System.out.println("Accessing all fields inside the class:");
        System.out.println("privateField = " + privateField);
        System.out.println("defaultField = " + defaultField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField = " + publicField);

        System.out.println("\nCalling all methods inside the class:");
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "Hello", 99.9, true);

        // Access from SAME CLASS
        System.out.println("Access from main (same class):");

        // Works: public
        System.out.println("publicField = " + obj.publicField);
        obj.publicMethod();

        // Works: default (same package, but also same class so allowed)
        System.out.println("defaultField = " + obj.defaultField);
        obj.defaultMethod();

        // Works: protected (same class)
        System.out.println("protectedField = " + obj.protectedField);
        obj.protectedMethod();

        // Works: private (same class)
        System.out.println("privateField = " + obj.privateField);
        obj.privateMethod();

        // Demonstrate all internal access
        System.out.println("\n=== testInternalAccess() Demo ===");
        obj.testInternalAccess();
    }
}


// Second class in SAME PACKAGE
class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo obj = new AccessModifierDemo(20, "World", 45.6, false);

        System.out.println("\nAccess from SamePackageTest (same package):");

        // ❌ private - NOT accessible
        // System.out.println(obj.privateField); // ERROR
        // obj.privateMethod(); // ERROR

        // ✅ default - accessible in same package
        System.out.println("defaultField = " + obj.defaultField);
        obj.defaultMethod();

        // ✅ protected - accessible in same package
        System.out.println("protectedField = " + obj.protectedField);
        obj.protectedMethod();

        // ✅ public - accessible everywhere
        System.out.println("publicField = " + obj.publicField);
        obj.publicMethod();
    }
}  