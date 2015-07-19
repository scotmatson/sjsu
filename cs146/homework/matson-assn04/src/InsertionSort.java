/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 InsertionSort Algorithm.

 Solves CS147 Homework Assignment #04

 @author Scot Matson
   Adapted from Data Structures and Algoritihms, 3rd Ed.
   by Mark Allen Weiss
 @version 1.00 2015/07/11
 */

package assignment04;

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
         Stats.incrementCompares();
         for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
         {
            a[j] = a[j - 1];
            Stats.incrementCompares();
            Stats.incrementMoves();
         }
         a[j] = tmp;
      }
      Stats.stopTime();
   }
}
