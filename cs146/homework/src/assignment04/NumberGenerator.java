package assignment04;

import java.util.*;

/**
 COPYRIGHT (2015) Scot Matson

 Random number generator.

 TODO: Need unique and duplicate reverse order test
 */
public class NumberGenerator
{
   private Set<Integer> integerSet;
   private List<Integer> integerList;
   private Random rand = new Random();
   private int size;

   NumberGenerator (int size)
   {
      this.size = size;
   }

   public List<Integer> getIntegerList()
   {
      return integerList;
   }
   public Set<Integer> getIntegerSet()
   {
      return integerSet;
   }


   public void generateZeroList()
   {
      integerList = new LinkedList<>();
      while (integerList.size() < size)
      {
         integerList.add(0);
      }
   }

   /**
    Generates a random List of Integer values with duplicates allowed.
    @param range The range of allowed values.
    */
   public void generateRandomIntegers(int range)
   {
      integerList = new LinkedList<>();
      while (integerList.size() < size)
      {
         integerList.add(rand.nextInt(range));
      }
   }

   /**
    Generates a random Set of Integer values with unique values.
    @param range The range of allowed values.
    */
   public void generateUniqueRandomIntegers(int range)
   {
      integerSet = new LinkedHashSet<>();
      while (integerSet.size() < size)
      {
         integerSet.add(rand.nextInt(range));
      }
   }

   /**
    Test method to ensure values are being printed.
    */
   public void printIntegerSet()
   {
      if (integerSet != null && !integerSet.isEmpty())
      {
         for (Integer i : integerSet)
         {
            System.out.printf("%d\n", i);
         }
      }

      if (integerList != null && !integerList.isEmpty())
      {
         for (Integer i : integerList)
         {
            System.out.printf("%d\n", i);
         }
      }
   }
}
