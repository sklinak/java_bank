# java_bank
A simple console-based banking system in Java.  Users can open accounts, deposit and withdraw money, check balances, view transactions, and search accounts by attributes.  The program handles invalid input and ensures basic data validation.

Конечно! Вот готовый вариант для файла `README.md`, который можно просто вставить в репозиторий:

````markdown
# Simple Java Banking System

A console-based banking system written in Java.  
This project allows users to create accounts, deposit and withdraw money, check balances, view transaction history, and search accounts by attributes such as INN, BIK, or KPP.

---

## Features

- Open a new bank account with INN, BIK, and KPP.  
- Deposit and withdraw money with validation (no negative amounts).  
- Check account balance.  
- View all transactions for a specific account.  
- Search accounts by partial INN, BIK, or KPP.  
- Handles invalid input and edge cases (e.g., account not found, empty input).  

---

## How to Run

1. Make sure you have **Java 17** or higher installed.  
2. Clone the repository:

```bash
git clone <your-repo-url>
cd <repo-folder>
````

3. Compile the project:

```bash
javac -d out src/*.java
```

4. Run the application:

```bash
java -cp out Main
```

5. Follow the console menu to interact with the system.

---

## Example

```
=== Banking System ===
1. Open account
2. Deposit money
3. Withdraw money
4. Show balance
5. Show transactions
6. Search account by attributes
0. Exit
Your choice: 1
Enter INN: 123456
Enter BIK: 654321
Enter KPP: 111222
Account successfully opened!
Your account number: ACCabc123
```

---

## Logic Overview

* **Account class:** Represents a bank account with a unique account number, INN, BIK, KPP, and balance. Supports deposit and withdrawal.
* **Transaction class:** Represents a deposit or withdrawal with a timestamp.
* **BankService class:** Manages accounts and transactions, provides methods to handle all banking operations.
* **Main class:** Provides a console-based menu for user interaction. Uses `Scanner` to get input from the user.

---

## Notes

* Account numbers are automatically generated using `UUID`.
* All inputs are validated to prevent empty values or negative amounts.
* Transactions are stored in memory and linked to account numbers.


