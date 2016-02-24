/**
 * Scot Matson - 009602502
 * CS49C - 01
 * Homework 9a Draft
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
        
        for (int i = 0; i < list.length; ++i) {
            average += list[i];
        }
        
        return (list.length > 0) ? average / list.length : average;
    }
    
    /**
     * Calculates the biggest difference between two consecutive days
     * @return biggestChange The greatest temperature difference
     */
    public int biggestChange() {
        return -1;
    }

    /**
     * Returns true if this HighTemperatureMinder contains the same values in 
     * the same order as otherMinder
     * @param otherMinder Another instance of a Temperature Minder class
     * @return theSame Returns true if the values share equality and order
     */
    public boolean theSame(HighTemperatureMinder otherMinder) {
        return false;
    }
}
