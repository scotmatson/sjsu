/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Merge Sort algorithm which sorts using a Linked List.

 Solves CS147 Homework Assignment #05

 @author Scot Matson, Unknown
   Adapted from:
      http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/

 @version 2015/07/19
 */

package Assignment05;

public class MergeSortLinkedList implements Sortable
{
   /**
    Stores data and references other Nodes to create a Linked List.
    @param <AnyType>
    */
   private class Node<AnyType extends Comparable<? super AnyType>>
   {
      private AnyType data;
      private Node next;

      Node(AnyType data)
      {
         this.data = data;
         next = null;
      }
   }

   /**
    Initiates a Merge Sort by converting an Array into a Linked List which
    is given as an argument to a series of internal recursive methods.
    @param a an array of Comparable items.
    */
   @Override
   public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a)
   {
      // Convert the array into a linked list for sorting
      Node head = new Node(a[0]);
      Node current = head;
      for (int i = 1; i < a.length; ++i)
      {
         current.next = new Node(a[i]);
         current = current.next;
      }

      // Sort the linked list.
      Stats.startTime();
      mergesort(head);
      Stats.stopTime();

      // Since we aren't doing anything with the lists we'll let the garbage
      // collector handle them once the sorting algorithm has completed.
   }

   /**
    Breaks apart a linked list into smaller lists for sorting.
    @param head the head Node of a Linked List.
    */
   public Node mergesort(Node head)
   {
      // Base case.
      if (head == null || head.next == null)
      {
         return head;
      }

      /**
       The original source code looped through the list using a counter to find
       the halfway point and then used that counter to split the list.

       I modified this bit of code to traverse the list one time to
       generate two separate lists. A modulo counter is used to alternate
       the distribution.
       */
      // For traversing the list
      Node currentNode = head;
      // For assigning values

      // Pointer to the head of left and right for recursive calls.
      Node left, leftIterator;
      Node right, rightIterator;

      // Initialize the left
      left = leftIterator = new Node(currentNode.data);
      currentNode = currentNode.next;

      // Initialize the right
      right = rightIterator = new Node(currentNode.data);

      // Set counter to distribute future iterations evenly.
      int nodeCounter = 0;

      // Check if we have more
      while (currentNode.next != null)
      {
         // Advance the pointer
         currentNode = currentNode.next;
         if (nodeCounter % 2 == 0)
         {
            leftIterator.next = new Node(currentNode.data);
            leftIterator = leftIterator.next;
         }
         else
         {
            rightIterator.next = new Node(currentNode.data);
            rightIterator = rightIterator.next;
         }
         ++nodeCounter;
      }

      // Now we have two parts left and right, recursively sort them
      Node h1 = mergesort(left);
      Node h2 = mergesort(right);

      // Merge together
      return merge(h1, h2);
   }

   /**
    Merges together linked lists in sorted order.
    @param left a Node whose data is the lower bound of a set
    @param right a Node whose data is the upper bound of a set
    @return fakeHead the head of a constituent list.
    */
   public Node merge(Node left, Node right)
   {
      Node p1 = left;
      Node p2 = right;

      Node fakeHead = new Node(100);
      Node pNew = fakeHead;

      while (p1 != null || p2 != null)
      {
         if (p1 == null)
         {
            pNew.next = new Node(p2.data);
            Stats.incrementMoves();
            p2 = p2.next;
            pNew = pNew.next;
         }
         else if (p2 == null)
         {
            pNew.next = new Node(p1.data);
            Stats.incrementMoves();
            p1 = p1.next;
            pNew = pNew.next;
         }
         else
         {
            Stats.incrementCompares();
            if (p1.data.compareTo(p2.data) < 0)
            {
               // if(fakeHead)
               pNew.next = new Node(p1.data);
               Stats.incrementMoves();
               p1 = p1.next;
               pNew = pNew.next;
            }
            else if (p1.data.compareTo(p2.data) == 0)
            {
               Stats.incrementCompares();
               pNew.next = new Node(p1.data);
               Stats.incrementMoves();
               pNew.next.next = new Node(p1.data);
               Stats.incrementMoves();
               pNew = pNew.next.next;
               p1 = p1.next;
               p2 = p2.next;
            }
            else
            {
               Stats.incrementCompares();
               pNew.next = new Node(p2.data);
               Stats.incrementMoves();
               p2 = p2.next;
               pNew = pNew.next;
            }
         }
      }
      return fakeHead.next;
   }
}