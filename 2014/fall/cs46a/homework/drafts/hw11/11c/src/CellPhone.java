/**
 * Created by scot on 11/27/14.
 * Assignment: 11c {DRAFT}
 * Course: cs46a-1
 */
public class CellPhone extends Telephone {

    private int currentCharge;

    public CellPhone (String brand, String phoneNumber, int maxCharge) {
        super(brand, phoneNumber);
        this.currentCharge = maxCharge;
    }

    public String toString()
    {
        String s = super.toString()
                + "[maxCharge=" + currentCharge +"]";
        return s;
    }
}
