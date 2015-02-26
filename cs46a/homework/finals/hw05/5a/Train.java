/**
 * Author: Scot Matson
 * Type: Final
 * Assignment: 5a
 * Date: 10/2/14
 * Course: cs46a
 * Section: 05
 * Description: Simulates a train moving across a linear space.
 */

public class Train
{
    public static final int POWER_UNITS_PER_ADD_FUEL = 4;
    public static final int MAX_POWER_UNITS = 8;
    public static final int DISTANCE_BETWEEN_STOPS = 5;
    public static final int LAST_STOP_NUMBER = 10;
    public static final int FORWARD = 1;
    public static final int REVERSE = -1;
    private int currentFuel;
    private int stopNumber;
    private int direction;

    /**
     * Conststucts a Train positioned at the start and facing the 
     * end for the track
     */
    public Train()
    {
        stopNumber = 0;
        direction = FORWARD;
        currentFuel = 0;
    }
    
    /**
     * 'Fills' the train with 4 'power units' of fuel to a max of 8
     */
    public void addFuel() {
        int powerUnit;
        for (powerUnit = 1; powerUnit <= POWER_UNITS_PER_ADD_FUEL; ++powerUnit) {
            if (currentFuel <= MAX_POWER_UNITS) currentFuel += 1;
            else break;
        }
    }
    
    /**
     * @return currentFuel - the number of 'power units' remaining
     */
    public int getPowerUnits() {
        return currentFuel;
    }
    
    /**
     * Moves the train the specified number of stops in the current direction
     * @param numberOfStops the number of stops to move
     */
    public void move(int numberOfStops)
    {
        int stop;
        for (stop = 1; (stop <= numberOfStops && currentFuel > 0); ++stop) {
            stopNumber += direction;
            --currentFuel;
        }
    }
    
    /**
     * Changes the direction of the train
     */
    public void turn()
    {
        direction = (direction == FORWARD) ? REVERSE : FORWARD;
    }
    
    /**
     * Gets the distance to (or from) the start of the track in miles
     * @return the distance to (or from) the start of the track in miles
     */
    public int distanceToStart()
    {
        return stopNumber * DISTANCE_BETWEEN_STOPS;
    }

    /**
     * Gets the distance to (or from) the end of the track in miles
     * @return the distance to (or from) the end of the track in miles
     */
    public int distanceToEnd()
    {
        return (LAST_STOP_NUMBER * DISTANCE_BETWEEN_STOPS) - (stopNumber * DISTANCE_BETWEEN_STOPS);
    }
}