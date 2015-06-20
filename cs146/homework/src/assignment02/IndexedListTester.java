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

      // STATIC TEST VALUES
      id.add(24);
      id.add(30);
      id.add(87);
      id.add(64);
      id.add(22);
      id.add(8);
      id.add(16);
      id.add(27);
      id.add(84);
      id.add(98);
      id.add(42);
      id.add(21);
      id.add(36);
      //id.add(99);
      id.printNodeGraph();

      // RANDOM TEST VALUES
      //for (int i = 0; i < 20; ++i)
      //{
      //   id.add(rand.nextInt(100));
      //}
      //id.printNodeGraph();


      // SET TEST
      //for (int i = 0; i < 20; ++i)
      //{
      //   id.set(i, 1000);
      //}
      //id.printNodeGraph();

      // INDEX ADD TEST
      //for (int i = 0; i < 5; ++i)
      //{
      //   int plug = rand.nextInt(id.size());
      //   System.out.println("Place: " + plug);
      //
      //   id.add(plug ,Integer.MAX_VALUE);
      //}

      id.remove(12);
      id.printNodeGraph();
   }
}
