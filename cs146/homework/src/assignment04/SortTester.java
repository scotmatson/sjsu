package assignment04;

/**
 Created by scot on 7/11/15.
 */
public class SortTester
{
   public static void main(String[] args)
   {
      final String tableHead = "ALGORITHM          MOVES       COMPARES   MILLISECONDS\n";

      final String[] headers = {
         "===== Unsorted Random Unique =====\n",
         "===== Sorted Unique =====\n",
         "===== Reverse Sorted Unique =====\n",
         "===== All Zeroes =====\n"
      };

      final String[] rowHeaders = {
         "Insertion sort",
         "ShellSort suboptimal",
         "ShellSort Knuth"
      };

      final Sortable[] sortingAlgorithms = {
         new InsertionSort(),
         new ShellSort(),
         new ShellSort()
      };

      final Integer[] testCases = {
         /**
          TODO: unsorted random unique
          TODO: sorted unique
          TODO: reverse sorted unique
          TODO: all zero
          */
      };

      final int minN = 100;
      final int maxN = 100000;
      final int multiplier = 10;

      for (String header : headers)
      {
         System.out.printf(header);
         for (int i = minN; i <= maxN; i *= multiplier)
         {
            System.out.printf("N = %d\n", i);
            System.out.printf("%71s", tableHead);
            for (int j = 0; j < rowHeaders.length; ++j)
            {
               Stats.clearStats();
               //sortingAlgorithms[j].sort(numbers);
               // Pull Test Case ** need new values **
               System.out.printf("%25s %14d %14d %14d\n", rowHeaders[j], Stats.getMoves(), Stats.getCompares(), Stats.getTime());

            }
            System.out.println();
         }
      }
   }
}
