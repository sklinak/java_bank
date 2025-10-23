import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankService {
    // List of all accounts
    private List<Account> accounts = new ArrayList<>();
    // List of all transactions
    private List<Transaction> transactions = new ArrayList<>();

    // Open a new account
    public String openAccount(String inn, String bik, String kpp) {
        Account newAcc = new Account(inn, bik, kpp);
        accounts.add(newAcc);
        System.out.println("Счёт успешно открыт!");
        return newAcc.getAccountNumber(); // return the account number
    }

    // Find account by account number
    public Account findAccountByNumber(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    // Deposit money into account
    public void deposit(String accountNumber, double amount) {
        Account acc = findAccountByNumber(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
            transactions.add(new Transaction(accountNumber, "Пополнение", amount));
            System.out.println("Счёт пополнен на " + amount);
        } else {
            System.out.println("Счёт не найден!");
        }
    }

    // Withdraw money from account
    public void withdraw(String accountNumber, double amount) {
        Account acc = findAccountByNumber(accountNumber);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                transactions.add(new Transaction(accountNumber, "Снятие", amount));
                System.out.println("Снято " + amount);
            } else {
                System.out.println("Недостаточно средств!");
            }
        } else {
            System.out.println("Счёт не найден!");
        }
    }

    // Show account balance
    public void showBalance(String accountNumber) {
        Account acc = findAccountByNumber(accountNumber);
        if (acc != null) {
            System.out.println("Баланс: " + acc.getBalance());
        } else {
            System.out.println("Счёт не найден!");
        }
    }

    // Show all transactions for a specific account
    public void showTransactions(String accountNumber) {
        List<Transaction> userTrans = transactions.stream()
                .filter(t -> t.getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList());

        if (userTrans.isEmpty()) {
            System.out.println("Транзакций нет.");
        } else {
            for (Transaction t : userTrans) {
                System.out.println(t);
            }
        }
    }

    // Search accounts by INN, BIK, or KPP
    public void search(String query) {
        List<Account> found = accounts.stream()
                .filter(a -> a.getInn().contains(query) || a.getBik().contains(query) || a.getKpp().contains(query))
                .collect(Collectors.toList());

        if (found.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Account acc : found) {
                System.out.println(acc);
            }
        }
    }
}
