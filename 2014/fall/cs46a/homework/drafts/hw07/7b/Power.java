
/**
 * Write a description of class Power here.
 * 
 * @author (Scot Matson) 
 * @version (20141015)
 */
public class Power
{
    private int base;
    private int largestPower;
    
    public Power(int theBase)
    {
        base = theBase;
    }

    /**
     * Gets the largest number that is a power of the base and also 
     * less than n
     * @param n  base^x is largest less than n
     * @return largest number that is a power of the base and also 
     * less than n or else return -1 if n is not a positive integer or base is not a positive integer or base is 
     * greater than  or equal to n
     */
    public int getLargestPower(int n)
    {
        if (base >= n) {
            int i;
            for (i = 1; i < n; i *= n) {
                largestPower = i;
            }
        }
        else {
            largestPower = 0;
        }
        return largestPower;
    }
}
