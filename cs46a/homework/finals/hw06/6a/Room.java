
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
        this.view = view.toLowerCase();
        this.season = season.toLowerCase();
        this.occupants = occupants;
    }

    /**
     * Calculates the total cost of the room based upon the reservations made
     * @return cost the total cost of the room
     */
    public double getCost() {
        double cost = 0.0;
        
        if (occupants > 2) {
            if (occupants > 4) {
                cost += (occupants - 4) * COST_PER_EXTRA_PERSON;
            }
            if (season.compareTo("summer") == 0) {
                if (view.compareTo("street") == 0) {
                    cost += STREET_SUMMER_4PEOPLE;
                }
                else { //View is mountain or anything else
                    cost += MOUNTAIN_SUMMER_4PEOPLE;
                }
            }
            else { //Season is winter or anything else
                if (view.compareTo("street") == 0) {
                    cost += STREET_WINTER_4PEOPLE;
                }
                else { //View is mountain or anything else
                    cost += MOUNTAIN_WINTER_4PEOPLE;
                }
            }
        }
        else if (occupants > 0) {
            if (season.compareTo("summer") == 0) {
                if (view.compareTo("street") == 0) {
                    cost += STREET_SUMMER_2PEOPLE;
                }
                else { //View is mountain or anything else
                    cost += MOUNTAIN_SUMMER_2PEOPLE;
                }
            }
            else { //Season is winter or anything else
                if (view.compareTo("street") == 0) {
                    cost += STREET_WINTER_2PEOPLE;
                }
                else { //View is mountain or anything else
                    cost += MOUNTAIN_WINTER_2PEOPLE;
                }
            }
        }
       
        return cost;
    }

    /**
     * Sets the number of occupants which will be staying in the room
     * @param occupants the number of guests occupying the room
     */
    public void setOccupants(int occupants) {
        this.occupants = occupants;
    }

    /**
     * Returns winter/summer based upon the season that was requested by the customer
     * @return season the season that the reservation is made
     */
    public String getSeason() {
        return season;
    }
}
