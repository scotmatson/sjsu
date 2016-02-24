
/**
 * Models an account at a bank to which money can be added and removed.
 */
public class BankAccount
{
   public static final double BONUS = 100;
   private double balance;
   
   /**
    * Constructs a BankAccount object given an opening balance
    * @param initialBalance the opening balance of the account
    */
   public BankAccount(double initialBalance)
   {
       if (initialBalance < 0) { balance = BONUS; }
       else { balance = initialBalance + BONUS; }
   }
   
   /**
    * The current customer account balance
    * @return balance the current account balance
    */
   public double getBalance()
   {
       return balance;
   }
   
   /**
    * Adds amount to the balance if amount is greater than 0
    * @param amount amount deposited by customer
    */
    public void deposit(double amount)
    {
       if (amount > 0) { balance = balance + amount; } 
    }
    
   /**
    * Withdraws money from the account
    * @param amount the amount to withdraw

    */
    public void withdraw(double amount)
    {
       if (amount > 0) { balance = balance - amount; }
    }
}
