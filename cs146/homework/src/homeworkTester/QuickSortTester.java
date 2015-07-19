package homeworkTester;

/**
 Created by scot on 7/19/15.
 */
public class QuickSortTester
{

   public static void main(String[] args)
   {
      Integer[] myInt = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
      QuickSort qs = new QuickSort();
      qs.sort(myInt);
      for (int i = 0; i < myInt.length; ++i)
      {
         System.out.print(myInt[i] + " ");
      }
   }
   public static class QuickSort
   {
      public <AnyType extends Comparable<? super AnyType>>
      void sort(AnyType[] values) {

         quicksort(values, 0, values.length - 1);
      }

      private <AnyType extends Comparable<? super AnyType>>
      void quicksort(AnyType[] numbers, int low, int high) {
         int i = low, j = high;
         // Get the pivot element from the middle of the list
         AnyType pivot = numbers[low + (high-low)/2];

         // Divide into two lists
         while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i].compareTo(pivot) < 0) {
               i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j].compareTo(pivot) > 0) {
               j--;
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
         numbers[j] = temp;
      }
   }
}
