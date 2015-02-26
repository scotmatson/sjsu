/**
 * Created by scot on 11/27/14.
 * Assignment: 11b {DRAFT}
 * Course: cs46a-01
 */
//ID Telephone
public class Telephone //implements Comparable
{

    private String brand;
    private String phoneNumber;

    /**
     * Constructor method for Telephone class
     * @param brand Brand of telephone
     * @param phoneNumber Telephone number
     */
    public Telephone (String brand, String phoneNumber) {
        this.brand = brand;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the brand name of the telephone
     * @return brand The brand of telephone
     */
    public String getBrand() {

        return brand;
    }

    public String toString()
    {
        String s;
        s =  getClass().getName()
                + "[brand=" + brand
                + ",phoneNumber=" + phoneNumber
                + "]";
        return s;
    }
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
}

