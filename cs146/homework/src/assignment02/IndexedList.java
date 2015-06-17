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

public class IndexedList implements List<Integer>
{
   Node head;       // Sentient node before the first item.
   Node tail;       // Sentient node after the last node.
   List<Node> k;    // Pointer to the kth node.
   int nodeCount;   // Number of elements in the list.

   /**
    Constructor Method. Initilizes new instance of an IndexedList
      by invoking the clear() method.
    */
   public IndexedList()
   {
      clear();
   }

   /**
    Constructor method. Initializes new instance of an IndexedList by
      invoking the clear() method and adding a new data node.

    @param integer an integer value.
    */
   public IndexedList(Integer integer)
   {
      clear();
      add(integer);
   }

   /**
    Returns the number of elements in this list.

    @return the number of elements in this list.
    */
   @Override
   public int size()
   {
      return nodeCount;
   }

   /**
    Returns true if this list contains no elements.

    @return true if this list contains no elements
    */
   @Override
   public boolean isEmpty()
   {
      return (nodeCount == 0);
   }



   /**
    Returns an iterator over the elements in this list in proper sequence.

    @return an iterator over the elements in this list in proper sequence
    */
   @Override
   public Iterator<Integer> iterator() { return new IndexedListIterator(); }

   /**
    Appends the specified element to the end of this list (optional operation).

    <p>Lists that support this operation may place limitations on what elements
    may be added to this list.  In particular, some lists will refuse to add null
    elements, and others will impose restrictions on the type of elements that
    may be added.  List classes should clearly specify in their documentation any
    restrictions on what elements may be added.

    @param integer element to be appended to this list
    @return <tt>true</tt> (as specified by {@link Collection#add})
    @throws UnsupportedOperationException if the <tt>add</tt> operation is not
    supported by this list
    @throws ClassCastException if the class of the specified element prevents it
    from being added to this list
    @throws NullPointerException if the specified element is null and this list
    does not permit null elements
    @throws IllegalArgumentException if some property of this element prevents it
    from being added to this list
    */
   @Override
   public boolean add(Integer integer)
   {
      Node currentNode = new Node(integer);

      // Add a new Node
      // If no node currently exists
      if (nodeCount == 0)
      {
         k.add(currentNode); // Reference to the first node... probably don't really need this.
         ++nodeCount;
         return true;
      }
      else
      {
         // We already have nodes present.
      }
      // Increment our counter
      // set our kth pointer for every nth nodes
      System.out.println(head.next.data);
      return false;
   }

   /**
    Removes the first occurrence of the specified element from this list, if it
    is present (optional operation).  If this list does not contain the element,
    it is unchanged.  More formally, removes the element with the lowest index
    <tt>i</tt> such that <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
    (if such an element exists).  Returns <tt>true</tt> if this list contained
    the specified element (or equivalently, if this list changed as a result of
    the call).

    @param o element to be removed from this list, if present
    @return true if this list contained the specified element
    @throws ClassCastException if the type of the specified element is
    incompatible with this list (<a href="Collection.html#optional-restrictions">optional</a>)
    @throws NullPointerException if the specified element is null and this list
    does not permit null elements (<a href="Collection.html#optional-restrictions">optional</a>)
    */
   @Override
   public boolean remove(Object o)
   {
      return false;
   }

   /**
    Removes all of the elements from this list (optional operation). The list
    will be empty after this call returns.

    @throws UnsupportedOperationException if the clear operation is not
    supported by this list
    */
   @Override
   public void clear()
   {
      head = new Node(null);
      tail = new Node(null);
      head.next = tail;
      tail.prev = head;
      k = new ArrayList<>();
      nodeCount = 0;
   }

   /**
    Returns the element at the specified position in this list.

    @param index index of the element to return
    @return the element at the specified position in this list
    @throws IndexOutOfBoundsException if the index is out of range (<tt>index
    &lt; 0 || index &gt;= size()</tt>)
    */
   @Override
   public Integer get(int index)
   {
      // Evaluate the position in relation to our ArrayList
      return null;
   }

   /**
    Replaces the element at the specified position in this list with the
    specified element (optional operation).

    @param index index of the element to replace
    @param integer element to be stored at the specified position
    @return the element previously at the specified position
    @throws UnsupportedOperationException if the <tt>set</tt> operation is not
    supported by this list
    @throws ClassCastException if the class of the specified element prevents it
    from being added to this list
    @throws NullPointerException if the specified element is null and this list
    does not permit null elements
    @throws IllegalArgumentException if some property of the specified element
    prevents it from being added to this list
    @throws IndexOutOfBoundsException if the index is out of range (<tt>index
    &lt; 0 || index &gt;= size()</tt>)
    */
   @Override
   public Integer set(int index, Integer integer)
   {
      if (index > nodeCount-1) { throw new IndexOutOfBoundsException("The assigned index does not exist."); }
      if (integer == null) { throw new NullPointerException("The assigned value must first be intialized."); }
      else
      {
         Node currentNode = new Node(integer);
      }
      return null;
   }

   /**
    Inserts the specified element at the specified position in this list
    (optional operation).  Shifts the element currently at that position (if any)
    and any subsequent elements to the right (adds one to their indices).

    @param index index at which the specified element is to be inserted
    @param integer element to be inserted
    @throws UnsupportedOperationException if the <tt>add</tt> operation is not
    supported by this list
    @throws ClassCastException if the class of the specified element prevents it
    from being added to this list
    @throws NullPointerException if the specified element is null and this list
    does not permit null elements
    @throws IllegalArgumentException if some property of the specified element
    prevents it from being added to this list
    @throws IndexOutOfBoundsException if the index is out of range (<tt>index
    &lt; 0 || index &gt; size()</tt>)
    */
   @Override
   public void add(int index, Integer integer)
   {
      Node currentNode = new Node(integer);
      // Go to the specified location, make some room, add the value.
   }

   /**
    Removes the element at the specified position in this list (optional
    operation).  Shifts any subsequent elements to the left (subtracts one from
    their indices).  Returns the element that was removed from the list.

    @param index the index of the element to be removed
    @return the element previously at the specified position
    @throws UnsupportedOperationException if the <tt>remove</tt> operation is not
    supported by this list
    @throws IndexOutOfBoundsException if the index is out of range (<tt>index
    &lt; 0 || index &gt;= size()</tt>)
    */
   @Override
   public Integer remove(int index)
   {
      return null;
   }

   /**
    Returns a list iterator over the elements in this list (in proper sequence).

    @return a list iterator over the elements in this list (in proper sequence)
    */
   @Override
   public ListIterator<Integer> listIterator()
   {
      return new IndexedListIterator();
   }

   /**
    Returns a list iterator over the elements in this list (in proper sequence),
    starting at the specified position in the list. The specified index indicates
    the first element that would be returned by an initial call to {@link
   ListIterator#next next}. An initial call to {@link ListIterator#previous
   previous} would return the element with the specified index minus one.

    @param index index of the first element to be returned from the list iterator
    (by a call to {@link ListIterator#next next})
    @return a list iterator over the elements in this list (in proper sequence),
    starting at the specified position in the list
    @throws IndexOutOfBoundsException if the index is out of range ({@code index
    < 0 || index > size()})
    */
   @Override
   public ListIterator<Integer> listIterator(int index)
   {
      return new IndexedListIterator();
   }

   private class Node
   {
      Node prev;
      Node next;
      Integer data;

      public Node(Integer dataValue)
      {
         prev = null;
         next = null;
         this.data = dataValue;
      }

      public Node getPrev() { return prev; }
      public void setPrev(Node prev) { this.prev = prev; }
      public Node getNext() { return next; }
      public void setNext(Node next) { this.next = next; }
      public Integer getData() { return data; }
      public void setData(Integer data) { this.data = data; }
   }

   private class IndexedListIterator implements ListIterator
   {
      private Node cursor;

      public IndexedListIterator() { cursor = head; }

      /**
       Returns {@code true} if this list iterator has more elements when traversing
       the list in the forward direction. (In other words, returns {@code true} if
       {@link #next} would return an element rather than throwing an exception.)

       @return {@code true} if the list iterator has more elements when traversing
       the list in the forward direction
       */
      @Override
      public boolean hasNext()
      {
         return (cursor.next != null);
      }

      /**
       Returns the next element in the list and advances the cursor position. This
       method may be called repeatedly to iterate through the list, or intermixed
       with calls to {@link #previous} to go back and forth. (Note that alternating
       calls to {@code next} and {@code previous} will return the same element
       repeatedly.)

       @return the next element in the list
       @throws NoSuchElementException if the iteration has no next element
       */
      @Override
      public Node next()
      {
         if (!hasNext())
         {
            throw new NoSuchElementException("There are no nodes assigned to that position.");
         }
         return cursor.next;
      }

      /**
       Returns {@code true} if this list iterator has more elements when traversing
       the list in the reverse direction.  (In other words, returns {@code true} if
       {@link #previous} would return an element rather than throwing an
       exception.)

       @return {@code true} if the list iterator has more elements when traversing
       the list in the reverse direction
       */
      @Override
      public boolean hasPrevious()
      {
         return (cursor.prev != null);
      }

      /**
       Returns the previous element in the list and moves the cursor position
       backwards.  This method may be called repeatedly to iterate through the list
       backwards, or intermixed with calls to {@link #next} to go back and forth.
       (Note that alternating calls to {@code next} and {@code previous} will return
       the same element repeatedly.)

       @return the previous element in the list
       @throws NoSuchElementException if the iteration has no previous element
       */
      @Override
      public Node previous()
      {
         if (!hasPrevious())
         {
            throw new NoSuchElementException("There are no nodes assigned to that position.");
         }
         return cursor.prev;
      }

      /**
       Returns the index of the element that would be returned by a subsequent call
       to {@link #next}. (Returns list size if the list iterator is at the end of
       the list.)

       @return the index of the element that would be returned by a subsequent call
       to {@code next}, or list size if the list iterator is at the end of the list
       */
      @Override
      public int nextIndex()
      {
         return 0;
      }

      /**
       Returns the index of the element that would be returned by a subsequent call
       to {@link #previous}. (Returns -1 if the list iterator is at the beginning of
       the list.)

       @return the index of the element that would be returned by a subsequent call
       to {@code previous}, or -1 if the list iterator is at the beginning of the
       list
       */
      @Override
      public int previousIndex()
      {
         return 0;
      }

      /**
       Removes from the list the last element that was returned by {@link #next} or
       {@link #previous} (optional operation).  This call can only be made once per
       call to {@code next} or {@code previous}. It can be made only if {@link #add}
       has not been called after the last call to {@code next} or {@code previous}.

       @throws UnsupportedOperationException if the {@code remove} operation is not
       supported by this list iterator
       @throws IllegalStateException if neither {@code next} nor {@code previous}
       have been called, or {@code remove} or {@code add} have been called after the
       last call to {@code next} or {@code previous}
       */
      @Override
      public void remove()
      {

      }

      /**
       Replaces the last element returned by {@link #next} or {@link #previous} with
       the specified element (optional operation). This call can be made only if
       neither {@link #remove} nor {@link #add} have been called after the last call
       to {@code next} or {@code previous}.

       @param o the element with which to replace the last element returned by
       {@code next} or {@code previous}
       @throws UnsupportedOperationException if the {@code set} operation is not
       supported by this list iterator
       @throws ClassCastException if the class of the specified element prevents it
       from being added to this list
       @throws IllegalArgumentException if some aspect of the specified element
       prevents it from being added to this list
       @throws IllegalStateException if neither {@code next} nor {@code previous}
       have been called, or {@code remove} or {@code add} have been called after the
       last call to {@code next} or {@code previous}
       */
      @Override
      public void set(Object o)
      {

      }

      /**
       Inserts the specified element into the list (optional operation). The element
       is inserted immediately before the element that would be returned by {@link
      #next}, if any, and after the element that would be returned by {@link
      #previous}, if any.  (If the list contains no elements, the new element
       becomes the sole element on the list.)  The new element is inserted before
       the implicit cursor: a subsequent call to {@code next} would be unaffected,
       and a subsequent call to {@code previous} would return the new element. (This
       call increases by one the value that would be returned by a call to {@code
      nextIndex} or {@code previousIndex}.)

       @param o the element to insert
       @throws UnsupportedOperationException if the {@code add} method is not
       supported by this list iterator
       @throws ClassCastException if the class of the specified element prevents it
       from being added to this list
       @throws IllegalArgumentException if some aspect of this element prevents it
       from being added to this list
       */
      @Override
      public void add(Object o)
      {

      }
   }

   /**
    Unimplemented method.
    */
   @Override
   public boolean contains(Object o) { return false; }

   /**
    Unimplemented method.
    */
   @Override
   public Object[] toArray() { return new Object[0]; }

   /**
    Unimplemented method
    */
   @Override
   public <T> T[] toArray(T[] a) { return null; }

   /**
    Unimplemented method.
    */
   @Override
   public boolean containsAll(Collection<?> c) { return false; }

   /**
    Unimplemented method.
    */
   @Override
   public boolean addAll(Collection<? extends Integer> c) { return false; }

   /**
    Unimplemented method.
    */
   @Override
   public boolean addAll(int index, Collection<? extends Integer> c) { return false; }

   /**
    Unimplemented method.
    */
   @Override
   public boolean removeAll(Collection<?> c) { return false; }

   /**
    Unimplemented method.
    */
   @Override
   public boolean retainAll(Collection<?> c) { return false; }

   /**
    Unimplemented method.
    */
   @Override
   public int indexOf(Object o) { return 0; }

   /**
    Unimplented method.
    */
   @Override
   public int lastIndexOf(Object o) {  return 0; }

   /**
    Unimplemented method.
    */
   @Override
   public List<Integer> subList(int fromIndex, int toIndex) { return null; }
}
