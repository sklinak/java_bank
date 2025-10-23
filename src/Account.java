import java.util.UUID;

public class Account {
    // Unique account number
    private String accountNumber;
    // Tax ID (INN), Bank ID (BIK), KPP (another bank code)
    private String inn;
    private String bik;
    private String kpp;
    // Current balance of the account
    private double balance;

    // Constructor: create a new account with given details
    public Account(String inn, String bik, String kpp) {
        this.inn = inn;
        this.bik = bik;
        this.kpp = kpp;
        this.balance = 0.0;

        // Generate a unique account number
        // UUID.randomUUID() creates a random unique identifier
        // substring(0,6) takes only first 6 characters to make it shorter
        this.accountNumber = "ACC" + UUID.randomUUID().toString().substring(0, 6);
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getters for account attributes
    public String getInn() { return inn; }
    public String getBik() { return bik; }
    public String getKpp() { return kpp; }
    public double getBalance() { return balance; }

    // Deposit money into the account
    public void deposit(double amount) { 
        balance += amount; 
    }

    // Withdraw money from the account
    // Returns true if successful, false if not enough balance
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Custom string representation of the account
    @Override
    public String toString() {
        return "Счёт: " + accountNumber + ", ИНН: " + inn + ", БИК: " + bik + ", КПП: " + kpp + ", Баланс: " + balance;
    }
}
