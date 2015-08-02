/**

 */
package Assignment06;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T>
{
   private Node<T> head;
   private Node<T> tail;
   private int length;

   public Queue()
   {
      head = null;
      tail = null;
      length = 0;
   }

   public Queue(List<T> l)
   {
      head = null;
      tail = null;
      length = 0;
      populateQueue(l);
   }

   private void populateQueue(List<T> l)
   {
      for (T t: l)
      {
         enqueue(t);
      }
   }

   public boolean isEmpty()
   {
      return head == null;
   }

   public int getLength()
   {
      return length;
   }

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

   public T dequeue()
   {
      if (isEmpty()) throw new NoSuchElementException("Queue Underflow.");
      T data = head.getData();
      head = head.getNext();
      --length;
      if (isEmpty()) tail = null;
      return data;
   }

   public Iterator<T> iterator()
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
         L data = current.getData();
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
