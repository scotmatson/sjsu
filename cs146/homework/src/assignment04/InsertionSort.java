package assignment04;

/**
 Created by scot on 7/11/15.
 */
public class InsertionSort implements Sortable
{
   /**
    Simple insertion sort.

    @param a
    @param <AnyType>
    */
   public <AnyType extends Comparable<? super AnyType>>
   void sort(AnyType[] a)
   {
      Stats.startTime();
      int j;

      for (int p = 1; p < a.length; p++)
      {
         AnyType tmp = a[p];

         for (j = p; j > 0 && tmp.compareTo(a[j-1]) < 0; j--)
         {
            a[j] = a[j - 1];
            Stats.incrementCompares();
            Stats.incrementMoves();
         }

         a[j] = tmp;
         Stats.incrementMoves();
      }
      Stats.stopTime();
   }
}
