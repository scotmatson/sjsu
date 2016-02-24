/**
 * CLASS: SanJoseWarehouseFormatter
 *
 * This class realizes the OrderFormatter interface.
 *
 * The single method returns a String representing
 * an Order formatted as the product name with spaces removed,
 * then the product id, then a dash, then the department, then
 * a dash, then the order id.
 *
 * For example: WhitePaper12345-Office-8888
 */
class SanJoseWarehouseFormatter implements OrderFormatter {

    @Override
    public String FormatOrder(int orderId, int productId, String productName, String department) {

        return productName.replace(" ", "") +  productId + "-" + department + "-" + orderId;
    }
}
