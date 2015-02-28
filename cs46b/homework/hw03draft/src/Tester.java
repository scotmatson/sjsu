/**
 * Created by scot on 2/27/15.
 */
import java.lang.reflect.Method;

public class Tester
{
    public static void main(String[] args)
    {
        Loadable p = new Product(123, "Pride and Prejudice",
                "The story of the Bennet sisters, and how their town reacts to a new tenant in town.");
        System.out.println("Actual: " + ((Product)p).getId());
        System.out.println("Expected: 123");

        Loadable o = new Order();
        ((Order)o).addProduct(123, 33);
        ((Order)o).addProduct(222, 1);
        System.out.println("Actual: " + ((Order)o).size());
        System.out.println("Expected: 2");

        System.out.print("Actual: ");
        try
        {
            Method m = o.getClass().getMethod("saveToFile", String.class);
            if( m != null ) System.out.println("saveToFile method exists!");
        }
        catch(Exception e)
        {
            System.out.println("saveToFile method does not exist!");
        }
        System.out.println("Expected: saveToFile method exists!");
    }
}