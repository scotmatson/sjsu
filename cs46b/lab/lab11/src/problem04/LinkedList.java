package problem04;

import java.util.NoSuchElementException;

/**
 A linked list is a sequence of nodes with efficient
 element insertion and removal. This class
 contains a subset of the methods of the standard
 java.util.LinkedList class.
 */
public class LinkedList
{
    private Node first;
    private int currentSize;

    /**
     Constructs an empty linked list.
     */
    public LinkedList()
    {
        first = null;
    }

    /**
     Returns the first element in the linked list.
     @return the first element in the linked list
     */
    public Object getFirst()
    {
        if (first == null) { throw new NoSuchElementException(); }
        return first.data;
    }

    /**
     Removes the first element in the linked list.
     @return the removed element
     */
    public Object removeFirst()
    {
        if (first == null) { throw new NoSuchElementException(); }
        Object element = first.data;
        first = first.next;
        currentSize--;
        return element;
    }

    /**
     Adds an element to the front of the linked list.
     @param element the element to add
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
        currentSize++;
    }

    /**
     Returns an iterator for iterating through this list.
     @return an iterator for iterating through this list
     */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }

    public LinkedList unzip()
    {
        LinkedList ll = new LinkedList();
        Node node = first;
        if(node == null || node.next == null)
            return ll;
        ll.first = node.next;
        Node newNode = ll.first;
        node.next = node.next.next;
        node = node.next;

        while (node != null && node.next != null)
        {
            newNode.next = node.next;
            newNode = node.next;
            node.next = node.next.next;
            node = node.next;
        }

        if(newNode != null)
            newNode.next = null;
        return ll;
    }

    public int size1()
    {
        if(first == null) return 0;
        int s = 1;
        Node n = first;
        while (n.next != null)
        {
            s++;
            n = n.next;
        }
        return s;
    }

    public int size2()
    {
        return sizeHelper(first);
    }

    private int sizeHelper(Node n)
    {
        if(n == null) return 0;
        return 1 + sizeHelper(n.next);
    }

    public int size3()
    {
        return currentSize;
    }

    /**
      *  Shuffles the order of elements in a LinkedList retaining the position of the first element
      */
    public void perfectShuffle() {
        ListIterator list = this.listIterator();            // Full list
        ListIterator listShuffler = this.listIterator();    // Smaller half of the list
        int shufflerStart;                                  // Starting position of the shuffler
        boolean oddElements;                                // Cardinality of the size of the list

        // Set position of the shuffler by cardinality
        if (this.size3() % 2 == 0) {
            shufflerStart = this.size3() / 2;
            oddElements = false;
        }
        else {
            shufflerStart = this.size3() / 2 + 1;
            oddElements = true;
        }
        for (int i = 1; i <= shufflerStart; ++i) { listShuffler.next(); }

        // Use the shuffler variable to reposition values
        while (listShuffler.hasNext()) {
            list.next();
            list.add(listShuffler.next());
        }

        // Remove trailing duplicates
        if (oddElements) list.next();
        while (list.hasNext()) {
            list.next();
            list.remove();
        }
    }

    class Node
    {
        public Object data;
        public Node next;
    }

    class LinkedListIterator implements ListIterator
    {
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
         Constructs an iterator that points to the front
         of the linked list.
         */
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
         Moves the iterator past the next element.
         @return the traversed element
         */
        public Object next()
        {
            if (!hasNext()) { throw new NoSuchElementException(); }
            previous = position; // Remember for remove
            isAfterNext = true;

            if (position == null)
            {
                position = first;
            }
            else
            {
                position = position.next;
            }

            return position.data;
        }

        /**
         Tests if there is an element after the iterator position.
         @return true if there is an element after the iterator position
         */
        public boolean hasNext()
        {
            if (position == null)
            {
                return first != null;
            }
            else
            {
                return position.next != null;
            }
        }

        /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
         */
        public void add(Object element)
        {
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            currentSize++;
            isAfterNext = false;
        }

        /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
         */
        public void remove()
        {
            if (!isAfterNext) { throw new IllegalStateException(); }

            if (position == first)
            {
                removeFirst();
            }
            else
            {
                previous.next = position.next;
            }
            position = previous;
            currentSize--;
            isAfterNext = false;
        }

        /**
         Sets the last traversed element to a different value. 
         @param element the element to set
         */
        public void set(Object element)
        {
            if (!isAfterNext) { throw new IllegalStateException(); }
            position.data = element;
        }
    }
}