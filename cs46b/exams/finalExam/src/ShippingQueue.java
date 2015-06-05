//FORBIDDEN java.util

/**
 * ShippingQueue. This class is a priority queue. You can
 * think of a priority queue as an ArrayList that is always
 * sorted with the highest priority elements at the front.
 * Then whenever an element is removed, it is removed from
 * the front, and must have the highest remaining priority.
 * 
 * Implement the add, remove, resize, and sort methods. You
 * MUST implement merge sort in order to get full credit.
 * This will require a recursive helper method.
 * 
 * You may not add any additional instance variables to
 * this class. You may not use sorting methods from the jcf.
 * You may not use data structures from the jcf other
 * than the given array.
 * 
 * You may use System.arraycopy.
 * 
 * Code Check will reject any submission that uses
 * anything from the java dot util package.
 */
public class ShippingQueue
{
	private Package[] packages;
	private int count;
	private final static int INITIAL_SIZE = 5;
	
	/**
	 * Constructor. Initialize the packages array.
	 * Set count to 0.
	 */
	public ShippingQueue()
	{
		packages = new Package[INITIAL_SIZE];
		count = 0;
	}
	
	public Package get(int i)
	{
		if( i < 0 || i >= count ) throw new ArrayIndexOutOfBoundsException();
		
		return packages[i];
	}
	
	public int size()
	{
		return count;
	}
	
	/**
	 * add. Add a Package to the array. If the array
	 * isn't large enough to hold another package, then 
	 * resize the array. Also make sure to sort the
	 * array. This is a priority queue, so the packages
	 * with the highest priority number should come
	 * first.
	 * 
	 * @param p the package to add
	 */
	public void add(Package p)
	{
        if (count < packages.length) {
            packages[count] = p;
            ++count;

            // sorting the array should fix the order..
            // although this is costly to do to the whole array
        }
        else {
            // Double the size of the packages[] and recurse
            resize();
            add(p);
        }

	}
	
	/**
	 * resize. Resize the underlying array. Double the size
	 * of the array. Make sure to copy over all the material
	 * from the old array into the new array.
	 */
	public void resize()
	{
		Package[] dblPackages = new Package[packages.length * 2];
        System.arraycopy(packages, 0, dblPackages, 0, packages.length - 1);
        packages = dblPackages;
	}
	
	/**
	 * remove. Remove the Package at position zero and
	 * return it. This should be the package with the
	 * highest remaining priority.
	 * 
	 * @return the Package at position 0
	 */
	public Package remove()
	{
        if (packages[0] == null) return null;
        --count;
		Package first = packages[0];

//        packages[0] = null;
//        sort();

        return first;
	}

	/**
	 * sort. You MUST implement merge sort. This will
	 * require a recursive helper method. 
	 */
	public void sort()
	{
        recursiveMergeSort(packages);
	}

    public void recursiveMergeSort(Package[] packages)
    {
        if (packages.length <= 1) { return; }
        Package[] first = new Package[packages.length / 2];
        Package[] second = new Package[packages.length - first.length];

        for (int i = 0; i < first.length; ++i) {
            first[i] = packages[i];
        }
        for (int i = 0; i < second.length; ++i) {
            second[i] = packages[first.length + i];
        }

        recursiveMergeSort(first);
        recursiveMergeSort(second);

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length && iSecond < second.length) {

            // Need to handle the case when an item is removed and the element is null
//            if (first == null || second == null) continue;
            if (first[iFirst].getPriority() < second[iSecond].getPriority()) {
                packages[j] = first[iFirst];
                ++iFirst;
            }
            else {
                packages[j] = second[iSecond];
                ++iSecond;
            }
            ++j;
        }

        while (iFirst < first.length) {
            packages[j] = first[iFirst];
            ++iFirst;
            ++j;
        }
        while (iSecond < second.length) {
            packages[j] = second[iSecond];
            ++iSecond;
            ++j;
        }
    }
}
