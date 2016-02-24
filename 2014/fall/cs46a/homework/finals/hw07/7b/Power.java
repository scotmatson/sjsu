
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
     * Gets the largest number that is a power of the base and also less than n
     * @param n  base^x is largest less than n
     * @return largest number that is a power of the base and also 
     * less than n or else return -1 if the largest number does not exist
     */
    public int getLargestPower(int n)
    {
        if (base == 1) { // Handles cases of base 1
            return 1;
        }
        else if (n > 1 && base > 0) {

            int currentPower = 1; //This will limit the number of times we iterate the outside loop
            int i, j;
            for (i = 1; currentPower < n; i++) { //i is the exponent being iterated
                if (base >= n) {
                    return 1; // Handles cases where exponent would have to be 0
                }
                currentPower = 1; //Need to flush currentPower for each iteration
                for (j = 1; j <= i; ++j) { //j is the number of iterations of i
                    currentPower *= base;
                    //Store the largest power from this cycle which does not
                    //exceed our nth value.
                    if (currentPower < n) {
                        largestPower = currentPower;
                    }
                }
            }

        }
        else {
            return -1;
        }

        return largestPower;
    }
}
