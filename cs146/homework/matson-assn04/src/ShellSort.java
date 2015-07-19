/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 ShellSort Algorithm.

 Solves CS147 Homework Assignment #04

 @author Scot Matson
 Adapted from Data Structures and Algoritihms, 3rd Ed.
 by Mark Allen Weiss
 @version 1.00 2015/07/11
 */

package assignment04;

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
            Stats.incrementCompares();
            for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
            {
               a[j] = a[j - gap];
               Stats.incrementCompares();
               Stats.incrementMoves();
            }
            a[j] = tmp;
         }
      }
      Stats.stopTime();
   }



}
