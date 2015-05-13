//FORBIDDEN java.util

/**
 * This class encapsulates a basic music
 * library. It uses a binary search tree to store
 * albums. It's like a TreeMap. The key into the tree 
 * is a String, the name of the album. The value is
 * the actual album itself.
 * 
 * You must implement a binary search tree in order
 * to get any credit for this homework. You may not 
 * use data structures from the jcf to complete this
 * class. You may not add additional instance variables
 * to this class. 
 */
public class MusicLibrary
{
	AlbumNode root;

	/**
	 * Constructor.
	 */
	public MusicLibrary()
	{
		root = null;
	}
	
	/**
	 * addAlbum. Add an album to the tree.
	 * Use a recursive helper method. The albums
	 * in the tree should be ordered based on
	 * the name of the album, NOT the artist.
	 * 
	 * @param newAlbum the AlbumNode to add
	 */
	public void addAlbum(AlbumNode newAlbum)
	{
        // Initialize the child branches of newAlbumNode.
        newAlbum.left = null;
        newAlbum.right = null;

        // If the root node is null, assign the newAlbumNode object to be root.
        if (root == null) { root = newAlbum; }
        // Otherwise we must traverse the tree and add this album in sorted order
        else {
            // Reference the root node to pass into our recursive method along with the new node
            AlbumNode rootNode = root;
            addNode(rootNode, newAlbum);
        }
	}

    /**
     * Recursive helper method for adding
     * new AlbumNodes to a MusicLibrary tree.
     *
     * @param newNode the AlbumNode to add
     */
    public void addNode(AlbumNode currentNode, AlbumNode newNode)
    {
        // First make a comparison to evaluate which child (left or right) the new node will be assigned
        int comp = currentNode.getName().compareTo(newNode.getName());

        // comp < 0 assigns to the left node
        if (comp < 0) {

            // If null, assign newNode to the left node
            if (currentNode.left == null) { currentNode.left = newNode; }

            // Otherwise advance our currentNode into the left branch and recurse
            else { addNode(currentNode.left, newNode); }
        }
        // comp > 0 assigns to the right node
        else if (comp > 0) {

            // If null, assign newNode to the right node
            if (currentNode.right == null) { currentNode.right = newNode; }

            // Otherwise, advance our currentNode into the right branch and recurse
            else { addNode(currentNode.right, newNode); }
        }
        // Otherwise this node already exists and we do nothing
    }
	
	/**
	 * getAlbum. Return an Album from the tree
	 * if it exists, or null otherwise.
	 * Use a recursive helper method.
	 * 
	 * @param albumName the name of the album to return
	 * @return an Album or null
	 */
	public AlbumNode getAlbum(String albumName)
	{
        return null;
	}
	
	/**
	 * count. Return the size of the library. Use
	 * a recursive helper method.
	 * 
	 * @return an int
	 */
	public int count()
	{
		return -1;
	}
	
	/**
	 * printInOrder. Print the list of albums
	 * in the MusicLibrary in order based on name.
	 * Print each album on its own line.
	 * Use a recursive helper method. Use the
	 * toString method in the AlbumNode class
	 * to print each album.
	 */
	public void printInOrder()
	{
        if (root != null) {
            AlbumNode rootNode = root;
            recursivePrintInOrder(rootNode);
        }
	}

    /**
     * Recursive helper method for the printInOrder method.
     * Prints each album from the AlbumNode class.
     *
     * @param currentNode pointer to the current node in the AlbumNode
     */
    public void recursivePrintInOrder(AlbumNode currentNode) {
        // If print proceeds the recursive methods, output will be in reverse order
        System.out.printf("%s\n", currentNode.toString());

        // Traverse through the elements of the tree
        if (currentNode.left != null) { recursivePrintInOrder(currentNode.left); }
        if (currentNode.right != null) { recursivePrintInOrder(currentNode.right); }
    }

	/**
	 * printInReverseOrder. Print the list of albums
	 * in the MusicLibrary in reverse order based on name.
	 * Use a recursive helper method.
	 */
	public void printInReverseOrder() {
        if (root != null) {
            AlbumNode rootNode = root;
            recursivePrintInReverseOrder(rootNode);
        }
    }

    /**
     *  Recursive helper method for the printInReverseOrder method.
     *  Prints the albums from the AlbumNode class in reverse order.
     *
     * @param currentNode pointer to the current node in the AlbumNode.
     */
    public void recursivePrintInReverseOrder(AlbumNode currentNode)
    {   // Traverse through the elements of the tree
        if (currentNode.left != null) { recursivePrintInReverseOrder(currentNode.left); }
        if (currentNode.right != null) { recursivePrintInReverseOrder(currentNode.right); }

        // If print follows the recursive methods, output will be in reverse order
        System.out.printf("%s\n", currentNode.toString());
    }
}
