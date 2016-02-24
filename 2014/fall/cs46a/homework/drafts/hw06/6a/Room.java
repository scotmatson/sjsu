
/**
 * Initializes reserations for a hotel room and calculates the cost based upon
 * the desired parameters.
 * 
 * @author (Scot Matson) 
 * @version (20141009)
 */
public class Room
{
    public static final int MOUNTAIN_WINTER_2PEOPLE = 250;
    public static final int MOUNTAIN_WINTER_4PEOPLE = 370;
    public static final int MOUNTAIN_SUMMER_2PEOPLE = 175;
    public static final int MOUNTAIN_SUMMER_4PEOPLE = 260;
    public static final int STREET_WINTER_2PEOPLE = 200;
    public static final int STREET_WINTER_4PEOPLE = 325;
    public static final int STREET_SUMMER_2PEOPLE = 150;
    public static final int STREET_SUMMER_4PEOPLE = 200;
    public static final double COST_PER_EXTRA_PERSON = 100;
    
    private String view;
    private String season;
    private int occupants;

    /**
     * Initializes a hotel reservation
     * @param view the desired view from the window
     * @param season the season in which the reservation is being made
     * @param occupants the number of occupants staying at in the room
     */
    public Room(String view, String season, int occupants)
    {
        this.view = view;
        this.season = season;
        this.occupants = occupants;
    }

    /**
     * Calculates the total cost of the room based upon the reservations made
     * @return cost the total cost of the room
     */
    public double getCost() {
        //TODO calculate cost for room
        double cost = 0.0;
        return cost;
    }

    /**
     * Sets the number of occupants which will be staying in the room
     * @param occupants the number of guests occupying the room
     */
    public void setOccupants(int occupants) {
        //TODO Set # of occupants
    }

    /**
     * Returns winter/summer based upon the season that was requested by the customer
     * @return season the season that the reservation is made
     */
    public String getSeason() {
        return season;
    }
}
