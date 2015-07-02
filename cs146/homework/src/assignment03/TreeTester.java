/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Test class for BinarySearchTree.java, AVLTree.java,
 and BinaryNode.java.

 Solves CS147 Homework Assignment #03

 @author Scot Matson
 @version 1.00 2015/06/30
 */

package assignment03;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TreeTester
{
   /**
    Generates a new Binary Search Tree and an associated sub-menu to
      interact with it.
    */
   private static void createNewBST()
   {
      Scanner in = new Scanner(System.in);
      boolean useBSTMenu = true;
      int option;
      BinarySearchTree<Integer> bst = new BinarySearchTree<>();
      Random rand = new Random();
      int n;
      for (int i = 0; i < 10; ++i)
      {
         n = rand.nextInt(90) + 10;
         // If this value already exists in the tree, cycle back and try again.
         if (bst.contains(n))
         {
            --i;
            continue;
         }

         bst.insert(n);
      }

      System.out.println("Binary Search Tree has been created.");
      System.out.println("What would you like to do next?\n");
      do {
         System.out.println("\nPlease choose an option from the menu below.");
         System.out.println("1. Repopulate BST with new data.");
         System.out.println("2. Find an existing data value.");
         System.out.println("3. Delete the root node.");
         System.out.println("4. Print the BST.");
         System.out.println("5. Return to the previous menu.");
         System.out.println("6. Exit the program.");
         try
         {
            System.out.print(">> ");
            option = in.nextInt();

            switch (option)
            {
               case 1:
                  System.out.println("Repopulating BST.");
                  createNewBST();
                  break;
               case 2:
                  System.out.print("Enter the Integer value you would like to find >> ");
                  boolean found;
                  try
                  {
                     found = bst.contains(in.nextInt());
                     if (found)
                     {
                        System.out.println("Found it!");
                     }
                     else
                     {
                        System.out.println("The value does not exist.");
                     }
                  }
                  catch (InputMismatchException e)
                  {
                     in.nextLine(); // Purge Scanner input.
                     System.out.println("That is not a valid input.");
                  }
                  break;
               case 3:
                  System.out.println("Removing the root node.");
                  try
                  {
                     bst.remove(bst.getRoot().getData());
                  }
                  catch (NullPointerException e)
                  {
                     System.out.println("The tree is empty.");
                  }
                  break;
               case 4:
                  System.out.println("\nPrinting BST.");
                  TreePrinter treePrinter = new TreePrinter(bst);
                  treePrinter.print("Binary Search Tree");
                  if (bst.isEmpty())
                  {
                     System.out.println("The tree is empty.");
                  }
                  break;
               case 5:
                  useBSTMenu = false;
                  break;
               case 6:
                  System.out.println("Goodbye.");
                  System.exit(0);
                  break;
               default:
                  System.out.println("I do not recognize your selection.");
                  break;
            }
         }
         catch (InputMismatchException e)
         {
            in.nextLine(); // Purge Scanner input.
            System.out.println("That is not a valid input.");
         }
      } while (useBSTMenu);
   }

   /**
    Sub-menu used to create and interact with an Adelson-Velskii and Landis Tree
    */
   private static void createNewAVL()
   {
      Scanner in = new Scanner(System.in);
      boolean useAVLMenu = true;
      int option;
      AVLTree<Integer> avl = new AVLTree<>();

      System.out.println("Adelson-Velksii and Landis Tree has been created.");
      System.out.println("What would you like to do next?\n");
      do
      {
         System.out.println("\nPlease choose an option from the menu below.");
         System.out.println("1. Reinitialize AVL tree.");
         System.out.println("2. Insert random value from [10, 99] into the tree.");
         System.out.println("3. Find an existing data value.");
         System.out.println("4. Delete the root node.");
         System.out.println("5. Print the AVL.");
         System.out.println("6. Return to the previous menu.");
         System.out.println("7. Exit the program.");
         try
         {
            System.out.print(">> ");
            option = in.nextInt();

            switch (option)
            {
               case 1:
                  System.out.println("Initializing the AVL.");
                  createNewAVL();
                  break;
               case 2:
                  int n;
                  Random rand = new Random();
                  do
                  {
                     n = rand.nextInt(90) + 10;
                  } while (avl.contains(n));
                  avl.insert(n);
                  System.out.println("Inserted value: " + n);
                  avl.checkBalance();
                  break;
               case 3:
                  System.out.print("Enter the Integer value you would like to find >> ");
                  boolean found;
                  try
                  {
                     found = avl.contains(in.nextInt());
                     if (found)
                     {
                        System.out.println("Found it!");
                     } else
                     {
                        System.out.println("The value does not exist.");
                     }
                  } catch (InputMismatchException e)
                  {
                     in.nextLine(); // Purge Scanner input.
                     System.out.println("That is not a valid input.");
                  }
                  break;
               case 4:
                  System.out.println("Removing the root node.");
                  try
                  {
                     avl.remove(avl.getRoot().getData());
                     avl.checkBalance();
                  } catch (NullPointerException e)
                  {
                     System.out.println("The tree is empty.");
                  }
                  break;
               case 5:
                  System.out.println("\nPrinting AVL.");
                  TreePrinter treePrinter = new TreePrinter(avl);
                  treePrinter.print("Adelson-Velskii and Landis Tree");
                  if (avl.isEmpty())
                  {
                     System.out.println("The tree is empty.");
                  }
                  break;
               case 6:
                  useAVLMenu = false;
                  break;
               case 7:
                  System.out.println("Goodbye.");
                  System.exit(0);
                  break;
               default:
                  System.out.println("I do not recognize your selection.");
                  break;
            }
         } catch (InputMismatchException e)
         {
            in.nextLine(); // Purge Scanner input.
            System.out.println("That is not a valid input.");
         }
      } while (useAVLMenu);
   }

   /**
    The main method, Entry point for the application.
    @param args the file to run.
    */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int option;
      boolean quit = false;
      System.out.println("*** Welcome to the BST/AVL Tester. ***\n");
      do {
         System.out.println("Please choose an option from the menu below.");
         System.out.println("1. Create a new Binary Search Tree (BST).");
         System.out.println("2. Create a new Adelson-Velskii & Landis Tree (AVL).");
         System.out.println("3. Run performance test.");
         System.out.println("4. Exit the program.");
         try
         {
            System.out.print(">> ");
            option = in.nextInt();

            switch (option)
            {
               case 1:
                  System.out.println("Creating BST Tree.");
                  createNewBST();
                  break;
               case 2:
                  System.out.println("Creating AVL Tree.");
                  createNewAVL();
                  break;
               case 3:
                  TreePerformanceTest tpt = new TreePerformanceTest("treePerformanceTest.txt");
                  tpt.insertionTest();
                  tpt.containsTest();
                  tpt.ratioPerformanceTest();
                  tpt.closePrintWriter();
                  System.out.println("\nPerformance test completed.");
                  System.out.println("Review results in file: treePerformanceTest.txt\n");
                  break;
               case 4:
                  quit = true;
                  System.out.println("Goodbye.");
                  System.exit(0);
                  break;
               default:
                  System.out.println("I do not recognize your selection.");
                  break;
            }
         }
         catch (InputMismatchException e)
         {
            in.nextLine(); // Purge Scanner input.
            System.out.println("That is not an option.");
         }

      } while (!quit);
   }


}
