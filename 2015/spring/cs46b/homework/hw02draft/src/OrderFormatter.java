/**
 * This is the interface that you
 * must implement for this assignment.
 */
public interface OrderFormatter
{
    /**
     * This is the only method that is part of
     * this interface. It takes the details of
     * an order and makes a String with the
     * details that are important to whichever
     * warehouse is fulfilling this order.
     *
     * @param orderId the id of this order
     * @param productId the id of the ordered product
     * @param productName the name of the ordered product
     * @param department the department of the product
     * @return a String describing this order
     */
    public String FormatOrder(int orderId, int productId, String productName, String department);
}