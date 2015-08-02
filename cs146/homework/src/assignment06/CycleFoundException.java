/**
 Generic Exception handler
    Used to manage excessive and infinite
    cycles in graph sorting algorithms.

 Solution for CS146 Assignment #06

 @author Scot Matson
 @version 08/01/2015
 */
package assignment06;

public class CycleFoundException extends Exception
{
   /**
    Generates a generic message to the console
    stating that a cycle has been found and
    terminates the program.
    */
   public CycleFoundException()
   {
      System.out.println("Cycle Found.");
      System.out.println("Ending Program.");
      System.exit(1);
   }
}
