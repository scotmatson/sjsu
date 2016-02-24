/**
 * Author: Scot Matson
 * Type: Draft
 * Assignment: 5a
 * Date: 09/30/14
 * Course: cs46a
 * Section: 05
 * Description: Simulates a train moving across a linear space.
 */

public class Train
{
    public static final int DISTANCE_BETWEEN_STOPS = 5;
    public static final int LAST_STOP_NUMBER = 10;
    public static final int FORWARD = 1;
    public static final int REVERSE = -1;
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
    }
    
    /**
     * Moves the train the specified number of stops in the current direction
     * @param numberOfStops the number of stops to move
     */
    public void move(int numberOfStops)
    {
        stopNumber += (numberOfStops * direction);
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