/**
 * Tester for Cashier object
 */
public class CashierTester
{
   public static void main(String[] args)
   {
       Cashier sam = new Cashier("Sam");
       sam.setCurrentTransaction(4.35, 10.0);
       Change change = sam.getChange();
       System.out.println(change);
       System.out.println("Expected: null" );
   }
}