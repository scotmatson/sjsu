/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved

 Merge Sort using an Array

 Solves CS147 Homework Assignment #05

 @author Scot Matson
 Adapted from Data Structures and Algoritihms, 3rd Ed.
 by Mark Allen Weiss

 @version 2015/07/19
 */
package Assignment05;

public class MergeSortArray implements Sortable
{
   /**
    Mergesort algorithm.
    @param a an array of Comparable items.
    */
   @Override
   public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a)
   {
      Stats.startTime();
      AnyType[] tmpArray = (AnyType []) new Comparable[a.length];
      mergeSort(a, tmpArray, 0, a.length - 1);
      Stats.stopTime();
   }

   /**
    Internal method that makes recursive calls.
    @param a an array of Comparable items.
    @param tmpArray an array to place the merged result.
    @param left the left-most index of the subarray.
    @param right the right-most index of the subarray.
    */
   private static <AnyType extends Comparable<? super AnyType>>
   void mergeSort(AnyType [] a, AnyType [] tmpArray, int left, int right)
   {
      if(left < right)
      {
         int center = (left + right) / 2;
         mergeSort(a, tmpArray, left, center);
         mergeSort(a, tmpArray, center + 1, right);
         merge(a, tmpArray, left, center + 1, right);
      }
   }

   /**
    Internal method that merges two sorted halves of a subarray.
    @param a an array of Comparable items.
    @param tmpArray an array to place the merged result.
    @param leftPos the left-most index of the subarray.
    @param rightPos the index of the start of the second half.
    @param rightEnd the right-most index of the subarray.
    */
   private static <AnyType extends Comparable<? super AnyType>>
   void merge(AnyType [] a, AnyType [] tmpArray, int leftPos, int rightPos, int rightEnd)
   {
      int leftEnd = rightPos - 1;
      int tmpPos = leftPos;
      int numElements = rightEnd - leftPos + 1;

      // Main loop
      while (leftPos <= leftEnd && rightPos <= rightEnd)
      {
         Stats.incrementCompares();
         if (a[leftPos].compareTo(a[rightPos]) <= 0)
         {
            tmpArray[tmpPos++] = a[leftPos++];
            Stats.incrementMoves();
         }
         else
         {
            tmpArray[tmpPos++] = a[rightPos++];
            Stats.incrementMoves();
         }
      }

      while(leftPos <= leftEnd)    // Copy rest of first half
      {
         tmpArray[tmpPos++] = a[leftPos++];
         Stats.incrementMoves();
      }

      while( rightPos <= rightEnd )  // Copy rest of right half
      {
         tmpArray[tmpPos++] = a[rightPos++];
         Stats.incrementMoves();
      }

      // Copy tmpArray back
      for(int i = 0; i < numElements; i++, rightEnd--)
      {
         a[rightEnd] = tmpArray[rightEnd];
         Stats.incrementMoves();
      }
   }
}
