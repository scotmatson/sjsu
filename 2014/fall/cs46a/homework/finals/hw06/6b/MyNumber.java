
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
        number = theNumber;
    }

    /**
     * gets the sum of all the odd positive numbers less than or equal to number
     * @return oddSum the sum of all odd natural numbers
     */
    public int getOddSum() {
        int oddSum = 0;
        int i;

        for (i = 1; i <= number; i += 2) {
            oddSum += i;
        }

        return oddSum;
    }

    /**
     * Gets the largest power of 2 that is less than the number
     * @return largestPower the largest power of two less than number
     */
    public int laregestPowerOfTwo() {
        int largestPower = -1;
        int i;

        if (number >= 1) {
            for (i = 1; i < number; i *= 2) {
                if (i < number) { largestPower = i; }
            }
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
