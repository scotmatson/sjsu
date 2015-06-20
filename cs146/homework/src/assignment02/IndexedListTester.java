package assignment02;

import java.util.Random;

/**
 Created by scot on 6/16/15.
 */
public class IndexedListTester
{
   public static void main(String[] args)
   {
      IndexedList<Integer> id = new IndexedList<>();
      Random rand = new Random();
      id.setAccessInterval(4);

      //id.add(24);
      //id.add(30);
      //id.add(9);
      //id.add(57);
      //id.add(95);
      //id.add(96);
      //id.add(32);
      //id.add(15);
      //id.printNodeGraph();

      for (int i = 0; i < 50; ++i)
      {
         id.add(rand.nextInt(100));
      }
      id.printNodeGraph();

      // Testing IndexedNode.set() method
      //for (int i = 0; i < 20; ++i)
      //{
      //   id.set(i, 1000);
      //}
      //id.printNodeGraph();

      for (int i = 0; i < 5; ++i)
      {
         int plug = rand.nextInt(id.size());
         System.out.println("Place: " + plug);

         id.add(plug ,Integer.MAX_VALUE);
      }

      id.printNodeGraph();
   }
}
