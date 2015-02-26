/**
 * CellPhone.
 *
 * This class encapsulates a cell phone that
 * is in stock at a store that sells both
 * phones and service contracts.
 *
 */
public class CellPhone extends InventoryItem implements Comparable
{
    // given - do not modify
    private String name;
    private double contractPrice;
    private double phonePrice;
    // do not add more instance variables

    /**
     * Constructor.
     *
     * Set the value of each attribute of this class.
     * Also make sure to set the attributes of the
     * superclass.
     *
     * @param name the name of this phone
     * @param contractPrice the price of the phone's service contract
     * @param phonePrice the price of the phone by itself
     */
    public CellPhone(String name, double contractPrice, double phonePrice)
    {
        // YOUR CODE HERE
        this.name = name;
        this.contractPrice = contractPrice;
        this.phonePrice = phonePrice;
    }

    /**
     * getName and setName.
     *
     * Simple accessor and mutator methods for the
     * name attribute.
     */
    // YOUR CODE HERE
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    /**
     * Comparable interface.
     *
     * Implement Comparable. Sort phones by their total
     * price from least to greatest. Phones with a lower
     * total price (contract + phone) should come first;
     *
     * Don't forget to modify the class declaration to
     * indicate that you are using the Comparable interface.
     */
    @Override
    public int compareTo(Object o) {
        CellPhone otherPhone = (CellPhone) o;
        return (this.getPrice() < otherPhone.getPrice()) ? -1 : 1;
    }


    /**
     * getPrice.
     *
     * Override the getPrice method in the superclass.
     * Return the sum of contractPrice and phonePrice.
     *
     */
    public double getPrice() {
        return (this.contractPrice + this.phonePrice);
    }

    /**
     * toString.
     *
     * Override the toString method. Print the following
     * with variables replaced by their values.
     *
     * CellPhone[name=NAME, id=ID, price=PRICE]
     */
    public String toString() {
        return "CellPhone[name=" + getName() + ", id=" + super.getId() + ", price=" + getPrice() + "]";
    }
}
