/**
 * Author: Scot Matson (009602502)
 * Class: CS46B - 01
 * Assn: hw02 (final)
 * CLASS: ChicagoWarehouseFormatter
 *
 * This class realizes the OrderFormatter interface.
 *
 * The single method returns a String representing
 * an Order formatted as the first letter of the department,
 * plus an underscore, then the product id, then an underscore,
 * then the order id.
 *
 * For example: O_12345_8888
 */
class ChicagoWarehouseFormatter implements OrderFormatter {

    @Override
    public String FormatOrder(int orderId, int productId, String productName, String department) {

        return department.substring(0, 1) + "_" + productId + "_"  + orderId;
    }
}