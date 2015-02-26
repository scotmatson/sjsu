/**
 *
 * Author: Scot Matson (009602502)
 * Class: CS46B - 01
 * Assn: hw02 (final)
 *
 * CLASS: AtlantaWarehouseFormatter
 *
 * This class realizes the OrderFormatter interface.
 *
 * The single method returns a String representing
 * an Order formatted as the order id, then a dash, then the 
 * product id, then a dash, then the first three letters for 
 * the product name.
 *
 * For example: 123-456-Mot
 */
class AtlantaWarehouseFormatter implements OrderFormatter {

    @Override
    public String FormatOrder(int orderId, int productId, String productName, String department) {

        return orderId + "-" + productId + "-" + productName.substring(0, 3);
    }
}
