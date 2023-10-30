import java.util.ArrayList;
import java.util.List;

// 4. Creating classes for subjects (bank transaction management system and accounts).
class BankingTransactionSystem implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void processTransaction(Account account, double amount) {
        // Conducting a banking transaction, such as checking balances and updating accounts
        if (accounts.contains(account)) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                String message = "Account transaction completed " + account.getAccountNumber() + ": -" + amount + " tenge.";
                notifyObservers(message);
            } else {
                String message = "Account " + account.getAccountNumber() + " does not have sufficient funds for the transaction.";
                notifyObservers(message);
            }
        }
    }

    public void monitorBalances() {
        // Method for monitoring the balances of all accounts and generating notifications if necessary
        for (Account account : accounts) {
            if (account.getBalance() < 0) {
                String message = "Account " + account.getAccountNumber() + " has a negative balance: " + account.getBalance() + " tenge.";
                notifyObservers(message);
            }
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
