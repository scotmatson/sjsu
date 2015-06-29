package assignment03;

/**
 Created by scot on 6/28/15.
 */
public class BinarySearchTree<AnyType>
{
   BinaryNode root;

   BinarySearchTree ()
   {
      root = null;
   }

   public BinaryNode getRoot()
   {
      return root;
   }

   public boolean isEmpty()
   {
      return root == null;
   }

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
      return (node == null)
         ? -1 : 1 + Math.max(height(node.getLeft()), height(node.getRight()));
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
   private BinaryNode<AnyType> insert(Integer newData, BinaryNode<AnyType> node)
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

   public void remove(Integer oldData)
   {
      root = remove(oldData, root);
   }

   public BinaryNode<AnyType> remove(Integer oldData, BinaryNode<AnyType> node)
   {
      return node;
   }


}
