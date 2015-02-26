/**
 * Created by scot on 11/27/14.
 * Assignment: 11c {FINAL}
 * Course: cs46a-1
 */
public class CellPhone extends Telephone {

    private int maxCharge;
    private int currentCharge;

    /**
     * Constructor for the CellPhone class
     * @param brand The brand of the phone
     * @param phoneNumber The telephone number
     * @param maxCharge The maximum charge of the phone
     */
    public CellPhone (String brand, String phoneNumber, int maxCharge) {
        super(brand, phoneNumber);
        this.maxCharge = maxCharge;
        this.currentCharge = maxCharge;
    }

    /**
     * Depletes the available charge based upon minutes used
     * @param minutes The number of minutes used
     */
    public void use(int minutes) {

        if (currentCharge - minutes < 0)
            currentCharge = 0;
        else
            currentCharge -= minutes;
    }

    /**
     * Fully recharges the phone
     */
    public void recharge() {

        currentCharge = maxCharge;
    }

    /**
     * Shows the number of available minutes remaining on the current charge
     * @return currentCharge The current charge of the phone
     */
    public int getCharge() {

        return currentCharge;
    }

    /**
     * Converts an object into a String
     * @return s The String object
     */
    public String toString()
    {
        String s = super.toString()
                + "[maxCharge=" + currentCharge +"]";
        return s;
    }
}