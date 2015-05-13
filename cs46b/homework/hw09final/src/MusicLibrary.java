//FORBIDDEN java.util

/**
 * This class encapsulates a basic music
 * library. It uses a binary search tree to store
 * albums. It's like a TreeMap. The key into the tree
 * is a String, the name of the album. The value is
 * the actual album itself.
 * <p>
 * You must implement a binary search tree in order
 * to get any credit for this homework. You may not
 * use data structures from the jcf to complete this
 * class. You may not add additional instance variables
 * to this class.
 */
public class MusicLibrary {
    AlbumNode root;

    /**
     * Constructor.
     */
    public MusicLibrary() {
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
    public void addAlbum(AlbumNode newAlbum) {
        newAlbum.left = null;
        newAlbum.right = null;

        if (root == null) { root = newAlbum; }
        else {
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
    public void addNode(AlbumNode currentNode, AlbumNode newNode) {

        int comp = newNode.getName().compareTo(currentNode.getName());

        if (comp < 0) {
            if (currentNode.left == null) { currentNode.left = newNode; }
            else { addNode(currentNode.left, newNode); }
        }
        else if (comp > 0) {
            if (currentNode.right == null) { currentNode.right = newNode; }
            else { addNode(currentNode.right, newNode); }
        }
    }

    /**
     * getAlbum. Return an Album from the tree
     * if it exists, or null otherwise.
     * Use a recursive helper method.
     *
     * @param albumName the name of the album to return
     * @return an Album or null
     */
    public AlbumNode getAlbum(String albumName) {
        if (root == null) return null;
        AlbumNode rootNode = root;
        return recursiveGetAlbum(rootNode, albumName);
    }


    /**
     * Recursive helper method for the getAlbum method.
     * Returns an album from the tree if it exists, otherwise returns null
     *
     * @param currentNode pointer to the current node in the AlbumNode class
     * @param albumName   the name of the album to return
     * @return an Album or null
     */
    public AlbumNode recursiveGetAlbum(AlbumNode currentNode, String albumName) {
        if (currentNode == null) return null;

        int comp = albumName.compareTo(currentNode.getName());
        if (comp < 0) return recursiveGetAlbum(currentNode.left, albumName);
        if (comp > 0) return recursiveGetAlbum(currentNode.right, albumName);

        return currentNode;
    }

    /**
     * count. Return the size of the library. Use
     * a recursive helper method.
     *
     * @return an int
     */
    public int count() {
        AlbumNode rootNode = root;
        int nodeCount = 0;
        return recursiveCount(rootNode, nodeCount);
    }

    /**
     * Recursive helper method for the count method,
     * returns the number of nodes that exist in the library.
     *
     * @param currentNode pointer to the current node in the AlbumNode class.
     * @param nodeCount the current number of known nodes in the AlbumNode class.
     */
    public int recursiveCount(AlbumNode currentNode, int nodeCount) {
        if (currentNode == null) return nodeCount;

        ++nodeCount;
        nodeCount = recursiveCount(currentNode.left, nodeCount);
        nodeCount =  recursiveCount(currentNode.right, nodeCount);

        return nodeCount;
    }

    /**
     * printInOrder. Print the list of albums
     * in the MusicLibrary in order based on name.
     * Print each album on its own line.
     * Use a recursive helper method. Use the
     * toString method in the AlbumNode class
     * to print each album.
     */
    public void printInOrder() {
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
        if (currentNode == null) return;
        recursivePrintInOrder(currentNode.left);
        System.out.printf("%s\n", currentNode.toString());
        recursivePrintInOrder(currentNode.right);
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
     * Recursive helper method for the printInReverseOrder method.
     * Prints the albums from the AlbumNode class in reverse order.
     *
     * @param currentNode pointer to the current node in the AlbumNode.
     */
    public void recursivePrintInReverseOrder(AlbumNode currentNode) {
        if (currentNode == null) return;
        recursivePrintInReverseOrder(currentNode.right);
        System.out.printf("%s\n", currentNode.toString());
        recursivePrintInReverseOrder(currentNode.left);
    }
}
