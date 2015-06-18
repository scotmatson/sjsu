package assignment02;

import java.util.Random;

/**
 Created by scot on 6/16/15.
 */
public class IndexedListTester
{
   public static void main(String[] args)
   {
      System.out.printf("*** IndexedList Tester ***\n\n");

      IndexedList<Integer> id = new IndexedList<>();

      System.out.printf("Was 13 successfully added? %s\n", id.add(13) ? "true" : "False");
      System.out.printf("Was 42 successfully added? %s\n", id.add(42) ? "true" : "False");
      System.out.printf("Was 7 successfully added? %s\n", id.add(7) ? "true" : "False");
      //id.printList();


      id.clear();
      System.out.println("*** Testing 100 Random Values ***");
      Random rand = new Random();
      for (int i = 0; i < 20; ++i)
      {
         id.add(rand.nextInt(100));
      }

      id.printNodeGraph();
      for (int i = 0; i < 10; ++i) {
         System.out.println("Value at position: " + i + " : " + id.get(i));
      }
   }
}
