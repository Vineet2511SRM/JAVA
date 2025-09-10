// File: com/company/extended/ExtendedDemo.java
package com.company.extended;

import com.company.security.AccessModifierDemo;

public class ExtendedDemo extends AccessModifierDemo {

    // Constructor calls parent constructor
    public ExtendedDemo(int privateVal, String defaultVal, double protectedVal, boolean publicVal) {
        super(privateVal, defaultVal, protectedVal, publicVal);
    }

    public void testInheritedAccess() {
        System.out.println("=== Access from subclass in different package ===");

        // ❌ private - NOT inherited, not accessible
        // System.out.println(privateField); // ERROR
        // privateMethod(); // ERROR

        // ❌ default - not visible outside package
        // System.out.println(defaultField); // ERROR
        // defaultMethod(); // ERROR

        // ✅ protected - accessible via inheritance (directly in subclass)
        System.out.println("protectedField = " + protectedField);
        protectedMethod();

        // ✅ public - always accessible
        System.out.println("publicField = " + publicField);
        publicMethod();
    }

    // Overriding protected method from parent
    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method in ExtendedDemo called");
    }

    public static void main(String[] args) {
        ExtendedDemo child = new ExtendedDemo(5, "Inherit", 8.8, false);
        AccessModifierDemo parent = new AccessModifierDemo(9, "Parent", 7.7, true);

        // Child class accesses protected + public (inherited ones)
        child.testInheritedAccess();

        System.out.println("\n=== Comparing parent vs child objects ===");

        // Parent object across package → only public works
        System.out.println("From parent object:");
        parent.publicMethod();

        // Child object (subclass) → can access protected + public
        System.out.println("\nFrom child object:");
        child.protectedMethod();  // overridden
        child.publicMethod();
    }
}
