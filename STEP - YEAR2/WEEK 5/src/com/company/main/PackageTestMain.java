// File: com/company/main/PackageTestMain.java
package com.company.main;

import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(1, "Cross", 2.5, true);

        System.out.println("=== Access from different package (no inheritance) ===");

        // ❌ private - NOT accessible
        // System.out.println(obj.privateField); // ERROR
        // obj.privateMethod(); // ERROR

        // ❌ default - NOT accessible outside package
        // System.out.println(obj.defaultField); // ERROR
        // obj.defaultMethod(); // ERROR

        // ❌ protected - NOT accessible by just object reference in different package
        // System.out.println(obj.protectedField); // ERROR
        // obj.protectedMethod(); // ERROR

        // ✅ public - accessible everywhere
        System.out.println("publicField = " + obj.publicField);
        obj.publicMethod();

        // Explanation:
        System.out.println("\nOnly PUBLIC members are accessible across packages without inheritance.");
    }
}
