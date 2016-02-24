/**
 * Created by scot on 11/27/14.
 * Assignment: 11b {FINAL}
 * Course: cs46a-01
 */
//ID Telephone
public class Telephone implements Comparable {

    private String brand;
    private String phoneNumber;

    /**
     * Constructor method for Telephone class
     *
     * @param brand       Brand of telephone
     * @param phoneNumber Telephone number
     */
    public Telephone(String brand, String phoneNumber) {
        this.brand = brand;
        if (phoneNumber.length() == 10)
            this.phoneNumber = phoneNumber;
        else
            this.phoneNumber = "Invalid Entry";
    }

    /**
     * Returns the brand name of the telephone
     *
     * @return brand The brand of telephone
     */
    public String getBrand() {

        return brand;
    }

    /**
     * Returns the telephone number
     *
     * @return phoneNumber The telephone number
     */
    public String getPhoneNumber() {

        return phoneNumber;
    }

    public String toString() {
        String s;
        s = getClass().getName()
                + "[brand=" + brand
                + ",phoneNumber=" + phoneNumber
                + "]";
        return s;
    }

    @Override
    public int compareTo(Object o) {

        Telephone other = (Telephone) o;
        if (getBrand().compareTo(other.getBrand()) < 0) { return -1; }
        if (getBrand().compareTo(other.getBrand()) > 0) { return 1;  }
        if (getBrand().compareTo(other.getBrand()) == 0) {
            if(getPhoneNumber().compareTo(other.getPhoneNumber()) < 0) { return -1; }
            else { return 1; }
        }
        return 0;
    }
}

