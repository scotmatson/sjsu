package partB;

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
        // Will print output1 because it uses polymorphism to create a SavingsAccount object
        //  of type BankAccount
        BankAccount ba = new SavingsAccount(2.5);
        // Will print output2 bc it is not of type BankAccount
        SavingsAccount sa = new SavingsAccount(3.0);

        testMethod()
        // This will not work. While these two objects share a relationship,
        //  they are not of the same type.
        //ba.testMethod(sa);
    }

    public void testMethod(BankAccount a) {
        System.out.println("Output 1");
    }

    public void testMethod(SavingsAccount a) {
        System.out.println("Output 2");
    }
}