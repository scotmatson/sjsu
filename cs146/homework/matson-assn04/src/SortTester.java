/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Testing class for sorting algorithms.

 Solves CS147 Homework Assignment #04

 @author Scot Matson
 @version 1.00 2015/07/11
 */

package assignment04;

import java.io.IOException;
import java.io.PrintWriter;

public class SortTester
{
   public static void main(String[] args) throws IOException
   {
      PrintWriter pw = new PrintWriter("sortingAlgorithms.txt", "UTF-8");

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
         "ShellSort Knuth"
      };

      final Sortable[] sortingAlgorithms = {
         new InsertionSort(),
         new ShellSort(),
         new KnuthsShellSort()
      };

      final int minN = 100;
      final int maxN = 100000;
      final int multiplier = 10;

      for (int h = 0; h < headers.length; ++h)
      {
         //System.out.printf(headerShift[h], headers[h]);
         pw.format(headerShift[h], headers[h]);

         for (int N = minN; N <= maxN; N *= multiplier)
         {
            //System.out.printf("N = %d\n", N);
            pw.format("N = %d\n", N);
            //System.out.printf("%71s", tableHead);
            pw.format("%71s", tableHead);

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

            for (int j = 0; j < rowHeaders.length; ++j)
            {
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
               //System.out.printf("%25s %14d %14d %14d\n", rowHeaders[j],
               //   Stats.getMoves(), Stats.getCompares(), Stats.getTime());
               pw.format("%25s %14d %14d %14d\n", rowHeaders[j],
                  Stats.getMoves(), Stats.getCompares(), Stats.getTime());
            }
            //System.out.println();
            pw.format("\n");
         }
      }

      pw.write("Processor: Intel(R) Core(TM) i5-3210M CPU @ 2.50GHz\n" +
         "   CPU(s): 4\n" +
         "      Mem: 8053008");

      pw.close();
   }
}
