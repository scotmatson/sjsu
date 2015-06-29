package assignment03;

/**
 Created by scot on 6/28/15.
 */
public class BinaryNode<Integer> implements Comparable<Integer>
{
   private Integer data;
   private BinaryNode<Integer> leftChild;
   private BinaryNode<Integer> rightChild;
   private int height;

   BinaryNode(Integer data)
   {
      this(data, null, null);
   }

   BinaryNode(Integer data, BinaryNode<Integer> lt, BinaryNode<Integer> rt)
   {
      this.data = data;
      this.leftChild = lt;
      this.rightChild = rt;
   }

   public Integer getData()
   {
      return this.data;
   }

   public BinaryNode<Integer> getLeft()
   {
      return leftChild;
   }
   public void setLeft(BinaryNode newNode)
   {
      this.leftChild = newNode;
   }

   public BinaryNode<Integer> getRight()
   {
      return rightChild;
   }
   public void setRight(BinaryNode newNode)
   {
      this.rightChild = newNode;
   }

   @Override
   public int compareTo(Integer o)
   {
      return -1;
   }
}
