package assignment02;

/**
 Created by scot on 6/16/15.
 */
public class IndexedListTester
{
   public static void main(String[] args)
   {
      System.out.printf("***Initiate test for IndexedList***\n\n");

      // Constructor case with no argument
      IndexedList indexedList = new IndexedList();
      System.out.printf("Current size of IndexedList: %d\n", indexedList.size());
      System.out.printf("Expected: 0\n\n");

      // Constructor case with argument
      indexedList = new IndexedList(13);
      System.out.printf("Current size of IndexList: %d\n", indexedList.size());
      System.out.printf("Expected: 1\n\n");

      // Resetting the IndexedList
      indexedList.clear();
      System.out.printf("Current size of IndexList: %d\n", indexedList.size());
      System.out.printf("Expected: 0\n\n");

      // Adding initial value to an empty list
      indexedList.add(42);
      System.out.printf("Current size of IndexList: %d\n", indexedList.size());
      System.out.printf("Expected: 1\n\n");

   }
}
