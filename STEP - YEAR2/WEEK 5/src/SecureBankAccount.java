public class SecureBankAccount {
    // Private fields
    private final String accountNumber; // read-only
    private double balance;             // controlled updates only
    private int pin;                    // write-only, must validate
    private boolean isLocked;           // lock state
    private int failedAttempts;         // security counter

    // Private constants
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    // Constructor
    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE);
        this.pin = 0; // must be set separately
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    // ===== Account Info Methods =====
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked. Balance cannot be viewed.");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    // ===== Security Methods =====
    public boolean setPin(int oldPin, int newPin) {
        if (pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN updated successfully.");
            return true;
        } else {
            System.out.println("Incorrect old PIN. PIN not changed.");
            return false;
        }
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked. Cannot validate PIN.");
            return false;
        }
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            System.out.println("Incorrect PIN.");
            return false;
        }
    }

    public boolean unlockAccount(int correctPin) {
        if (correctPin == pin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked.");
            return true;
        } else {
            System.out.println("Failed to unlock. Wrong PIN.");
            return false;
        }
    }

    // ===== Transaction Methods =====
    public void deposit(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount + " | New Balance: " + balance);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }
    }

    public void withdraw(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
            }
        }
    }

    public void transfer(SecureBankAccount target, double amount, int pin) {
        if (validatePin(pin)) {
            if (amount <= 0) {
                System.out.println("Transfer amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Insufficient funds for transfer.");
            } else {
                this.balance -= amount;
                target.balance += amount;
                System.out.println("Transferred " + amount + " to Account " + target.getAccountNumber());
                System.out.println("New Balance: " + balance);
            }
        }
    }

    // ===== Private Helpers =====
    private void lockAccount() {
        isLocked = true;
        System.out.println("Account locked due to too many failed attempts!");
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    // ===== Demo in main =====
    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("A1001", 5000);
        SecureBankAccount acc2 = new SecureBankAccount("A1002", 2000);

        System.out.println("=== Secure Bank Account Demo ===");

        // Direct field access (uncommenting will cause compile error)
        // acc1.balance = 999999; // ERROR
        // acc1.pin = 1234;       // ERROR

        // Use methods instead
        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);

        acc1.deposit(1000, 1234);
        acc1.withdraw(2000, 1234);

        acc2.deposit(500, 5678);
        acc2.withdraw(3000, 5678); // insufficient funds

        acc1.transfer(acc2, 1500, 1234);

        // Security breach attempts
        acc1.withdraw(100, 1111); // wrong pin
        acc1.withdraw(100, 2222); // wrong pin
        acc1.withdraw(100, 3333); // wrong pin → locks account

        acc1.withdraw(500, 1234); // locked account

        acc1.unlockAccount(1234); // unlock with correct PIN
        acc1.withdraw(500, 1234); // works now
    }
}
