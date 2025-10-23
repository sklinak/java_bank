import java.util.Date;

public class Transaction {
    private String accountNumber; // Account identifier for which this transaction belongs
    private String type;          // Type of transaction
    private double amount;        // Amount of money in the transaction
    private Date date;            // Date and time when transaction occurred

    // Constructor: creates a new transaction and sets current date
    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = new Date(); // current date and time
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for transaction type
    public String getType() {
        return type;
    }

    // Getter for transaction amount
    public double getAmount() {
        return amount;
    }

    // Getter for transaction date
    public Date getDate() {
        return date;
    }

    // Converts the transaction object into a readable string
    @Override
    public String toString() {
        return date + " — " + type + ": " + amount;
    }
}
