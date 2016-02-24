/**
 *
 * Author: Scot Matson (009602502)
 * Class: CS46B - 01
 * Assn: hw02 (draft)
 *
 * This class represents an order
 * placed to an online marketplace
 * such as Amazon, ebay, or buy.com.
 *
 * The key method is GetFormattedOrder.
 * This method returns a String that
 * represents an order in the format
 * specified by the OrderFormatter
 * that is passed in as an argument.
 *
 * For the draft, you must implement the
 * Comparable interface on this class.
 */
public class Order implements Comparable<Order>
{
    private int orderId;
    private int productId;
    private String productName;
    private String department;

    public Order(int newOrderId, int newProductId, String newProductName, String newDepartment)
    {
        this.orderId = newOrderId;
        this.productId = newProductId;
        this.productName = newProductName;
        this.department = newDepartment;
    }

    public String GetFormattedOrder(OrderFormatter f)
    {
        return f.FormatOrder(orderId, productId, productName, department);
    }

    public int getOrderId() { return orderId; }
    public int getProductId() { return productId; }

    /**
     * compareTo. compares the size of two different integers.
     *
     * @param other
     * @return an integer value which indicates a relationship between two separate values
     */
    @Override
    public int compareTo(Order other) {
        // Compare orderId return the lesser
        if (this.getOrderId() < other.getOrderId()) { return -1; }
        else if (this.getOrderId() > other.getOrderId()) { return 1; }
        else {
            if (this.getProductId() < other.getProductId()) { return -1; }
            else if (this.getProductId() > other.getProductId()) { return 1; }
        }

        return 0;
    }
}
