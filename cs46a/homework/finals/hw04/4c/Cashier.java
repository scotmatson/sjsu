/**
 * Models a cashier in a store making a transaction
 * and giving change
 */
public class Cashier
{	
    private String name;
    private double owed;
    private double paid;
    public  static final int DOLLAR = 100;
    public  static final int QUARTER = 25;
    public  static final int DIME = 10;
    public  static final int NICKEL = 5;
    
    /**
     * Constructs a new object given the cashier's
     * name as an argument.
     * @param name is the name of the cashier
     */
    public Cashier(String name) {
        this.name = name;
    }
    /**
     * Default constructor creates an alias for the cashier
     * when no account is present is given.
     */
    public Cashier() {
        this.name = "Thomas McAllister";
    }
    
    /**
     * Gets the name of the cashier.
     * @return the name of the cashier
     */
    public String getName() {
        return name;
    }
    
    /**
     * Given the amount received from the customer,
     * the amount paid and the balance remaining is updated.
     * @param owed the amount still owed
     * @param paid the amount still paid
     */
    public void setCurrentTransaction(double owed, double paid) {
        this.owed = owed;
        this.paid = paid;
    }
    
    /**
     * Takes the amount paid by the customer in excess of the
     * balanace and returns the change in the largest
     * bills/coins possible.
     * @return the customers change
     */
    public Change getChange() {
        int changeDue = (int)Math.round((paid - owed) * 100);
        int dollars, quarters, dimes, nickels;
        dollars = quarters = dimes = nickels = 0;
        
        dollars = changeDue / DOLLAR;
        changeDue %= DOLLAR;
        
        quarters = changeDue / QUARTER;
        changeDue %= QUARTER;
        
        dimes = changeDue / DIME;
        changeDue %= DIME;
        
        nickels = changeDue / NICKEL;
        changeDue %= NICKEL;
        
        Change change = new Change(dollars, quarters, dimes, nickels);
        return change;
    }
}
