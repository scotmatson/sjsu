package assignment03;

/**
 Created by scot on 6/29/15.
 */
public class AVLNode<AnyType> extends BinaryNode<AnyType>
{
   int height;

   AVLNode(Integer data)
   {
      super(data);
   }

   AVLNode(Integer data, AVLNode<AnyType> lt, AVLNode<AnyType> rt)
   {
      super(data, lt, rt);
   }

   /**
    Getters and Setters
    */
   @Override
   public Integer getData() { return super.getData(); }
   @Override
   public void setData(Integer data) { super.setData(data); }
   @Override
   public BinaryNode<AnyType> getLeft() { return super.getLeft(); }
   @Override
   public void setLeft(BinaryNode newNode) { super.setLeft(newNode); }
   @Override
   public BinaryNode<AnyType> getRight() { return super.getRight(); }
   @Override
   public void setRight(BinaryNode newNode) { super.setRight(newNode); }
   public int getHeight() { return height; }
   public void setHeight(int height) { this.height = height; }
}
