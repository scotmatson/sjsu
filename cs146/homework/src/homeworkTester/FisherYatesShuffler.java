package homeworkTester;

import java.util.Random;

/**
 Created by scot on 7/18/15.
 */
public class FisherYatesShuffler
{
   public static void main(String[] args)
   {
      int[] intArr = new int[10];
      for (int i = 0; i < 10; ++i)
      {
         intArr[i] = i;
         System.out.print(intArr[i] + " ");
      }

      System.out.println();

      intArr = shuffleNumbers(intArr);
      for (int i = 0; i < 10; ++i)
      {
         System.out.print(intArr[i] + " ");
      }

   }

   public static int[] shuffleNumbers(int[] numbers)
   {
      Random rand = new Random();
      for (int i = numbers.length - 1; i > 0; i--)
      {
         int index = rand.nextInt(i + 1);

         // Simple swap
         int temp = numbers[index];
         numbers[index] = numbers[i];
         numbers[i] = temp;
      }

      return numbers;
   }
   //{
   //   Random rand = new Random();
   //   Integer index, temp;
   //   for (int i = numbers.length - 1; i > 0; --i)
   //   {
   //      index = rand.nextInt(i + 1);
   //
   //      temp = numbers[index];
   //      numbers[index] = numbers[i];
   //      numbers[i] = temp;
   //   }
   //
   //   return numbers;
   //}
}
