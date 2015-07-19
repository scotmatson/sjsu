package Assignment05;

/**
 Created by scot on 7/18/15.
 */
public class QuicksortSuboptimal implements Sortable
{
   public <AnyType extends Comparable<? super AnyType>>
   void sort(AnyType[] values) {
      Stats.startTime();
      quicksort(values, 0, values.length - 1);
      Stats.stopTime();
   }

   private <AnyType extends Comparable<? super AnyType>>
   void quicksort(AnyType[] numbers, int low, int high) {
      int i = low, j = high;
      // Get the pivot element from the start of the list
      AnyType pivot = numbers[low];

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

   private <AnyType extends Comparable<? super AnyType>>
   void swapReferences(AnyType[] numbers, int i, int j) {
      AnyType temp = numbers[i];

      numbers[i] = numbers[j];
      Stats.incrementMoves();

      numbers[j] = temp;
      Stats.incrementMoves();
   }
}
