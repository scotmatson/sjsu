package Assignment06;

/**
 Created by scot on 7/31/15.
 */
public class CycleFoundException extends Exception
{
   public CycleFoundException()
   {
      System.out.println("Cycle Found.");
      System.out.println("Ending Program.");
      System.exit(1);
   }
}
