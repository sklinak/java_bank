import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Банковская система ===");
            System.out.println("1. Открыть счёт");
            System.out.println("2. Положить деньги");
            System.out.println("3. Снять деньги");
            System.out.println("4. Показать баланс");
            System.out.println("5. Показать транзакции");
            System.out.println("6. Поиск счёта по атрибутам");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод! Введите число.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите ИНН: ");
                    String inn = sc.nextLine().trim();
                    System.out.print("Введите БИК: ");
                    String bik = sc.nextLine().trim();
                    System.out.print("Введите КПП: ");
                    String kpp = sc.nextLine().trim();

                    if (inn.isEmpty() || bik.isEmpty() || kpp.isEmpty()) {
                        System.out.println("ИНН, БИК и КПП не могут быть пустыми!");
                        break;
                    }

                    String accountId = bank.openAccount(inn, bik, kpp);
                    System.out.println("Номер вашего счёта: " + accountId);
                }

                case 2 -> {
                    System.out.print("Введите номер счёта: ");
                    String accNum = sc.nextLine().trim();
                    if (accNum.isEmpty()) {
                        System.out.println("Номер счёта не может быть пустым!");
                        break;
                    }

                    System.out.print("Сумма пополнения: ");
                    double amount;
                    try {
                        amount = sc.nextDouble();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Неверная сумма! Введите число.");
                        sc.nextLine();
                        break;
                    }

                    if (amount <= 0) {
                        System.out.println("Сумма должна быть положительной!");
                        break;
                    }

                    bank.deposit(accNum, amount);
                }

                case 3 -> {
                    System.out.print("Введите номер счёта: ");
                    String accNum = sc.nextLine().trim();
                    if (accNum.isEmpty()) {
                        System.out.println("Номер счёта не может быть пустым!");
                        break;
                    }

                    System.out.print("Сумма снятия: ");
                    double amount;
                    try {
                        amount = sc.nextDouble();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Неверная сумма! Введите число.");
                        sc.nextLine();
                        break;
                    }

                    if (amount <= 0) {
                        System.out.println("Сумма должна быть положительной!");
                        break;
                    }

                    bank.withdraw(accNum, amount);
                }

                case 4 -> {
                    System.out.print("Введите номер счёта: ");
                    String accNum = sc.nextLine().trim();
                    if (accNum.isEmpty()) {
                        System.out.println("Номер счёта не может быть пустым!");
                        break;
                    }
                    bank.showBalance(accNum);
                }

                case 5 -> {
                    System.out.print("Введите номер счёта: ");
                    String accNum = sc.nextLine().trim();
                    if (accNum.isEmpty()) {
                        System.out.println("Номер счёта не может быть пустым!");
                        break;
                    }
                    bank.showTransactions(accNum);
                }

                case 6 -> {
                    System.out.print("Введите часть ИНН, БИК или КПП: ");
                    String query = sc.nextLine().trim();
                    if (query.isEmpty()) {
                        System.out.println("Поисковый запрос не может быть пустым!");
                        break;
                    }
                    bank.search(query);
                }

                case 0 -> {
                    System.out.println("До свидания!");
                    return;
                }

                default -> System.out.println("Неверный выбор! Введите число от 0 до 6.");
            }
        }
    }
}
