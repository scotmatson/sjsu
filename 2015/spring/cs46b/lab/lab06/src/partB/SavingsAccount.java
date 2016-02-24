import partB.BankAccount;

/**
 An account that earns interest at a fixed rate.
 */
public class SavingsAccount extends BankAccount
{
    private double interestRate;

    /**
     Constructs a bank account with a given interest rate.
     @param rate the interest rate
     */
    public SavingsAccount(double rate)
    {
        interestRate = rate;
    }

    /**
     Adds the earned interest to the account balance.
     */
    public void addInterest()
    {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }


    public static void main(String[] args)
    {
        BankAccount ba = new SavingsAccount(2.5);
        SavingsAccount sa = new SavingsAccount(3.0);


        // This line of code which has been commented will not work because while we have created a SavingsAccount
        //   object, we have used a BankAccount class. The BankAccount class does not know of methods which exist
        //   in the SavingsAccount class so to use them we would have to use a cast and turn our SavingsAccount object
        //   into a SavingsAccount Type. This is an example of PolyMorphism.
        //ba.testMethod(sa);
    }

    public void testMethod(BankAccount a)
    {
        System.out.println("Output 1");
    }

    public void testMethod(SavingsAccount a)
    {
        System.out.println("Output 2");
    }
}