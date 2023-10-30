class CreditCardAccount implements Account {
    private String accountNumber;
    private double balance;

    public CreditCardAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        // Credit card replenishment
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        // Credit card withdrawals
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}