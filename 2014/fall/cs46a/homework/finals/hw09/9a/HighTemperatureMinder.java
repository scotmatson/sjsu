/**
 * Scot Matson - 009602502
 * CS49C - 01
 * Homework 9a Final
 */
public class HighTemperatureMinder
{
    private int[] list;

    /**
     * Constructor for objects of class HighTemperatureMinder
     * @param temperatures the array of temperatures
     */
    public HighTemperatureMinder(int[] temperatures)
    {
        // initialise instance variables
        list = temperatures;

    }

    /**
     * Returns the average of the temperatures in the array
     * @return average The average of all tempatures
     */
    public double average() {
        double average = 0.0;
        //Checking the array for elements
        if (list.length > 0) {
            //Creating a sum of integers
            for (int i = 0; i < list.length; ++i) {
                average += list[i];
            }
        }
        
        return average / list.length;
    }

    /**
     * Calculates the biggest difference between two consecutive days
     * @return greatestChange The greatest temperature difference
     */
    public int biggestChange() {
        int greatestChange = 0;
        int nextChange;
        //Testing for array elements
        if (list.length > 0) {
            //Incrementing through array
            for (int i = 0; i < list.length-1; ++i) {
                //Evaluating difference and storing as positive value
                nextChange = list[i] - list[i+1];
                nextChange = (nextChange < 0) ? -nextChange : nextChange;
                //Comparing values
                if (greatestChange < nextChange) {
                    greatestChange = nextChange;
                }
            }
        }

        return greatestChange;
    }

    /**
     * Returns true if this HighTemperatureMinder contains the same values in 
     * the same order as otherMinder
     * @param otherMinder Another instance of a Temperature Minder class
     * @return theSame Returns true if the values share equality and order
     */
    public boolean theSame(HighTemperatureMinder otherMinder) {
        //Equality 'might' exist, if the arrays are equal in length
        boolean isSame = (list.length == otherMinder.list.length);
        //If equal lengths, loop until we find an inequality or exhaust our counter
        for (int i = 0; i < list.length && isSame; ++i) {
            //Stop the loop and return false if we find any inequality
            if(list[i] != otherMinder.list[i]) {
                isSame = false;
                break;
            }
        }

        return isSame;
    }
}
