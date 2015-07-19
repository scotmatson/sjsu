/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Merge Sort algorithm which sorts using a Linked List.

 Solves CS147 Homework Assignment #05

 @author Scot Matson, Unknown
   Adapted from:
      http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/
 @version 1.00 2015/07/19
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
      // The base case.
      if (head == null || head.next == null)
      {
         return head;
      }

      // Count total number of elements
      int count = 0;
      Node p = head;
      while (p != null)
      {
         count++;
         p = p.next;
      }

      // Break up to two list
      int middle = count / 2;

      Node left = head;
      Node right = null;
      Node p2 = head;
      int countHalf = 0;

      while (p2 != null)
      {
         countHalf++;
         Node next = p2.next;

         if (countHalf == middle)
         {
            p2.next = null;
            right = next;
         }
            p2 = next;
      }

      // Now we have two parts l and r, recursively sort them
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
            p2 = p2.next;
            pNew = pNew.next;
         }
         else if (p2 == null)
         {
            pNew.next = new Node(p1.data);
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
               p1 = p1.next;
               pNew = pNew.next;
            }
            else if (p1.data.compareTo(p2.data) == 0)
            {
               Stats.incrementCompares();
               pNew.next = new Node(p1.data);
               pNew.next.next = new Node(p1.data);
               pNew = pNew.next.next;
               p1 = p1.next;
               p2 = p2.next;
            }
            else
            {
               Stats.incrementCompares();
               pNew.next = new Node(p2.data);
               p2 = p2.next;
               pNew = pNew.next;
            }
         }
      }
      return fakeHead.next;
   }
}