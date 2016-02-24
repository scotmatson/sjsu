import java.util.HashMap;

/**
 * This class encapsulates a basic music
 * library. It uses a HashMap to store
 * albums. The key into the HashMap 
 * is a String, the name of the album.
 * The vale is the Album object itself. 
 */
public class MusicLibrary
{
    HashMap<String, Album> library;

    /**
     * Constructor. Initialize the library
     * HashMap.
     */
    public MusicLibrary() { library = new HashMap<>(); }

    /**
     * addAlbum. Add an album to the HashMap.
     * @param a
     */
    public void addAlbum(Album a) { library.put(a.getName(), a); }

    /**
     * getAlbum. Return an Album from the HashMap
     * if it exists, or null otherwise.
     *
     * @param albumName the name of the album to return
     * @return an Album or null
     */
    public Album getAlbum(String albumName) { return library.get(albumName); }

    /**
     * removeAlbum. Remove an album from the
     * HashMap.
     *
     * @param albumName the album to remove
     */
    public void removeAlbum(String albumName) { library.remove(albumName); }

    /**
     * count. Return the size of the library.
     *
     * @return an int
     */
    public int count() { return library.size(); }
}
