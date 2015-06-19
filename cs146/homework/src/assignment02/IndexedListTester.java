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
      for (int i = 0; i < 12; ++i)
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

      // Testing out of bounds exception of IndexedList.add(index, element) method
      //id.add(10, 2);

      // Testing initialization of IndexedList.add(index, element) method
      //id.clear();
      //id.add(0, 5);
      //id.add(1, 6);
      //id.add(0, 0);
      //id.add(1, 1);
      //System.out.println("Size of List: " + id.size());
      //System.out.println("Node 0: " + id.get(0));
      //System.out.println("Node 1: " + id.get(1));
      //System.out.println("Node 2: " + id.get(2));


      id.add(12, 1000);
      id.printNodeGraph();
   }
}
