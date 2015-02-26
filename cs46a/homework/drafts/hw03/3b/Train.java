
/**
 * Models a train running on a straight track going either direction
 * 
 * @author Scot Matson
 * @version 20140911
 */
public class Train {

    private int position;
    private int heading;

    /**
     * Default constructor positioning the train at the
     * start of the track headings towards the end.
     */
    public Train() {
        this.position = 0;
        this.heading = 1;
    }

    /**
     * Moves the train to a position in the current direction
     * @param numberOfStops moves the train nth number of stops
     */
    public void move(int numberOfStops) {

    }

    /**
     * Faces the train in the opposite direction
     */
    public void turn() {

    }

    /**
     * Returns the distance to the start of the track from the current position
     * @return distance from the start of the track
     */
    public int distanceToStart() {
        return 0;
    }

    /**
     * Returns the distance to the end of the track from the current position
     * @return distance to the end of the track
     */
    public int distanceToEnd() {
        return 0;
    }
}
