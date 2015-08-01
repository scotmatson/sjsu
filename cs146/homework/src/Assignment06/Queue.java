package Assignment06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 Created by scot on 7/26/15.
 */
public class Queue<E> implements Iterable<E>
{
   private Node<E> head;
   private Node<E> tail;
   private int length;

   public Queue()
   {
      head = null;
      tail = null;
      length = 0;
   }

   public boolean isEmpty()
   {
      return head == null;
   }

   public int getLength()
   {
      return length;
   }

   public void enqueue(E newData)
   {
      Node<E> oldTail = tail;
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

   public E dequeue()
   {
      if (isEmpty()) throw new NoSuchElementException("Queue Underflow.");
      E data = head.getData();
      head = head.getNext();
      --length;
      if (isEmpty()) tail = null;
      return data;
   }

   public Iterator<E> iterator()
   {
      return new ListIterator<>(head);
   }

   /**
    Private inner class,
      used to iterator through the queue.

    @param <L> Generic type.
    */
   private class ListIterator<L> implements Iterator<L>
   {
      private Node<L> current;

      public ListIterator(Node<L> head)
      {
         current = head;
      }

      public boolean hasNext()
      {
         return current != null;
      }

      public void remove()
      {
         throw new UnsupportedOperationException();
      }

      public L next()
      {
         if (!hasNext()) throw new NoSuchElementException();
         L data = current.data;
         current = current.getNext();
         return data;
      }
   } // End ListIterator inner class.

   /**
    Private inner class,
     creates nodes to be used with a queue.

    @param <N> Generic type.
    */
   private class Node<N>
   {
      private N data;
      private Node<N> next;

      private Node ()
      {
         data = null;
         next = null;
      }

      private Node(N newData)
      {
         this.data = newData;
         next = null;
      }

      private N getData()
      {
         return this.data;
      }

      private Node<N> getNext()
      {
         return this.next;
      }

      private void setNext(Node<N> node)
      {
         this.next = node;
      }
   } // End Node inner class.
}
