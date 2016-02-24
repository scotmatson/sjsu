/**
 * An object representng the bills and coins to give as change
 */
public class Change
{
    private int dollars;
    private int quarters;
    private int dimes;
    private int nickels;
    
    /**
     * Constructs a Change object with the given values
     * @param dollars the number of dollars to give as change
     * @param quarters the number of quarters to give as change
     * @param dimes the number of dimes to give as change
     * @param nickels the number of nickels to give as change
     */
    public Change(int dollars, int quarters, int dimes, int nickels)
    {
        this.dollars = dollars;
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
    }
    
    /**
     * Gets the number of dollars in this Change object
     * @return the number of dollars in this Change object
     */
    public int getDollars()
    {
        return dollars;
    }
    
    /**
     * Gets the number of quarters in this Change object
     * @return the number of quarters in this Change object
     */
    public int getQuarters()
    {
        return quarters;
    }
    
    /**
     * Gets the number of dimes in this Change object
     * @return the number of dimes in this Change object
     */
    public int getDimes()
    {
        return dimes;
    }
    
    /**
     * Gets the number of nickels in this Change object
     * @return the number of nickles in this Change object
     */
    public int getNickels()
    {
        return nickels;
    }
}