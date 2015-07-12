package assignment04;

/**
 Created by scot on 7/11/15.
 */
public class ShellSort implements Sortable
{
   /**
    Shellsort, using Shell's (poor) increments.
    @param a
    @param <AnyType>
    */
   public <AnyType extends Comparable<? super AnyType>>
   void sort(AnyType[] a)
   {
      Stats.startTime();
      int j;

      for (int gap = a.length / 2; gap > 0; gap /= 2)
      {
         for (int i = gap; i < a.length; ++i)
         {
            AnyType tmp = a[i];
            for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
            {
               a[j] = a[j - gap];
               Stats.incrementCompares();
               Stats.incrementMoves();
            }
            a[j] = tmp;
            Stats.incrementMoves();
         }
      }
      Stats.stopTime();
   }

}
