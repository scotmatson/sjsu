/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Testing class for sorting algorithms.

 Solves CS147 Homework Assignment #05

 @author Scot Matson

 @version 2015/07/19
 */

package Assignment05;

import java.io.IOException;
import java.io.PrintWriter;

public class SortTester
{
   public static void main(String[] args) throws IOException
   {
      final IOFlags outputFlag = IOFlags.TEXTFILE;
      PrintWriter pw = null;
      if (outputFlag == IOFlags.TEXTFILE)
      {
         pw = new PrintWriter("sortingAlgorithms.txt", "UTF-8");
         System.out.print("File created... ");
      }

      final String tableHead = "ALGORITHM          MOVES       COMPARES   MILLISECONDS\n";

      final String[] headers = {
         "===== Unsorted Random Unique =====\n",
         "===== Sorted Unique =====\n",
         "===== Reverse Sorted Unique =====\n",
         "===== All Zeroes =====\n"
      };

      final String[] headerShift = {
         "%51s",
         "%42s",
         "%50s",
         "%39s"
      };

      final String[] rowHeaders = {
         "Insertion sort",
         "ShellSort suboptimal",
         "ShellSort Knuth",
         "Heap sort",
         "Merge sort array",
         "Merge sort linked list",
         "Quicksort suboptimal",
         "Quicksort optimal"
      };

      final Sortable[] sortingAlgorithms = {
         new InsertionSort(),
         new ShellSort(),
         new KnuthsShellSort(),
         new HeapSort(),
         new MergeSortArray(),
         new MergeSortLinkedList(),
         new QuicksortSuboptimal(),
         new QuicksortOptimal()
      };

      final int minN = 100;
      final int maxN = 100000;
      final int multiplier = 10;

      // For each header, run the appropriate test.
      for (int h = 0; h < headers.length; ++h)
      {
         if (outputFlag == IOFlags.CONSOLE)
         {
            System.out.printf(headerShift[h], headers[h]);
         }
         else if (outputFlag == IOFlags.TEXTFILE)
         {
            pw.format(headerShift[h], headers[h]);
         }

         // The number of times to run the test.
         for (int N = minN; N <= maxN; N *= multiplier)
         {
            if (outputFlag == IOFlags.CONSOLE)
            {
               System.out.printf("N = %d\n", N);
               System.out.printf("%71s", tableHead);

            }
            else if (outputFlag == IOFlags.TEXTFILE)
            {
               pw.format("N = %d\n", N);
               pw.format("%71s", tableHead);
            }

            NumberGenerator numberGenerator = new NumberGenerator();
            switch (h)
            {
               case 0:
               case 1:
               case 2:
                  numberGenerator.generateNumbers(N);
                  break;
               case 3:
                  numberGenerator.generateZeros(N);
                  break;
            }

            // For each sorting algorithm, run a test and organize the data.
            for (int j = 0; j < rowHeaders.length; ++j)
            {
               // Initialize the testing environment.
               Stats.clearStats();
               switch (h)
               {
                  case 0:
                     numberGenerator.shuffleNumbers();
                     break;
                  case 1:
                     numberGenerator.sortNumbers();
                     break;
                  case 2:
                     numberGenerator.reverseSortNumbers();
                     break;
               }

               sortingAlgorithms[j].sort(numberGenerator.getNumbers());

               if (outputFlag == IOFlags.CONSOLE)
               {
                  System.out.printf("%25s %14d %14d %14d\n", rowHeaders[j],
                     Stats.getMoves(), Stats.getCompares(), Stats.getTime());
               }
               else if (outputFlag == IOFlags.TEXTFILE)
               {
                  pw.format("%25s %14d %14d %14d\n", rowHeaders[j],
                     Stats.getMoves(), Stats.getCompares(), Stats.getTime());
               }
            }
            if (outputFlag == IOFlags.CONSOLE)
            {
               System.out.println();
            }
            else if (outputFlag == IOFlags.TEXTFILE)
            {
               pw.format("\n");
            }
         }
      }

      if (outputFlag == IOFlags.CONSOLE)
      {
         System.out.println("Processor: Intel(R) Core(TM) i5-3210M CPU @ 2.50GHz\n" +
            "   CPU(s): 4\n" +
            "      Mem: 8053008");
      }
      else if (outputFlag == IOFlags.TEXTFILE)
      {
         pw.format("Processor: Intel(R) Core(TM) i5-3210M CPU @ 2.50GHz\n" +
            "   CPU(s): 4\n" +
            "      Mem: 8053008");
      }

      if (outputFlag == IOFlags.TEXTFILE)
      {
         pw.close();
         System.out.println("File written to successfully.");
      }
   }
}
