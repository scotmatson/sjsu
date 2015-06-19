/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved

 Implementation of a List type which optimizes accessing, retrieving, insertion,
   and deletion by interweaving a Doubly LinkedList with an ArrayList.

 Solves CS 146 homework assignmen #2

 @author Scot Matson

 @version 1.00 2015/6/16
 */
package assignment02;

import java.util.*;

public class IndexedList<Integer> implements List<Integer>
{
   Node head;
   Node tail;
   List<Node> al;
   int listSize;
   int accessInterval;

   /**
    Constructor method for a new IndexedList. Initializes instance variables
      by calling the IndexedList.clear() method.
    */
   public IndexedList()
   {
      clear();
   }

   /**
    Returns the number of elements in the IndexedList.
    @return the number of elements as an int value.
    */
   @Override
   public int size()
   {
      return listSize;
   }

   /**
    Initializes the head and tail nodes of the IndexedList.
    @param newNode
    */
   private void initializeList(Node newNode)
   {
      head = tail = newNode;
   }

   /**
    Helper method. Appends a node to the end of the IndexedList.
    @param newNode
    */
   private void pushNode(Node newNode)
   {
      newNode.previous = tail;
      tail.next = newNode;
      tail = tail.next;
   }

   /**
    Appends an Integer to the end of the IndexedList.
    @param integer
    @return
    */
   @Override
   public boolean add(Integer integer)
   {
      Node newNode = new Node(integer);
      if (head == null)
      {
         initializeList(newNode);
      }
      else
      {
         pushNode(newNode);
      }
      createIndexInterval();
      ++listSize;

      return true;
   }

   @Override
   public void add(int index, Integer integer)
   {
      if (index < 0 || index > listSize)
         throw new IndexOutOfBoundsException("Index out of bounds.");

      Node newNode = new Node(integer);
      if (head == null)
      {
         initializeList(newNode);
      }
      else if (index == listSize)
      {
         pushNode(newNode);
      }
      else
      {
         System.out.println("Index: " + index);
         System.out.println("Node 0: " + getNode(1).data);
      }
      createIndexInterval();
      ++listSize;
   }

   /**
    Returns all instances variables to intialized state.
    */
   @Override
   public void clear()
   {
      head = null;
      tail = null;
      al = new ArrayList<>();
      listSize = 0;
      accessInterval = 10;
   }

   public void setAccessInterval(int k)
   {
      accessInterval = k;
   }

   /**
    Given an index, the stored integer value from the node at that location
      is returned.

    @param index
    @return an integer from a specified location
    */
   @Override
   public Integer get(int index)
   {
      Node currentNode = getNode(index);
      return currentNode.data;
   }

   /**
    Helper method. Given an index, will return a node at that location.
    @param index
    @return
    */
   public Node getNode(int index)
   {
      if (index < 0 || index >= listSize)
         throw new IndexOutOfBoundsException("Index out of bounds.");

      Node currentNode;
      int startPosition;
      int accessIndex;
      int step;

      // INCREMENTING
      if (index % accessInterval < 5) {
         startPosition = (index - (index % accessInterval));
         accessIndex = startPosition / accessInterval;
         step = index - startPosition;
         currentNode = al.get(accessIndex);
         while (currentNode.hasNext() && step > 0)
         {
            currentNode = currentNode.next;
            --step;
         }
      }
      // DECREMENTING
      else {
         startPosition = ((index / accessInterval) + 1) * accessInterval;
         // Condition to adjust for off-by-one error when the startPosition is the size
         //   of the ArrayList
         if (startPosition == al.size() * accessInterval) {
            currentNode = tail;
            step = startPosition - index - 1;
         }
         else
         {
            accessIndex = (startPosition / accessInterval);
            step = startPosition - index;
            currentNode = al.get(accessIndex);
         }
         while (currentNode.hasPrevious() && step > 0)
         {
            currentNode = currentNode.previous;
            --step;
         }
      }
      return currentNode;
   }

   /**
    Sets a new integer value at the node at the given index.
    @param index
    @param integer
    @return the old value
    */
   @Override
   public Integer set(int index, Integer integer)
   {
      Node currentNode = getNode(index);
      Integer previousValue = currentNode.data;
      currentNode.data = integer;
      return previousValue;
   }

   @Override
   public Integer remove(int index)
   {
      return null;
   }

   /**
    Generates indices throughout the LinkedList at the kth value.
    */
   public void createIndexInterval()
   {
      if (listSize % accessInterval == 0)
         al.add(tail);
   }

   public void shiftIndexIntervals()
   {
      // TODO: Create logic to follow insertion/deletion of nodes
      // Cases: Edge, Shared, Pre, Post
   }

   public void printNodeGraph()
   {
      ArrayList<String> output = new ArrayList<>();
      Node currentNode = head;

      while (currentNode.hasNext())
      {
         output.add(String.valueOf(currentNode.data));
         currentNode = currentNode.next;

      }
      output.add(String.valueOf(currentNode.data));

      System.out.println("*** Generate Node Graph ***");
      for (int i = 0; i < al.size(); ++i)
         if ((i / accessInterval) == 0)
            output.set(accessInterval * i, output.get(accessInterval*i) + " [" + al.get(i).data + "]");

      for (int i = 0; i < output.size(); ++i)
         System.out.println(output.get(i));

   }

   private class Node
   {
      Node previous;
      Node next;
      Integer data;

      public Node(Integer value)
      {
         previous = null;
         next = null;
         data = value;
      }

      public boolean hasNext() { return (this.next != null); }
      public boolean hasPrevious() { return (this.previous != null); }
   }

   /**
    Unimplented methods of the List interface.
    */
   @Override
   public boolean contains(Object o) { return false; }
   @Override
   public Iterator<Integer> iterator() { return null; }
   @Override
   public Object[] toArray() { return new Object[0]; }
   @Override
   public <T> T[] toArray(T[] a) { return null; }
   @Override
   public boolean containsAll(Collection<?> c) { return false; }
   @Override
   public boolean addAll(Collection<? extends Integer> c) { return false; }
   @Override
   public boolean addAll(int index, Collection<? extends Integer> c) { return false; }
   @Override
   public boolean removeAll(Collection<?> c) { return false; }
   @Override
   public boolean retainAll(Collection<?> c) { return false; }
   @Override
   public int indexOf(Object o) { return 0; }
   @Override
   public int lastIndexOf(Object o) { return 0; }
   @Override
   public java.util.ListIterator<Integer> listIterator() { return null; }
   @Override
   public java.util.ListIterator<Integer> listIterator(int index) { return null; }
   @Override
   public List<Integer> subList(int fromIndex, int toIndex) { return null; }
   @Override
   public boolean remove(Object o) { return false; }
   @Override
   public boolean isEmpty() { return false; }
}
