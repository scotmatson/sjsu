import java.util.Iterator;

/**
 * ShippingQueue. This class is a priority queue. You can
 * think of a priority queue as a list that is always
 * sorted with the highest priority elements at the front.
 * In the previous quiz, you implemented this class as
 * an array. In this quiz, your task is to implement
 * it as a linked list.
 *
 * Whenever an element is removed, it is removed from
 * the front, and must have the highest remaining priority.
 *
 * Implement the add, and remove methods. Then implement
 * the methods for the inner class that implements the
 * Iterator interface.
 *
 * You may not add any additional instance variables to
 * this class. You may not use sorting methods from the jcf.
 * You may not use data structures from the jcf other
 * than the given array.
 *
 * Code Check will reject any submission that uses
 * anything from java.util.
 */
public class ShippingQueue implements Iterable<Package>
{
	private Package first;
	private int count;

	/**
	 * Constructor.
	 * Set count to 0.
	 */
	public ShippingQueue()
	{
		first = null;
		count = 0;
	}

	public int size()
	{
		return count;
	}

	/**
	 * add. Add a Package to the queue. This is a
	 * priority queue, so the packages with the
	 * highest priority number should come first.
	 * When you add a Package, you must add it
	 * in sorted order.
	 *
	 * Don't forget to update the count variable
	 *
	 * @param p the package to add
	 */
	public void add(Package p)
	{
        ++count;
		if (first == null) {
            first = p;
        }
        else {
            Package previous = null;
            Package current = first;
            while (current != null && p.getPriority() <= current.getPriority()) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                p.next = first;
                first = p;
            }
            else {
                previous.next = p;
                p.next = current;
            }
        }
    }

	/**
	 * remove. Remove the Package at the first position and
	 * return it. This should be the package with the
	 * highest remaining priority.
	 *
	 * If first is null then return null.
	 *
	 * Don't forget to update the count variable
	 *
	 * @return the Package at position 0
	 */
	public Package remove()
	{
        Package cp = first;
        if (cp != null) {
            --count;
            first = first.next;
        }
        return cp;
	}

	/**
	 * ShippingIterator. This class implements the Iterator
	 * interface so that a calling program can iterate
	 * through everything in the shipping queue. You must
	 * complete the hasNext and next methods.
	 */
	class ShippingIterator implements Iterator<Package>
	{
		Package cursor;

		public ShippingIterator()
		{
			cursor = first;
		}

		/**
		 * Is there a next package?
		 */
		@Override
		public boolean hasNext()
		{
            return (cursor != null && cursor.next != null);
		}

		/**
		 * Move to the next Package and return it
		 */
		@Override
		public Package next()
		{
            Package current = cursor;
            cursor = cursor.next;
			return current;
		}

		// You do NOT need to implement the remove method
		@Override
		public void remove(){
			// YOU DO NOT NEED TO WRITE THIS
		}
	}

	@Override
	public Iterator<Package> iterator()
	{
		return new ShippingIterator();
	}
}