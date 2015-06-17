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

   public IndexedList(Integer integer)
   {
      clear();
      add(integer);
   }

   /**
    Returns the number of elements in this list.  If this list contains more than
    <tt>Integer.MAX_VALUE</tt> elements, returns <tt>Integer.MAX_VALUE</tt>.

    @return the number of elements in this list
    */
   @Override
   public int size()
   {
      return nodeCount;
   }

   /**
    Returns <tt>true</tt> if this list contains no elements.

    @return <tt>true</tt> if this list contains no elements
    */
   @Override
   public boolean isEmpty()
   {
      return (nodeCount == 0);
   }

   /**
    Returns <tt>true</tt> if this list contains the specified element. More
    formally, returns <tt>true</tt> if and only if this list contains at least
    one element <tt>e</tt> such that <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.

    @param o element whose presence in this list is to be tested
    @return <tt>true</tt> if this list contains the specified element
    @throws ClassCastException if the type of the specified element is
    incompatible with this list (<a href="Collection.html#optional-restrictions">optional</a>)
    @throws NullPointerException if the specified element is null and this list
    does not permit null elements (<a href="Collection.html#optional-restrictions">optional</a>)
    */
   @Override
   public boolean contains(Object o) { return false; }

   /**
    Returns an iterator over the elements in this list in proper sequence.

    @return an iterator over the elements in this list in proper sequence
    */
   @Override
   public Iterator<Integer> iterator()
   {
      return null;
   }

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
    @return <tt>true</tt> if this list contained the specified element
    @throws ClassCastException if the type of the specified element is
    incompatible with this list (<a href="Collection.html#optional-restrictions">optional</a>)
    @throws NullPointerException if the specified element is null and this list
    does not permit null elements (<a href="Collection.html#optional-restrictions">optional</a>)
    @throws UnsupportedOperationException if the <tt>remove</tt> operation is not
    supported by this list
    */
   @Override
   public boolean remove(Object o)
   {
      return false;
   }

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
    Removes all of the elements from this list (optional operation). The list
    will be empty after this call returns.

    @throws UnsupportedOperationException if the <tt>clear</tt> operation is not
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
      return null;
   }

   /**
    Replaces the element at the specified position in this list with the
    specified element (optional operation).

    @param index index of the element to replace
    @param element element to be stored at the specified position
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
   public Integer set(int index, Integer element)
   {
      return null;
   }

   /**
    Inserts the specified element at the specified position in this list
    (optional operation).  Shifts the element currently at that position (if any)
    and any subsequent elements to the right (adds one to their indices).

    @param index index at which the specified element is to be inserted
    @param element element to be inserted
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
   public void add(int index, Integer element)
   {

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
    Returns a list iterator over the elements in this list (in proper sequence).

    @return a list iterator over the elements in this list (in proper sequence)
    */
   @Override
   public ListIterator<Integer> listIterator()
   {
      return null;
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
      return null;
   }

   /**
    Unimplemented method.
    */
   @Override
   public List<Integer> subList(int fromIndex, int toIndex) { return null; }

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
}
