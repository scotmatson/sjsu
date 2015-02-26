/**
 * Models a Precious metal commodity
 */
public class PreciousMetal
{
    private String metalType;
    private double currentPrice;
    
    
    /**
     * Constructs a Precious metal of the given tyoe and curent price
     * @param theType the type of this PreciousMetal
     * @param initalPrice the inital price of this PreciousMetal
     */
    public PreciousMetal(String theType, double initialPrice)
    {
        metalType = theType;
        currentPrice = initialPrice;
    }
    
    /**
     * Gets the current price of this PreciousMetal
     * @return current price of this PreciousMetal
     */
    public double getPrice()
    {
        return currentPrice;
    }
    
    /**
     * Gets the type of this PreciousMetal
     * @return the type of this PreciousMetal
     */
    public String getType()
    {
        return null;
    }
    
    /**
     * Increases the price by the specified amount
     * @param amount the amount to raise the price by
     */
    public void increasePrice(double amount)
    {
        
    }

    /**
     * Decrease the price by the specified amount
     * @param amount the amount to decrease the price by
     */    
    public void decreasePrice(double amount) 
    {
        
    }
}

