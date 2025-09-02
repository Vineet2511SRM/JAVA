/**
 * Assignment 1: Personal Finance Manager
 * Author: Vineet Seth
 * Description: A basic personal finance management system to track income, 
 * expenses, and savings for individuals using OOP principles.
 */

import java.util.*;

/**
 * Represents a personal account in the finance manager system.
 */
class PersonalAccount {
    // Private instance variables (encapsulation)
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables shared across all accounts
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";

    // Constructor
    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    /**
     * Adds income to the account.
     * @param amount amount of income
     * @param description income description
     */
    public void addIncome(double amount, String description) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Income must be greater than zero.");
            }
            currentBalance += amount;
            totalIncome += amount;
            System.out.println(accountHolderName + " received income: ₹" + amount + " (" + description + ")");
        } catch (Exception e) {
            System.out.println("Error adding income: " + e.getMessage());
        }
    }

    /**
     * Adds an expense to the account.
     * @param amount amount of expense
     * @param description expense description
     */
    public void addExpense(double amount, String description) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Expense must be greater than zero.");
            }
            if (amount > currentBalance) {
                throw new IllegalArgumentException("Insufficient balance for this expense.");
            }
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println(accountHolderName + " spent: ₹" + amount + " (" + description + ")");
        } catch (Exception e) {
            System.out.println("Error adding expense: " + e.getMessage());
        }
    }

    /**
     * Calculates savings (income - expenses).
     * @return savings value
     */
    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    /**
     * Displays account summary.
     */
    public void displayAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + currentBalance);
        System.out.println("Total Income: ₹" + totalIncome);
        System.out.println("Total Expenses: ₹" + totalExpenses);
        System.out.println("Total Savings: ₹" + calculateSavings());
    }

    // ---------- Static Methods ----------
    /**
     * Sets the bank name for all accounts.
     * @param name bank name
     */
    public static void setBankName(String name) {
        bankName = name;
    }

    /**
     * Returns total number of accounts created.
     * @return total accounts
     */
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    /**
     * Generates a unique account number.
     * @return unique account number
     */
    public static String generateAccountNumber() {
        return "ACC" + (1000 + totalAccounts + 1);
    }
}


/**
 * Main driver class for the Personal Finance Manager.
 */
public class Assignment1_VineetSeth {
    public static void main(String[] args) {
        // Setting bank name
        PersonalAccount.setBankName("SRM Finance Bank");

        // Creating multiple accounts
        PersonalAccount acc1 = new PersonalAccount("Aarav Sharma");
        PersonalAccount acc2 = new PersonalAccount("Meera Patel");
        PersonalAccount acc3 = new PersonalAccount("Vineet Seth");

        // Transactions for Account 1
        acc1.addIncome(5000, "Salary");
        acc1.addExpense(1200, "Groceries");
        acc1.addExpense(2000, "Rent");

        // Transactions for Account 2
        acc2.addIncome(8000, "Freelance Project");
        acc2.addExpense(3000, "Shopping");
        acc2.addExpense(1500, "Bills");

        // Transactions for Account 3
        acc3.addIncome(10000, "Scholarship");
        acc3.addExpense(2500, "Laptop EMI");
        acc3.addExpense(1000, "Food");

        // Display summaries
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        // Demonstrating static vs instance variables
        System.out.println("\n--- Static vs Instance Demo ---");
        System.out.println("Total Accounts Created: " + PersonalAccount.getTotalAccounts());
        System.out.println("Bank Name shared across all accounts: " + "SRM Finance Bank");
    }
}
