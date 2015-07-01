/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved

 Creates a Binary Search Tree.

 Solves CS147 Homework Assignment #03

 @author Scot Matson
 Code partially adapted from:
 Data Structures and Algorithms, 3rd Edition by Mark Allen Weiss
 @version 1.00 2015/06/30
 */

package assignment03;

public class BinarySearchTree<AnyType>
{
   BinaryNode root;

   /**
    Constructor method.
    */
   BinarySearchTree ()
   {
      root = null;
   }

   /**
    Returns the root node.

    @return The root node.
    */
   public BinaryNode getRoot()
   {
      return root;
   }

   /**
    Returns true if the tree is empty.

    @return A boolean value.
    */
   public boolean isEmpty()
   {
      return (root == null);
   }

   /**
    The height of the tree.

    @return The height.
    */
   public int height()
   {
      return height(root);
   }

   /**
    Returns the height of a given node or -1 if null.

    @param node the node to evaluate
    @return the height of a given node
    */
   private int height(BinaryNode<AnyType> node)
   {
      if (node == null)
      {
         return -1;
      }
      else
      {
         return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
      }
   }

   /**
    Inserts new Integer data into a BinaryNode and places the node within
      the BinarySearchTree.

    @param newData Integer value to insert.
    */
   public void insert(Integer newData)
   {
      root = insert(newData, root);
   }

   /**
    Recursive helper method. Inserts a new BinaryNode into the BinarySearchTree.

    @param newData Integer value to insert.
    @param node root node.
    @return nodes to return.
    */
   protected BinaryNode<AnyType> insert(Integer newData, BinaryNode<AnyType> node)
   {
      if (node == null)
      {
         node = new BinaryNode(newData);
      }
      else
      {
         int compareResults = newData.compareTo(node.getData());

         if (compareResults < 0)
         {
            node.setLeft(insert(newData, node.getLeft()));
         }
         else if (compareResults > 0)
         {
            node.setRight(insert(newData, node.getRight()));
         }
      }

      return node;
   } // END recursive insert()

   /**
    Finds a given Integer value if one exists. Returns true if the value
    is found.

    @param possibleData the Integer value to find.
    @return true if the value exists, otherwise false.
    */
   public boolean contains(Integer possibleData)
   {
      return contains(possibleData, root);
   }

   /**
    Recursive helper method to find a given Integer value if one exists.
    Returns true if the value is found.

    @param possibleData the Integer value to find.
    @param node the current Node to evaluate.
    @return true is the value exists, otherwise false.
    */
   private boolean contains(Integer possibleData, BinaryNode<AnyType> node)
   {
      // No match found.
      if (node == null)
      {
         return false;
      }
      else
      {
         int compareResult = possibleData.compareTo(node.getData());
         if (compareResult < 0)
         {
            return contains(possibleData, node.getLeft());
         }
         else if (compareResult > 0)
         {
            return contains(possibleData, node.getRight());
         }

         // Match found.
         return true;
      }
   }

   /**
    Given a data value, the associated node is removed from the tree if
      the value exists.

    @param oldData The data to remove.
    */
   public void remove(Integer oldData)
   {
      root = remove(oldData, root);
   }

   /**
    Recursively traverses the tree attempting to remove a given node.

    @param oldData The data to remove.
    @param node The node to search from.
    @return The updated node structure.
    */
   protected BinaryNode<AnyType> remove(Integer oldData, BinaryNode<AnyType> node)
   {
      // Node does not exist, do nothing.
      if (node == null)
      {
         return node;
      }

      // Otherwise locate and remove the node.
      int compareResult = oldData.compareTo(node.getData());

      if (compareResult < 0)
      {
         node.setLeft(remove(oldData, node.getLeft()));
      }
      else if (compareResult > 0)
      {
         node.setRight(remove(oldData, node.getRight()));
      }
      // In the event that two children exist...
      else if (node.getLeft() != null && node.getRight() != null)
      {
         node.setData(findMin(node.getRight()).getData());
         node.setRight(remove(node.getData(), node.getRight()));
      }
      else
      {
         node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
      }

      return node;
   }

   /**
    Finds the minimum value in the tree.

    @param node The node to search from.
    @return The minimum value.
    */
   private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node)
   {
      // Handles the initial case that the argument may be null.
      if (node == null)
      {
         return null;
      }
      // Returns the leftmost node which represents the smallest value.
      else if (node.getLeft() == null)
      {
         return node;
      }

      return findMin(node.getLeft());
   }


}
