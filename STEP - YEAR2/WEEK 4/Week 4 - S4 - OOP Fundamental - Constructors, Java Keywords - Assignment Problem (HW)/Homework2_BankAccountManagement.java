/**
 * Program Name: Homework2_BankAccountManagement.java
 * Author: Vineet Seth
 * Description: Bank Account Management System demonstrating constructor overloading,
 * deposit, withdrawal, and account display functionality.
 */

import java.util.Random;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    private static Random rand = new Random();

    // 1. Default constructor
    public BankAccount() {
        this("Unknown", 0);
    }

    // 2. Constructor with account holder name → random account number
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = 100000 + rand.nextInt(900000); // 6-digit account number
        this.balance = 0;
    }

    // 3. Constructor with name and initial balance
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = 100000 + rand.nextInt(900000);
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Display account details
    public void displayAccount() {
        System.out.println("----------- Bank Account -----------");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs " + balance);
        System.out.println("-----------------------------------\n");
    }
}

// Main class
public class Homework2_BankAccountManagement {
    public static void main(String[] args) {
        // Creating accounts
        BankAccount acc1 = new BankAccount(); // default
        BankAccount acc2 = new BankAccount("Vineet"); // random account number
        BankAccount acc3 = new BankAccount("Anuj", 5000); // name + initial balance

        // Deposit & Withdraw operations
        acc2.deposit(2000);
        acc3.withdraw(1000);
        acc3.deposit(500);

        // Display accounts
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();
    }
}
