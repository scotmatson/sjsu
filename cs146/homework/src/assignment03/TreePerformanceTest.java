package assignment03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 Created by scot on 6/30/15.
 */
public class TreePerformanceTest
{
   BinarySearchTree bst;
   AVLTree avl;
   PrintWriter pw;
   Random rand = new Random();

   TreePerformanceTest (String outputFile)
   {
      bst = new BinarySearchTree();
      avl = new AVLTree();
      try
      {
         pw = new PrintWriter(outputFile);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Unable to generate output file. Test aborted.");
      }

   }

   /**
    Closes the PrintWriter.
    */
   public void closePrintWriter()
   {
      pw.close();
   }

   /**
    Initializes the Insertion Test.
    */
   public void insertionTest()
   {
      pw.format("%43s\n\n", "*** Insertion Performance Test ***");
      pw.format("%10s    %15s    %15s\n", "N", "bst.insert()", "avl.insert()");
      for (int i = 10; i <= 1000000; i *= 10)
      {
         insertionTest(i);
      }
   }

   /**
    Performance test for the insertion method for a BST and AVL Tree.
    @param n the number of iterations to run per cycle.
    */
   private void insertionTest(int n)
   {
      // BST TEST
      bst = new BinarySearchTree();
      long startBST = System.currentTimeMillis();
      for (int i = 0; i < n; ++i)
      {
         bst.insert(rand.nextInt(9999999));
      }
      long endBST = System.currentTimeMillis() - startBST;

      // AVL TEST
      avl = new AVLTree();
      long startAVL = System.currentTimeMillis();
      for (int i = 0; i < n; ++i)
      {
         avl.insert(rand.nextInt(9999999));
      }
      long endAVL = System.currentTimeMillis() - startAVL;

      pw.format("%10d    %15d    %15d\n", n, endBST, endAVL);
   }

   /**
    Performance test for the contains method for the BST and AVL Tree. Runs
      1 million random values through a tree with ~1 million nodes.
    */
   public void containsTest()
   {
      pw.format("\n\n%43s\n\n", "*** Contains Performance Test ***");
      pw.format("%10s    %15s    %15s\n", "N", "bst.contains()", "avl.contains()");

      // BST TEST
      long startBST = System.currentTimeMillis();
      for (int i = 1; i <= 1000000; ++i)
      {
         bst.contains(rand.nextInt(9999999));
      }
      long endBST = System.currentTimeMillis() - startBST;

      // AVL TEST
      long startAVL = System.currentTimeMillis();
      for (int i = 1; i < 1000000; ++i)
      {
         avl.contains(rand.nextInt(9999999));
      }
      long endAVL = System.currentTimeMillis() - startAVL;

      pw.format("%10d    %15d    %15d\n", 1000000, endBST, endAVL);
   }
}
