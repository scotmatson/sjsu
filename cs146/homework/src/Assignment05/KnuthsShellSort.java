/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Knuth's ShellSort Algorithm.

 Solves CS147 Homework Assignment #05

 @author Scot Matson, ykombinator, John Mercier
   Adapted from http://stackoverflow.com/a/4837697/4280850

 @version 1.00 2015/07/11
 */

package Assignment05;

public class KnuthsShellSort implements Sortable
{
   /**
    Knuth's ShellSort sorting algorithm. Sorts in ascending order.

    @param a
    @param <AnyType>
    */
   public <AnyType extends Comparable<? super AnyType>>
   void sort(AnyType[] a)
   {
      Stats.startTime();
      int gap = 1;
      while (gap < Math.ceil(a.length / 3) )
      {
         gap = (3 * gap + 1);
      }

      int j;
      while (gap > 0) {
         for (int i = gap - 1; i < a.length; i++){

            AnyType tmp = a[i];
            Stats.incrementCompares();
            for(j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
            {
               a[j] = a[j - gap];
               Stats.incrementCompares();
               Stats.incrementMoves();
            }

            a[j] = tmp;
         }

         gap /= 3;
      }
      Stats.stopTime();
   }
}
