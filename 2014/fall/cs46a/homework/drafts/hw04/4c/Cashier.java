/**
 * Models a cashier in a store making a transaction
 * and giving change
 */
public class Cashier
{
    private String name;
    private double owed;
    private double paid;
    
    /**
     * Default constructor creates an alias for the cashier
     * when no account is present is given.
     */
    public Cashier() {
        this.name = "Thomas McAllister";
    }
    
    /**
     * Constructs a new object given the user's
     * name as an argument.
     * @param name is the name of the cashier
     */
    public Cashier(String name) {
        this.name = name;
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
        
    }
    
    /**
     * Takes the amount paid by the customer in excess of the
     * balanace and returns the change in the largest
     * bills/coins possible.
     * @return the customers change
     */
    public Change getChange() {
        Change change = new Change(0, 0, 0, 0);
        return null;
    }
}
