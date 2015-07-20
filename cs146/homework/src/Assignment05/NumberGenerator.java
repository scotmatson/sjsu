/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Generates Integer Arrays of size n and provides a number of methods
 to manipulate them. Used for testing Sorting algorithms.

 Solves CS147 Homework Assignment #05

 @author Scot Matson

 @version 2015/07/19

 ##ChangeLog
   -Fixed bug in shuffle method where the element rather than the temp value
    was being assigned.
 */

package Assignment05;

import java.util.Arrays;
import java.util.Random;

public class NumberGenerator
{
   private static Integer[] numbers;

   /**
    Generates an Array of size n and fills
    it with integers from 0 - n.

    @param n The size of the Array.
    */
   public void generateNumbers(int n)
   {
      numbers = new Integer[n];
      for (int i = 0; i < n; ++i)
      {
         numbers[i] = i;
      }
   }

   /**
    Generates an Array of size n and fills
    it with zeros.

    @param n The size of the Array
    */
   public void generateZeros(int n)
   {
      Arrays.fill(numbers, 0, n, 0);
   }

   public Integer[] getNumbers()
   {
      return numbers;
   }

   /**
    Fisher-Yates Shuffle,
    Shuffles the order of an Array.
    */
   public void shuffleNumbers()
   {
      Random rand = new Random();
      Integer temp;
      for (int i = numbers.length - 1; i > 0; --i)
      {
         Integer index = rand.nextInt(i + 1);
         temp = numbers[index];
         numbers[index] = numbers[i];
         numbers[i] = temp;
      }
   }

   public void sortNumbers()
   {
      Arrays.sort(numbers);
   }

   public void reverseSortNumbers()
   {
      // Ensures numbers are sorted before reversing their order.
      sortNumbers();
      for (int i = 0; i < numbers.length / 2; ++i)
      {
         Integer temp = numbers[i];
         numbers[i] = numbers[numbers.length - i - 1];
         numbers[numbers.length - 1 - i] = temp;
      }
   }
}
