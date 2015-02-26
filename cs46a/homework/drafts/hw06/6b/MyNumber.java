
/**
 * Receives a natural number as input and performs basic calculations.
 * 
 * @author (Scot Matson) 
 * @version (20141009)
 */
public class MyNumber
{
    private int number;

    /**
     * Constructor for objects of class MyNumber
     * @param theNumber the value for this object
     */
    public MyNumber(int theNumber)
    {
       //Ensures only a natural number is used
       number = Math.abs(theNumber);
    }
    
    /**
     * gets the sum of all the odd positive numbers less than or equal to number
     * @return oddSum the sum of all odd natural numbers
     */
    public int getOddSum() {
        int oddSum = 0;
        
        return oddSum;
    }
    
    /**
     * Gets the largest power of 2 that is less than the number
     * @return largestPower the largest power of two less than number
     */
    public int largestPowerOfTwo() {
        int largestPower = 0;
        
        if (number < 2) {
            largestPower = -1;
        }
        else {
            largestPower = 0;
        }
        return largestPower;
    }
    
    /**
     * Sets a new value for this Number
     * @param value the new value of the Number
     */
    public void setNumber(int value)
    {
        number = value;
    }
}
