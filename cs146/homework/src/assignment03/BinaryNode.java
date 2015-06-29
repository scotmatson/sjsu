package assignment03;

/**
 Created by scot on 6/28/15.
 */
public class BinaryNode<AnyType>
{
   private Integer data;
   private BinaryNode<AnyType> leftChild;
   private BinaryNode<AnyType> rightChild;

   BinaryNode(Integer data)
   {
      this(data, null, null);
   }

   BinaryNode(Integer data, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt)
   {
      this.data = data;
      this.leftChild = lt;
      this.rightChild = rt;
   }

   /**
      Getters and Setters
    */
   public Integer getData() { return this.data; }
   public void setData(Integer data) { this.data = data; }
   public BinaryNode<AnyType> getLeft() { return leftChild; }
   public void setLeft(BinaryNode newNode) { this.leftChild = newNode; }
   public BinaryNode<AnyType> getRight() { return rightChild; }
   public void setRight(BinaryNode newNode) { this.rightChild = newNode; }
}
