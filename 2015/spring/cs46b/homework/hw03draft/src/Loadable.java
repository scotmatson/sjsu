/**
 * Created by scot on 2/27/15.
 */
public interface Loadable
{
    /**
     * Saves the object to a file.
     *
     * @param filename the file to save to
     */
    public void saveToFile(String filename);

    /**
     * Loads an object from a file.
     *
     * @param filename the file to load from
     */
    public void loadFromFile(String filename);
}