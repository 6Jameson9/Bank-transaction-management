// 5. We implement the logic of banking transactions and balance monitoring.

class BankingTransactionLogic {
    private BankingTransactionSystem transactionSystem;

    public BankingTransactionLogic(BankingTransactionSystem transactionSystem) {
        this.transactionSystem = transactionSystem;
    }

    public void performTransaction(Account account, double amount) {
        // Logic for executing the transaction and updating the balance
        String message = "Account transaction " + account.getAccountNumber() + ": " + amount + " рублей.";
        account.deposit(amount);
        transactionSystem.notifyObservers(message);
    }
    public void deposit(Account account, double amount) {
        // Логика пополнения счета
        account.deposit(amount);
        String message = "Пополнение счета " + account.getAccountNumber() + ": +" + amount + " рублей.";
        transactionSystem.notifyObservers(message);
    }

    public void withdraw(Account account, double amount) {
        // Логика снятия средств со счета
        if (account.getBalance() >= amount) {
            account.withdraw(amount);
            String message = "Снятие со счета " + account.getAccountNumber() + ": -" + amount + " рублей.";
            transactionSystem.notifyObservers(message);
        } else {
            String message = "Недостаточно средств на счете " + account.getAccountNumber() + " для снятия " + amount + " рублей.";
            transactionSystem.notifyObservers(message);
        }
    }
}