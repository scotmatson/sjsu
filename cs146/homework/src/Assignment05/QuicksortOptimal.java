/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Quicksort algorithm using the median of three as a pivot.

 Solves CS147 Homework Assignment #05

 @author Scot Matson, Unknown
 Adapted from http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html

 @version 2015/07/19
 */
package Assignment05;

public class QuicksortOptimal implements Sortable
{
   /**
    Sort method encapsulates internal method calls.
    @param a a generic array
    */
   public <AnyType extends Comparable<? super AnyType>>
   void sort(AnyType[] a)
   {
      Stats.startTime();
      quicksort(a, 0, a.length - 1);
      Stats.stopTime();
   }

   /**
    Internal method, recursively performs a Quicksort
    @param numbers a generic array
    @param low lowest array index
    @param high highest array index
    */
   private <AnyType extends Comparable<? super AnyType>>
   void quicksort(AnyType[] numbers, int low, int high) {
      int i = low, j = high;
      // Get the pivot element from the middle of the list
      AnyType pivot = median3(numbers, low, high);

      // Divide into two lists
      while (i <= j) {
         // If the current value from the left list is smaller then the pivot
         // element then get the next element from the left list
         Stats.incrementCompares();
         while (numbers[i].compareTo(pivot) < 0) {
            i++;
            Stats.incrementCompares();
         }
         // If the current value from the right list is larger then the pivot
         // element then get the next element from the right list
         Stats.incrementCompares();
         while (numbers[j].compareTo(pivot) > 0) {
            j--;
            Stats.incrementCompares();
         }

         // If we have found a values in the left list which is larger then
         // the pivot element and if we have found a value in the right list
         // which is smaller then the pivot element then we exchange the
         // values.
         // As we are done we can increase i and j
         if (i <= j) {
            swapReferences(numbers, i, j);
            i++;
            j--;
         }
      }
      // Recursion
      if (low < j)
         quicksort(numbers, low, j);
      if (i < high)
         quicksort(numbers, i, high);
   }

   /**
    Swaps the position of two given indices
    @param numbers a generic array
    @param i index to swap
    @param j index to swap
    */
   private <AnyType extends Comparable<? super AnyType>>
   void swapReferences(AnyType[] numbers, int i, int j) {
      AnyType temp = numbers[i];

      numbers[i] = numbers[j];
      Stats.incrementMoves();

      numbers[j] = temp;
      Stats.incrementMoves();
   }

   /**
    Return median of left, center, and right.
    Order these and hide the pivot.
    @param a a generic array
    @param left lowest index position
    @param right highest index position
    @return the pivot
    */
   private <AnyType extends Comparable<? super AnyType>>
   AnyType median3 (AnyType[] a, int left, int right)
   {
      // Sort low, middle, high
      int center = (left + right ) / 2;
      Stats.incrementCompares();
      if (a[center].compareTo(a[left]) < 0)
      {
         swapReferences(a, left, center);
      }
      Stats.incrementCompares();
      if (a[right].compareTo(a[left]) < 0)
      {
         swapReferences(a, left, right);
      }
      Stats.incrementCompares();
      if (a[right].compareTo(a[center]) < 0)
      {
         swapReferences(a, center, right);
      }

      // Place pivot at position right - 1
      swapReferences(a, center, right - 1);

      return a[right - 1];
   }
}
