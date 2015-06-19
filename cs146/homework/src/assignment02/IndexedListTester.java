package assignment02;

/**
 Created by scot on 6/16/15.
 */
public class IndexedListTester
{
   public static void main(String[] args)
   {
      System.out.printf("*** IndexedList Tester ***\n\n");
      IndexedList<Integer> id = new IndexedList<>();

      // Testing IndexedList.add(append) method
      //System.out.printf("Was 13 successfully added? %s\n", id.add(13) ? "true" : "False");
      //System.out.printf("Was 42 successfully added? %s\n", id.add(42) ? "true" : "False");
      //System.out.printf("Was 7 successfully added? %s\n", id.add(7) ? "true" : "False");
      //id.printList();


      // Testing IndexedList.clear() method
      //id.clear();
      //System.out.println("*** Testing 100 Random Values ***");
      //Random rand = new Random();

      // Testing IndexedList.add(append) method
      //for (int i = 0; i < 20; ++i)
      //{
      //   id.add(rand.nextInt(100));
      //}
      //id.printNodeGraph();

      // Testing IndexedNode.set() method
      //for (int i = 0; i < 20; ++i)
      //{
      //   id.set(i, 1000);
      //}
      //id.printNodeGraph();

      // Testing out of bounds exception of IndexedList.add(index, element) method
      //id.add(10, 2);

      // Testing initialization of IndexedList.add(index, element) method
      id.clear();
      //id.add(0, 5);
      //id.add(1, 6);
      id.add(0, 0);
      id.add(1, 1);

      id.printNodeGraph();
   }
}
