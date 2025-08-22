public class BankAccount {
   // TODO: Create static variables:
    private static String bankName; // same for all accounts
    private static int totalAccounts = 0; // count of all accounts created
    private static double interestRate; // same rate for all accounts

    // TODO: Create instance variables:
    private String accountNumber; // unique for each account
    private String accountHolder; // unique for each account
    private double balance; // unique for each account

    // TODO: Create constructor that:
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        // Initializing instance variables
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++; // Increment total accounts whenever a new account is created
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("-----------------------------");
    }

    // Instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + " deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
        System.out.println("-----------------------------");
    }

    // Main method
    public static void main(String[] args) {
        // Set bank-wide static info
        BankAccount.setBankName("Global Bank");
        BankAccount.setInterestRate(5.0);

        // Display bank info before any accounts
        BankAccount.displayBankInfo();

        // Create multiple accounts (instance members)
        BankAccount acc1 = new BankAccount("A101", "Alice", 1000);
        BankAccount acc2 = new BankAccount("B202", "Bob", 2000);
        BankAccount acc3 = new BankAccount("C303", "Charlie", 1500);

        // Show that static members are shared
        BankAccount.displayBankInfo(); // Total accounts now updated

        // Show instance members – unique per account
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();

        // Demonstrate instance methods
        acc1.deposit(500);
        acc2.withdraw(300);

        // Show updated balances
        System.out.println("Updated Balances:");
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

       
        // TODO: Demonstrate calling static methods with and without objects
        System.out.println("Calling static method via class:");
        BankAccount.displayBankInfo(); // Recommended

        System.out.println("Calling static method via object (not recommended but works):");
        acc1.displayBankInfo(); // Works, but uses class-level data
    }
}