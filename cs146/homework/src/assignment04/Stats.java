package assignment04;

/**
 Created by scot on 7/11/15.
 */
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
