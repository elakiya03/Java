package inheritance;

// 1. THE SINGLE PARENT BASE CLASS
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Account [" + accountNumber + "] | Safe Balance: ₹" + balance);
    }
}

// 2. CHILD CLASS 1 (Branches down from BankAccount)
class SavingsAccount extends BankAccount {
    private double interestRate = 0.04; // 4% Interest addition specialized trait

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance); // Triggers Parent constructor setup
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Savings Update: Applied ₹" + interest + " interest earnings.");
    }
}

// 3. CHILD CLASS 2 (Branches down from the EXACT SAME Parent BankAccount)
class CheckingAccount extends BankAccount {
    private double transactionFee = 20.00; // Specialized transaction penalty trait

    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance); // Triggers Parent constructor setup
    }

    public void writeCheck(double amount) {
        if (balance >= (amount + transactionFee)) {
            balance -= (amount + transactionFee);
            System.out.println("Checking Update: Processed check for ₹" + amount + " (Fee: ₹" + transactionFee + ")");
        } else {
            System.out.println("Error: Insufficient funds for check transmission!");
        }
    }
}

public class Hierarchical {
    public static void main(String[] args) {
        System.out.println("--- Instantiating Sibling Nodes (Hierarchical Split) ---");

        // Creating Child 1 object instance
        SavingsAccount savings = new SavingsAccount("SAV-999", 50000.00);

        // Creating Child 2 object instance
        CheckingAccount checking = new CheckingAccount("CHK-111", 10000.00);

        System.out.println("\n--- Interacting with Savings Branch ---");
        savings.checkBalance(); // Uses Inherited Parent Method
        savings.applyInterest(); // Uses Specialized Child 1 Method
        savings.checkBalance(); // Verifies updated state

        System.out.println("\n--- Interacting with Checking Branch ---");
        checking.checkBalance(); // Uses Inherited Parent Method
        checking.writeCheck(2000.00); // Uses Specialized Child 2 Method
        checking.checkBalance(); // Verifies updated state
    }
}
