/**
 A bank account has a balance that can be changed by
 deposits and withdrawals.
 */
public class BankAccount implements Selectable
{
    private double balance;

    /**
     Constructs a bank account with a zero balance.
     */
    public BankAccount()
    {
        balance = 0;
    }

    /**
     Constructs a bank account with a given balance.
     @param initialBalance the initial balance
     */
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }

    /**
     Deposits money into the bank account.
     @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    /**
     Withdraws money from the bank account.
     @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    /**
     Gets the current balance of the bank account.
     @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }

    public boolean select() {
        boolean isUnder100K = true;
        if (getBalance() > 100000) {
            isUnder100K = false;
        }

        return isUnder100K;
    }
}