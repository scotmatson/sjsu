package assignment03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 Created by scot on 6/30/15.
 */
public class TreePerformanceTest
{
   private BinarySearchTree bst;
   private AVLTree avl;
   private PrintWriter pw;
   private Random rand = new Random();
   private final int RANGE = 9999999; // Values generated from 0 to (n - 1)
   private final int CYCLES = 10000000;
   private long startBST, endBST, startAVL, endAVL;

   /**
    Constructor method.
    @param outputFile The name of the output file.
    */
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
      for (int i = 10; i <= CYCLES; i *= 10)
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
      startBST = System.currentTimeMillis();
      for (int i = 0; i < n; ++i)
      {
         bst.insert(rand.nextInt(RANGE));
      }
      endBST = System.currentTimeMillis() - startBST;

      // AVL TEST
      avl = new AVLTree();
      startAVL = System.currentTimeMillis();
      for (int i = 0; i < n; ++i)
      {
         avl.insert(rand.nextInt(RANGE));
      }
      endAVL = System.currentTimeMillis() - startAVL;

      pw.format("%10d    %15d    %15d\n", n, endBST, endAVL);
   }

   /**
    Performance test for the contains method for the BST and AVL tree.
    */
   public void containsTest()
   {
      pw.format("\n\n%43s\n\n", "*** Contains Performance Test ***");
      pw.format("%10s    %15s    %15s\n", "N", "bst.contains()", "avl.contains()");
      containsTest(CYCLES);
   }

   /**
    Performance test for the contains method for the BST and AVL tree.
    */
   public void containsTest(int n)
   {
      // BST TEST
      startBST = System.currentTimeMillis();
      for (int i = 1; i <= n; ++i)
      {
         bst.contains(rand.nextInt(RANGE));
      }
      endBST = System.currentTimeMillis() - startBST;

      // AVL TEST
      startAVL = System.currentTimeMillis();
      for (int i = 1; i < n; ++i)
      {
         avl.contains(rand.nextInt(RANGE));
      }
      endAVL = System.currentTimeMillis() - startAVL;

      pw.format("%10d    %15d    %15d\n", n, endBST, endAVL);
   }

   /**
    50 cycles of running the insert and contains method
      together using an AVL and BST with randomly generated values of n and k.
    */
   public void ratioPerformanceTest()
   {
      pw.format("\n\n%43s\n", "*** Ratio Performance Test ***");
      int n;
      for (int i = 0; i < 50; ++i)
      {
         pw.print("================================================\n");
         n = rand.nextInt(CYCLES);
         pw.format("%10s    %15s    %15s\n", "N", "bst.insert()", "avl.insert()");
         insertionTest(n);

         n = rand.nextInt(CYCLES);
         pw.format("%29s    %15s\n", "bst.contains()", "avl.contains()");
         containsTest(n);
         pw.write("\n");
      }
   }
}
