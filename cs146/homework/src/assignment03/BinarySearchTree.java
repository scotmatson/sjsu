package assignment03;

/**
 Created by scot on 6/28/15.
 */
public class BinarySearchTree<Integer>
{
   BinaryNode root;
   int height;

   BinarySearchTree ()
   {

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
      return height;
   }


   public void insert(Integer newData)
   {
      root = insert(root, newData);
   }

   private BinaryNode<Integer> insert(BinaryNode node, Integer newData)
   {
      if (node == null)
      {
         node = new BinaryNode(newData);
      }
      else
      {
         int compareResults = node.hcompareTo(newData);
         if (compareResults < 0)
         {
            node.setLeft(insert(node.getLeft(), newData));
         }
         else if (compareResults > 0)
         {
            node.setRight(insert(node.getRight(), newData));
         }
      }

      return node;
   } // END recursive insert()
}
