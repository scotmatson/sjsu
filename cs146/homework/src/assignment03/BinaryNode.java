package assignment03;

/**
 Created by scot on 6/28/15.
 */
public class BinaryNode <T>
{
   T data;
   BinaryNode<T> left;
   BinaryNode<T> right;

   BinaryNode(T data)
   {
      this.data = data;
      left = null;
      right = null;
   }

   public T getData()
   {
      return data;
   }

   public BinaryNode<T> getLeft()
   {
      return left;
   }

   public BinaryNode<T> getRight()
   {
      return right;
   }
}
