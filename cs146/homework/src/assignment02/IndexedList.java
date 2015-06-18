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





      return null;
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
   public int getAccessIndex(int index)
   {
      return (index % accessInterval < 5) ?
          (index - (index % accessInterval)) :
         ((index / accessInterval) + 1) * accessInterval;

   }

   public void printList()
   {
      Node currentNode = head;
      System.out.printf("Values of IndexedList... \n");
      while (currentNode.hasNext())
      {
         System.out.printf("%d ", currentNode.data);
         currentNode = currentNode.next;
      }
      System.out.printf("%d\n\n", currentNode.data);
   }

   public void printAccessList()
   {
      System.out.println("Values of AccessList");
      for (int i = 0; i < al.size(); ++i)
      {
         System.out.printf("[%d] %d", i, al.get(i).data);
      }
      System.out.println("\n");
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
