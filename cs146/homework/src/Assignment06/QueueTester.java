/**
 Class to test the functionality of the Queue class.

 CS 146 Data Structures and Algorithms
 Used to solve Assignment #6

 @author Scot Matson
 @version 07/26/2015
 */
package Assignment06;

public class QueueTester
{
   public static void main(String[] args)
   {
      Queue<Integer> intQ = new Queue<>();

      /*
       Enqueue working.
       */
      System.out.println("Enqueue.");
      intQ.enqueue(5);
      intQ.enqueue(6);
      intQ.enqueue(4);
      System.out.println("Length should be 3.");
      System.out.println("Length is: " + intQ.getLength());
      intQ.enqueue(7);
      intQ.enqueue(3);
      intQ.enqueue(8);
      intQ.enqueue(2);
      intQ.enqueue(9);
      System.out.println("Length should be 8.");
      System.out.println("Length is: " + intQ.getLength());
      System.out.println();

      /*
         Dequeue and getLength working.
       */
      //int qLen = intQ.getLength();
      //for (int i = 0; i < qLen; ++i)
      //{
      //   System.out.println("Position: " + (i));
      //   System.out.println("Value: " + intQ.dequeue());
      //   System.out.println("Size: " + intQ.getLength());
      //}

      /*
         Enhanced for loop working
       */
      for (Integer n : intQ)
      {
         System.out.println("Value of N: " + n);
      }
   }
}
