/**
 * Created by scot on 2/28/15.
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class encapsulates an order in
 * an online store.
 *
 * Draft: Add the methods in the Loadable
 * interface. Leave the implementation
 * empty.
 *
 * Final: Add the implementation for the
 * Loadable interface.
 *
 */
public class Order implements Loadable
{
    private ArrayList<Integer> productId;
    private ArrayList<Integer> quantity;

    public Order()
    {
        productId = new ArrayList<Integer>();
        quantity = new ArrayList<Integer>();
    }

    public void addProduct(int id, int qty)
    {
        productId.add(id);
        quantity.add(qty);
    }

    public int size()
    {
        return productId.size();
    }

    public ArrayList<Integer> getProductId() {
        return productId;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public String toString()
    {
        return "Order [productId=" + productId.toString() + ", quantity=" + quantity.toString() + "]";
    }

    /**
     * Save an order to a file. Each id, quantity
     * pair be on its own line. id will come first,
     * then a comma, then a newline. Then the next
     * line will contain another id,quantity pair
     * if there are more products in this order.
     *
     * There may be arbitrarily many id,product
     * pairs in an order.
     *
     * You must catch and handle exceptions
     * properly. Data in the file may be incorrectly
     * formatted, or the file may be absent. Or
     * other errors could occur. If an exception
     * occurs, then print "Unable to save order to Filename.\n"
     * where Filename is replaced with the actual
     * value in Filename.
     *
     * File Example:
     * 12345,1
     * 111,2
     * 555,7
     * 8888,23
     *
     * @param filename the location of the file that contains the information for this Order
     */
    @Override
    public void saveToFile(String filename) {
        try {
            File file = new File(filename);
            PrintStream out = new PrintStream(file, "UTF-8");
            try {
                // Iterate through the ArrayLists and write the elements into a file.
                for (int i = 0; i < this.size(); ++i) {
                    out.printf("%d,%d\n", getProductId().get(i), getQuantity().get(i));
                }
            } finally {
                out.close();
            }
        }
        // Because we are using a custom message regardless of error, a general IOException will suffice.
        catch(IOException e) {
            System.out.println("Unable to save order to " + filename + ".\n");
        }
    }

    /**
     * Load an order from a file. Each id, quantity
     * pair be on its own line. id will come first,
     * then a comma, then a newline. Then the next
     * line will contain another id,quantity pair
     * if there are more products in this order.
     *
     * There may be arbitrarily many id,product
     * pairs in an order.
     *
     * You must catch and handle exceptions
     * properly. Data in the file may be incorrectly
     * formatted, or the file may be absent. Or
     * other errors could occur. If an exception
     * occurs, then print "Unable to load order from Filename.\n"
     * where Filename is replaced with the actual
     * value in Filename.
     *
     * File Example:
     * 12345,1
     * 111,2
     * 555,7
     * 8888,23
     *
     * @param filename the location of the file that contains the information for this Order
     */
    @Override
    public void loadFromFile(String filename) {
        try {
            Scanner in = new Scanner(new File(filename));
            //in.useDelimiter("[0-9]+");
            // I wanted to use RegEx here but couldn't quite get the bugs worked out
            // I opted for borrowing an example from the book which did the job quite well, but looks messier to me.
            try {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    int i = 0;
                    while (Character.isDigit(line.charAt(i))) { ++i; }
                    productId.add(Integer.parseInt(line.substring(0, i)));
                    quantity.add(Integer.parseInt(line.substring(i+1)));
                }
            } finally {
                in.close();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Unable to load order from " + filename + ".");
        }
        catch (NumberFormatException e) {
            System.out.println("Unable to load order from " + filename + ".");
        }
        catch (IOException e) {
            System.out.println("Unable to load order from " + filename + ".");
        }
    }
}
