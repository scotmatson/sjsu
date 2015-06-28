package assignment03;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 Created by scot on 6/28/15.
 */
public class TreeTester
{


   private static void createNewBST()
   {
      Scanner in = new Scanner(System.in);
      int option;
      BinarySearchTree<Integer> bst = new BinarySearchTree<>();

      System.out.println("Binary Search Tree has been created.");
      System.out.println("What would you like to do next?\n");
      do {
         System.out.println("Please choose an option from the menu below.");
         System.out.println("1. Repopulate BST with new data.");
         System.out.println("2. Print the BST.");
         System.out.println("3. Exit the program.");
         System.out.println("4. Return to the previous menu.");
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
                  System.out.println("Printing BST.");
                  TreePrinter treePrinter = new TreePrinter(bst);
                  break;
               case 3:
                  System.out.println("Goodbye.");
                  System.exit(0);
                  break;
               case 4:
                  return;
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
      } while (true);
   }

   private static void createNewAVL()
   {
      System.out.println("This feature has not yet been implemented.\n");
      return;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      BinarySearchTree tree;
      int option;
      boolean quit = false;
      System.out.println("*** Welcome to the BST/AVL Tester. ***\n");
      do {
         System.out.println("Please choose an option from the menu below.");
         System.out.println("1. Create a new Binary Search Tree (BST).");
         System.out.println("2. Create a new Adelson-Velskii & Landis Tree (AVL).");
         System.out.println("3. Exit the program.");
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
