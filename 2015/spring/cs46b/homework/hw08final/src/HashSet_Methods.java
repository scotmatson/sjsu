//FORBIDDEN java.util.Hash

/**
 * This class contains the methods for the 
 * HashSet class. The HashSet class should
 * be implemented as an hash table with a linked
 * list at each slot in the array.
 * 
 * This file is simply a container
 * for some static methods. You can write 
 * these as the same as if they were in the
 * class itself (using the given definitions).
 * 
 * You may not add instance variables to any classes
 * in this assignment. You may not use the data structures
 * in the jcf to complete this assignment.
 */
public class HashSet_Methods
{
	/**
	 * Add an item to the hash table. Data is the 
	 * hash table. NewData is the Object to add to 
	 * the table.
	 * @param NewData the object to add to the table
	 * @param Data the hash table
	 */
	public static void add(Object NewData, Node[] Data)
	{
        // Retrieve the HashCode
        int hashCode = HashSet_Methods.hashIndex(NewData, Data);
        // Set node to current hash index
        Node current = Data[hashCode];

        // If a Node does not currently exist at this location, initialize one.
        if (current == null) {
            Data[hashCode] = new Node(NewData, null);
            return;
        } else {
            // Shift the LinkedList to the tail node
            while (current.Next != null) {
                // Check for existence of current object
                if (current.Data.equals(Data)) {
                    return;
                }
                // Move to the end of our list
                current = current.Next;
            }
        }

        // Append the new object to the list
        Node NewNode = new Node(NewData, null);
        current.Next = NewNode;
    }
	
	/**
	 * Determine if the hash table in Data
	 * contains the Object SearchData.
	 * @param SearchData the item to be found
	 * @param Data the haystack to search
	 * @return int index where the item is found or -1 otherwise
	 */
	public static int contains(Object SearchData, Node[] Data)
	{
        // Retrieve the HashCode
        int hashCode = HashSet_Methods.hashIndex(SearchData, Data);
        // Set node to current hash index
        Node current = Data[hashCode];

        // Traverse the list
        while (current != null) {
            // Check each element for equality and return the index if a match is found
            if (current.Data.equals(SearchData)) {
                return hashCode;
            }
            current = current.Next;
        }
        return -1;
    }
	
	/**
	 * If the given item is in the hash table, then
	 * remove it.
	 * 
	 * @param RemoveData
	 * @param Data
	 */
	public static void remove(Object RemoveData, Node[] Data)
	{
        // Retrieve the HashCode
        int hashCode = HashSet_Methods.hashIndex(RemoveData, Data);
        // Set node to current hash index
        Node current = Data[hashCode];
        Node previous = null;

        // Check the first position

        // Check subsequent links
        while (current != null) {
            if (current.Data.equals(RemoveData)) {
                if (previous == null) { Data[hashCode] = current.Next; }
                else { previous.Next = current.Next; }
                return;
            }
            previous = current;
            current = current.Next;
        }
    }
	
	/**
	 * Calculate the load on the hash table. In this case, the load
	 * is the number of items in the hash table divided by the number
	 * of slots in the array. This count includes items in linked lists.
	 * 
	 * @param Data the array to search
	 * @return the calculated load
	 */
	public static double calculateLoad(Node[] Data)
	{
        double items = 0;

        for (Node current : Data) {
            if (current != null) {
                while (current != null) {
                    ++items;
                    current = current.Next;
                }
            }
        }
        return items / Data.length;
    }
	
	/**
	 * Create a new hash table that is twice the
	 * size of the old one. Reallocate all elements 
	 * TO NEW POSITIONS in the new hash table.
	 * 
	 * @param Data the hash table to reallocate
	 */
	public static Node[] resize(Node[] Data)
	{
        Node[] largeNode = new Node[Data.length * 2];
        for (int i = 0; i < Data.length; ++i) {

            Node current = Data[i];
            while (current != null) {
                HashSet_Methods.add(current.Data, largeNode);
                current = current.Next;
            }
        }
        return largeNode;
    }

    /**
     * Helper method, hashIndex
     * Calculates an Array index based upon a given
     * hash code and Node Array length
     *
     * @param data
     * @param node
     * @return the hash code Array index
     */
    private static int hashIndex(Object data, Node[] node) {

        // Retrieve the HashCode
        int hashCode = data.hashCode();
        // Ensure HashCode is a positive integer
        if (hashCode < 0) hashCode = -hashCode;
        // Mod the HashCode for Array assignment
        return hashCode % node.length;
    }
}