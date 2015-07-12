/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved

 Class to generate nodes for use with a tree type data structure.
   Used specifically with a BST or AVL tree data structure.

 Solves CS147 Homework Assignment #03

 @author Scot Matson
 @version 1.00 2015/06/30
 */
package assignment03;

public class BinaryNode<AnyType>
{
   private Integer data;
   private BinaryNode<AnyType> leftChild;
   private BinaryNode<AnyType> rightChild;
   private int height;

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
   public int getHeight() { return height; }
   public void setHeight(int height) { this.height = height; }
}
