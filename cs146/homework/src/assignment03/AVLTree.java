/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved

 Creates an Adelson-Velkskii and Landis Tree,
   child class of the Binary Search Tree.

 Solves CS147 Homework Assignment #03

 @author Scot Matson
 Code partially adapted from:
 Data Structures and Algorithms, 3rd Edition by Mark Allen Weiss
 @version 1.00 2015/06/30
 */

package assignment03;

public class AVLTree<AnyType> extends BinarySearchTree<AnyType>
{

   private static final int ALLOWED_IMBALANCE = 1;

   /**
    Constructor method.
    */
   AVLTree ()
   {
      super();
   }

   /**
    Returns the root node.

    @return The root node.
    */
   @Override
   public BinaryNode getRoot()
   {
      return super.getRoot();
   }

   /**
    Returns true of the root node has not yet been initialized.

    @return A boolean value.
    */
   @Override
   public boolean isEmpty()
   {
      return super.isEmpty();
   }

   /**
    The total height of the tree.

    @return The height of the tree.
    */
   @Override
   public int height()
   {
      return super.height();
   }

   /**
    Returns the height of a given node.

    @param node The node to assess.
    @return The height of the given node.
    */
   private int height(BinaryNode<AnyType> node)
   {
      if (node == null)
      {
         return -1;
      }
      else
      {
         return node.getHeight();
      }
   }

   /**
    Given an Integer value, a new node is created and inserted into
      the tree.

    @param newData Integer value to insert.
    */
   @Override
   public void insert(Integer newData)
   {
      root = insert(newData, root);
   }

   /**
    Traverses a tree from a given node and recursively inserts a new node.

    @param newData Integer value to insert.
    @param node root node.
    @return The updated node structure.
    */
   protected BinaryNode<AnyType> insert(Integer newData, BinaryNode<AnyType> node)
   {
      node = super.insert(newData, node);
      return balance(node);
   }

   /**
    Returns true if the value exists in the tree.

    @param possibleData the Integer value to find.
    @return A boolean value.
    */
   @Override
   public boolean contains(Integer possibleData)
   {
      return super.contains(possibleData);
   }

   /**
    Removes a node from the tree given its data as an argument.

    @param oldData The data to remove.
    */
   @Override
   public void remove(Integer oldData)
   {
      root = remove(oldData, root);
   }

   /**
    Recursively traverses a given node structure to find a specified node
      to remove based upon the given data argument.

    @param oldData The data to remove.
    @param node The node to traverse from.
    @return The updated node structure.
    */
   @Override
   protected BinaryNode<AnyType> remove(Integer oldData, BinaryNode<AnyType> node)
   {
      node = super.remove(oldData, node);
      return balance(node);
   }

   /**
    Balances a given node structure to ensure optimal performance for
      future operations.

    @param node The node to traverse from.
    @return The updated node structure.
    */
   private BinaryNode<AnyType> balance(BinaryNode<AnyType> node)
   {
      // Tree is empty. There is nothing to balance.
      if (node == null)
      {
         return node;
      }

      if (height(node.getLeft()) - height(node.getRight()) > ALLOWED_IMBALANCE)
      {
         if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight()))
         {
            node = rotateWithLeftChild(node);
         }
         else
         {
            node = doubleWithLeftChild(node);
         }
      }
      else
      {
         if (height(node.getRight()) - height(node.getLeft()) > ALLOWED_IMBALANCE)
         {
            if (height(node.getRight().getRight()) >= height(node.getRight().getLeft()))
            {
               node = rotateWithRightChild(node);
            }
            else
            {
               node = doubleWithRightChild(node);
            }
         }
      }

      node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
      return node;
   }

   /**
    Performs a single left rotation.
    Solves AVL case 1.

    @param k2 The node to rotate.
    @return The updated node structure.
    */
   private BinaryNode<AnyType> rotateWithLeftChild(BinaryNode<AnyType> k2)
   {
      System.out.println("Single right rotation.");
      BinaryNode<AnyType> k1 = k2.getLeft();
      k2.setLeft(k1.getRight());
      k1.setRight(k2);
      k2.setHeight(1 + Math.max(height(k2.getLeft()), height(k2.getRight())));
      k1.setHeight(1 + Math.max(height(k1.getLeft()), k2.getHeight()));
      return k1;
   }

   /**
    Performs a single right rotation.
    Solves AVL case 4.

    @param k1 The node to rotate.
    @return The updated node structure.
    */
   private BinaryNode<AnyType> rotateWithRightChild(BinaryNode<AnyType> k1)
   {
      System.out.println("Single left rotation.");
      BinaryNode<AnyType> k2 = k1.getRight();
      k1.setRight(k2.getLeft());
      k2.setLeft(k1);
      k1.setHeight(1 + Math.max(height(k1.getLeft()), height(k1.getRight())));
      k2.setHeight(1 + Math.max(height(k2.getRight()), k1.getHeight()));
      return k2;
   }

   /**
    Performs a double left-right rotation.
    Solves AVL case 4.

    @param k3 The node to rotate.
    @return The updated node structure.
    */
   private BinaryNode<AnyType> doubleWithLeftChild(BinaryNode<AnyType> k3)
   {
      System.out.println("Double left-right rotation.");
      k3.setLeft(rotateWithRightChild(k3.getLeft()));
      return rotateWithLeftChild(k3);
   }

   /**
    Performs a double right-left rotation.
    Solves AVL case 3.

    @param k1 The node to rotate.
    @return The updated node structure.
    */
   private BinaryNode<AnyType> doubleWithRightChild(BinaryNode<AnyType> k1)
   {
      System.out.println("Double right-left rotation.");
      k1.setRight(rotateWithLeftChild(k1.getRight()));
      return rotateWithRightChild(k1);
   }

   /**
    Checks to ensure the tree is balanced.
    */
   public void checkBalance()
   {
      checkBalance(root);
   }

   /**
    Recursive method to assess whether the tree is balanced.

    @param node The starting node.
    @return The unbalanced node.
    */
   private int checkBalance(BinaryNode<AnyType> node)
   {
      if (node == null)
      {
         return -1;
      }

      int hl = checkBalance(node.getLeft());
      int hr = checkBalance(node.getRight());
      if (Math.abs(height(node.getLeft()) - height(node.getRight()) ) > 1 ||
         height(node.getLeft()) != hl || height(node.getRight()) != hr)
      {
         System.out.println("Unbalanced Trees.");
      }

      return height(node);
   }
}
