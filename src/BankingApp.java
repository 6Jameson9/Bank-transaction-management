// 6. Create a user interface (optional).
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BankingApp {
    public static void main(String[] args) {
        // Creation of an entity (banking transaction management system)
        BankingTransactionSystem transactionSystem = new BankingTransactionSystem();

        // Creating accounts and registering observers
        Account account1 = new CheckingAccount("1234", 1000.0);
        Account account2 = new CreditCardAccount("4321", 500.0);
        Observer client1 = new Client("Client 1");
        Observer admin1 = new Administrator("Admin 1");

        transactionSystem.registerObserver(client1);
        transactionSystem.registerObserver(admin1);

        transactionSystem.addAccount(account1);
        transactionSystem.addAccount(account2);

        // Creating banking transaction logic
        BankingTransactionLogic transactionLogic = new BankingTransactionLogic(transactionSystem);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Top up your account");
            System.out.println("[2] Withdrawal from account");
            System.out.println("[3] Проверка баланса");
            System.out.println("[4] Exit the program");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.println("Enter the amount to top up: ");
                    double amount = scanner.nextDouble();
                    Account selectedAccount = findAccountByNumber(transactionSystem.getAccounts(), accountNumber);
                    if (selectedAccount != null) {
                        transactionLogic.deposit(selectedAccount, amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.println("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    selectedAccount = findAccountByNumber(transactionSystem.getAccounts(), accountNumber);
                    if (selectedAccount != null) {
                        transactionLogic.withdraw(selectedAccount, amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    // Проверка баланса
                    for (Account account : transactionSystem.getAccounts()) {
                        System.out.println("Account " + account.getAccountNumber() + " Balance: " + account.getBalance() + " tenge.");
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static Account findAccountByNumber(List<Account> accounts, String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}