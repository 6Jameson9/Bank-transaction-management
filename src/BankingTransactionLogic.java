// 5. We implement the logic of banking transactions and balance monitoring.

class BankingTransactionLogic {
    private BankingTransactionSystem transactionSystem;

    public BankingTransactionLogic(BankingTransactionSystem transactionSystem) {
        this.transactionSystem = transactionSystem;
    }

    public void performTransaction(Account account, double amount) {
        // Logic for executing the transaction and updating the balance
        String message = "Account transaction " + account.getAccountNumber() + ": " + amount + " tenge.";
        account.deposit(amount);
        transactionSystem.notifyObservers(message);
    }
    public void deposit(Account account, double amount) {

        account.deposit(amount);
        String message = "Top up your account " + account.getAccountNumber() + ": +" + amount + " tenge.";
        transactionSystem.notifyObservers(message);
    }

    public void withdraw(Account account, double amount) {

        if (account.getBalance() >= amount) {
            account.withdraw(amount);
            String message = "Withdrawal from account " + account.getAccountNumber() + ": -" + amount + " tenge.";
            transactionSystem.notifyObservers(message);
        } else {
            String message = "Insufficient funds in the account " + account.getAccountNumber() + " to withdraw " + amount + " tenge.";
            transactionSystem.notifyObservers(message);
        }
    }
}
