// Bank Account class


class BankAccount {
    // Instance variables -> unique for each account
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Static variable -> shared among all accounts
    private static int totalAccounts = 0;

    // Constructor -> called when a new account is created
    public BankAccount(String name, double initialDeposit) {
        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative. Balance set to 0.");
            initialDeposit = 0;
        }
        this.accountHolderName = name;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;  // increase the counter when a new account is created
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println(amount + " deposited into " + accountNumber);
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds in " + accountNumber);
            return;
        }
        balance -= amount;
        System.out.println(amount + " withdrawn from " + accountNumber);
    }

    // Method to check current balance
    public void checkBalance() {
        System.out.println("Balance in " + accountNumber + " = " + balance);
    }

    // Method to display all account details
    public void displayAccountInfo() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : " + balance);
        System.out.println("----------------------------");
    }

    // Static method -> returns total number of accounts created
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Static method -> generates a unique account number
    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", totalAccounts + 1);
    }


    public static void main(String[] args) {
        // Array to store 3 bank accounts
        BankAccount[] accounts = new BankAccount[3];

        // Creating accounts
        accounts[0] = new BankAccount("Aarav Sharma", 5000);
        accounts[1] = new BankAccount("Priya Singh", 10000);
        accounts[2] = new BankAccount("Rahul Verma", 2000);

        // Display account details
        for (BankAccount acc : accounts) {
            acc.displayAccountInfo();
        }

        // Perform some transactions
        accounts[0].deposit(2000);
        accounts[1].withdraw(3000);
        accounts[2].withdraw(2500);  // will show insufficient funds
        accounts[2].deposit(-100);   // invalid deposit

        // Check balances again
        for (BankAccount acc : accounts) {
            acc.checkBalance();
        }

        // Display static variable (common for all objects)
        System.out.println("Total Accounts Created = " + BankAccount.getTotalAccounts());
    }
}
