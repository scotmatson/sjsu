/**
 Generic non-priority queue.
 Implementation used to assist in maintaining FIFO
 order of associated graphing algorithms.

 Solution for CS146 Assignment #06

 @author Scot Matson

 @version 08/01/2015
 */
package assignment06;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T>
{
   private Node<T> head;
   private Node<T> tail;
   private int length;

   /**
    Constructor method.
    */
   public Queue()
   {
      head = null;
      tail = null;
      length = 0;
   }

   /**
    Constructor method.
    @param l a generic list.
    */
   public Queue(List<T> l)
   {
      head = null;
      tail = null;
      length = 0;
      populateQueue(l);
   }

   /**
    Populates a queue with data from a list.
    @param l a generic list.
    */
   private void populateQueue(List<T> l)
   {
      for (T t: l)
         enqueue(t);
   }

   /**
    Checks if a queue is empty.
    @return true is the queue is empty, otherwise false.
    */
   public boolean isEmpty()
   {
      return head == null;
   }

   /**
    The number of items in the queue.
    @return the queue length.
    */
   public int getLength()
   {
      return length;
   }

   /**
    Adds a new data Node to the back of the queue.
    @param newData the data to enqueue.
    */
   public void enqueue(T newData)
   {
      Node<T> oldTail = tail;
      tail = new Node<>(newData);
      if (isEmpty())
      {
         head = tail;
      }
      else
      {
         oldTail.setNext(tail);
      }
      ++length;
   }

   /**
    Removes a stored data Node from the front of the queue.
    @return the stored data.
    */
   public T dequeue()
   {
      if (isEmpty()) throw new NoSuchElementException("Queue Underflow.");
      T data = head.getData();
      head = head.getNext();
      --length;
      if (isEmpty()) tail = null;
      return data;
   }

   /**
    A queue Iterator.
    @return the Iterator.
    */
   public Iterator<T> iterator()
   {
      return new ListIterator<>(head);
   }

   /**
    Private inner class used to iterator through the queue.
    @param <L> Generic type.
    */
   private class ListIterator<L> implements Iterator<L>
   {
      private Node<L> current;

      /**
       Constructor method.
       @param head the front of the queue.
       */
      public ListIterator(Node<L> head)
      {
         current = head;
      }

      /**
       Checks for the existance of the next data Node in
       the queue.
       @return true if another Node exists, otherwise false.
       */
      public boolean hasNext()
      {
         return current != null;
      }


      public void remove()
      {
         throw new UnsupportedOperationException();
      }

      /**
       Gets the next data Node in the queue.
       @return the data stored in the next Node.
       */
      public L next()
      {
         if (!hasNext()) throw new NoSuchElementException();
         L data = current.getData();
         current = current.getNext();
         return data;
      }
   }

   /**
    Private inner class, creates nodes to be used with a queue.
    @param <N> Generic type.
    */
   private class Node<N>
   {
      private N data;
      private Node<N> next;

      /**
       Constructor method.
       @param newData
       */
      private Node(N newData)
      {
         this.data = newData;
         next = null;
      }

      /**
       Gets the data stored within a Node.
       @return the stored data.
       */
      private N getData()
      {
         return this.data;
      }

      /**
       Gets the next Node from the current Node.
       @return the next Node.
       */
      private Node<N> getNext()
      {
         return this.next;
      }

      /**
       Assigns the next Node from the current Node.
       @param node a Node.
       */
      private void setNext(Node<N> node)
      {
         this.next = node;
      }
   }
}
