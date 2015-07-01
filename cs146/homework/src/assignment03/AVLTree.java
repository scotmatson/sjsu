package assignment03;

/**
 Created by scot on 6/29/15.
 */
public class AVLTree<AnyType> extends BinarySearchTree<AnyType>
{

   private static final int ALLOWED_IMBALANCE = 1;

   AVLTree ()
   {
      super();
   }

   @Override
   public BinaryNode getRoot()
   {
      return super.getRoot();
   }

   @Override
   public boolean isEmpty()
   {
      return super.isEmpty();
   }

   @Override
   public int height()
   {
      return super.height();
   }

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

   @Override
   public void insert(Integer newData)
   {
      root = insert(newData, root);
   }


   protected BinaryNode<AnyType> insert(Integer newData, BinaryNode<AnyType> node)
   {
      node = super.insert(newData, node);
      return balance(node);
   }

   @Override
   public boolean contains(Integer possibleData)
   {
      return super.contains(possibleData);
   }

   @Override
   public void remove(Integer oldData)
   {
      root = remove(oldData, root);
   }

   @Override
   protected BinaryNode<AnyType> remove(Integer oldData, BinaryNode<AnyType> node)
   {
      node = super.remove(oldData, node);
      return balance(node);
   }

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

   private BinaryNode<AnyType> rotateWithLeftChild(BinaryNode<AnyType> k2)
   {
      BinaryNode<AnyType> k1 = k2.getLeft();
      k2.setLeft(k1.getRight());
      k1.setRight(k2);
      k2.setHeight(1 + Math.max(height(k2.getLeft()), height(k2.getRight())));
      k1.setHeight(1 + Math.max(height(k1.getLeft()), k2.getHeight()));
      return k1;
   }

   private BinaryNode<AnyType> rotateWithRightChild(BinaryNode<AnyType> k1)
   {
      BinaryNode<AnyType> k2 = k1.getRight();
      k1.setRight(k2.getLeft());
      k2.setLeft(k1);
      k1.setHeight(1 + Math.max(height(k1.getLeft()), height(k1.getRight())));
      k2.setHeight(1 + Math.max(height(k2.getRight()), k1.getHeight()));
      return k2;
   }

   private BinaryNode<AnyType> doubleWithLeftChild(BinaryNode<AnyType> k3)
   {
      k3.setLeft(rotateWithRightChild(k3.getLeft()));
      return rotateWithLeftChild(k3);
   }

   private BinaryNode<AnyType> doubleWithRightChild(BinaryNode<AnyType> k1)
   {
      k1.setRight(rotateWithLeftChild(k1.getRight()));
      return rotateWithRightChild(k1);
   }
}
