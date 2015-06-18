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

   public IndexedList()
   {
      clear();
   }

   @Override
   public int size() { return listSize; }
   @Override
   public boolean isEmpty() { return (listSize == 0); }

   @Override
   public boolean add(Integer integer)
   {
      Node newNode = new Node(integer);
      if (head == null)
      {
         head = tail = newNode;
      }
      else
      {
         newNode.previous = tail;
         tail.next = newNode;
         tail = tail.next;
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
         head = tail = newNode;
      }
      else
      {

      }

   }

   @Override
   public void clear()
   {
      head = null;
      tail = null;
      al = new ArrayList<>();
      listSize = 0;
      accessInterval = 10;
   }

   @Override
   public Integer get(int index)
   {
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
         System.out.println("Starting from: " + accessIndex);
         while (currentNode.hasNext() && step > 0)
         {
            currentNode = currentNode.next;
            --step;
         }
      }
      // DECREMENTING
      else {
         startPosition = ((index / accessInterval) + 1) * accessInterval;
         accessIndex = startPosition / accessInterval;
         step = startPosition - index;
         currentNode = al.get(accessIndex);
         System.out.println("Starting from: " + accessIndex);
         while (currentNode.hasPrevious() && step > 0)
         {
            currentNode = currentNode.previous;
            --step;
         }

      }

      //System.out.println("index: " + index);
      //System.out.println("start: " + startPosition);
      //System.out.println("access: " + accessIndex);
      //System.out.println("step: " + step);
      //System.out.println();

      return currentNode.data;
   }

   @Override
   public Integer set(int index, Integer element)
   {
      return null;
   }

   @Override
   public Integer remove(int index)
   {
      return null;
   }

   /**
    Generates indices throughout the LinkedList at the kth value
    */
   public void createIndexInterval()
   {
      if (listSize % accessInterval == 0)
         al.add(tail);
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
      {
         if ((i / accessInterval) == 0)
         {
            output.set(accessInterval * i, output.get(accessInterval*i) + " [" + al.get(i).data + "]");
         }
      }

      for (int i = 0; i < output.size(); ++i)
      {
         System.out.println(output.get(i));
      }
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

      public boolean hasNext()
      {
         return (this.next != null);
      }
      public boolean hasPrevious()
      {
         return (this.previous != null);
      }
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
}
