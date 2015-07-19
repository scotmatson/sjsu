/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Statistics for tracking performance of a sorting algorithm.

 Solves CS147 Homework Assignment #04

 @author Scot Matson
 @version 1.00 2015/07/11
 */

package Assignment05;

public class Stats
{
   private static long compares;
   private static long moves;
   private static long time;

   Stats ()
   {
      clearStats();
   }

   public static void clearStats()
   {
      compares = 0;
      moves = 0;
      time = 0;
   }

   public static void incrementMoves()
   {
      ++moves;
   }

   public static void incrementCompares()
   {
      ++compares;
   }

   public static long getCompares()
   {
      return compares;
   }

   public static long getMoves()
   {
      return moves;
   }

   public static void startTime()
   {
      time = System.currentTimeMillis();
   }

   public static void stopTime()
   {
      time = (System.currentTimeMillis() - time);
   }

   public static long getTime()
   {
      return time;
   }
}
