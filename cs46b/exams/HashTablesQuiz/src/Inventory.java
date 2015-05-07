/**
 * Inventory
 * 
 * This class holds the inventory of a record
 * store implemented as a linear probing
 * hash table.
 * 
 * A linear probing hash table does not use
 * linked lists to resolve collisions.
 * 
 * A linear probing hash table attempts
 * to add the new item at the position 
 * indicated by the hashCode method. If
 * that slot is filled, then it looks at
 * the next slot in the array until it finds
 * a free slot. Then it adds the new item
 * in that free slot.
 * 
 * Example:
 * 1. data[,,,,,,,,,,]
 * 2. add(x)
 * 3. data[,,,,x,,,,,]
 * 4. add(y)
 * 5. If x and y collide, then y is added in the next free slot
 * 6. data[,,,,x,y,,,]
 * 7. add(z)
 * 8. If z does not collide, then it is added at the position indicated by its hash code
 * 9. data[,z,,,x,y,,,]
 *
 */
public class Inventory
{
	private Album[] albums;
	private static int INITIAL_SIZE = 23;
	private int count;
	// do not add more instance variables
	
	public Inventory()
	{
		this.albums = new Album[this.INITIAL_SIZE];
		this.count = 0;
	}
	
	/**
	 * addAlbum
	 * 
	 * Add an album to the inventory.
	 * 
	 * You must use linear probing
	 * to get any credit.
	 * 
	 * Remember, linear probing adds
	 * the item at the first free
	 * slot AFTER the hashCode.
	 * 
	 * If there is no free slot before the end
	 * of the array, then you should loop
	 * back to the beginning.
	 * 
	 * Don't worry about rehashing 
	 * or resizing the array.
	 * 
	 * DO NOT ALLOW DUPLICATE ALBUMS!
	 * 
	 * @param a the album to add
	 */
	public void addAlbum(Album a) {
        // If the album Array has not been filled
        if (this.size() <= albums.length && !this.contains(a)) {
            int hashIndex = a.hashCode() % albums.length;
            if (hashIndex < 0) hashIndex = -hashIndex;
            boolean inserted = false;
            // Starting from the hash index
            for (int i = hashIndex; i < albums.length; ++i) {
                if (albums[i] == null) {
                    albums[i] = a;
                    inserted = true;
                    ++count;
                    break;
                }
            }
            if (!inserted) {
                // Starting from the beginning
                for (int i = 0; i < hashIndex; ++i) {
                    if (albums[i] == null) {
                        ++count;
                        albums[i] = a;
                        inserted = true;
                        break;
                    }
                }
            }
        }
    }

    /**
	 * contains
	 * 
	 * Return true if an Album is in
	 * inventory or false otherwise.
	 * 
	 * You must use linear probing
	 * to get any credit.
	 * 
	 * Remember, linear probing adds
	 * the item at the first free
	 * slot AFTER the hashCode.
	 * 
	 * If there is no free slot before the end
	 * of the array, then you should loop
	 * back to the beginning.
	 * 
	 * 
	 * @param a the album to search for
	 * @return true if the album is in the hash table or false otherwise
	 */
	public boolean contains(Album a)
	{
		for (int i = 0; i < albums.length; ++i) {
            if (albums[i] != null) {
                if (a.getName().equals(albums[i].getName())) {
                    return true;
                }
            }
        }
        return false;
	}
	
	public int size() { return this.count; }
	public float getLoadFactor() { return ((float) count / (float) albums.length); }
}
