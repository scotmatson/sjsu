package assignment02;

import java.util.Random;

/**
 Created by scot on 6/17/15.
 */
public class IndexedList2Tester
{
   public static void main(String[] args)
   {
      Random rand = new Random();
      IndexedList2<Integer> il2= new IndexedList2<>();

      il2.add(13);
      System.out.println("IL2 Index 0: " + il2.get(0));
      System.out.println("Expected 13.");

      // Populating il2 with values.
      for (int i = 0; i < 100; ++i)
      {
         il2.add(rand.nextInt(100));
      }

      il2.getArrayList();
      System.out.println("Expecting: 13");
 }
}
