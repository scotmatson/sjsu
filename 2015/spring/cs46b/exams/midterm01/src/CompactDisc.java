/**
 *
 * CompactDisc.
 *
 * This class is a child class of Album. It represents
 * an album that comes as a CD.
 *
 * You must inherit Album, implement the constructor,
 * implement the Comparable interface, and override toString.
 *
 */
public class CompactDisc extends Album implements Comparable<CompactDisc>
{
    private int inventoryNumber;

    /**
     * Constructor.
     *
     * Initialize the super class instance. set
     * the inventoryNumber attribute.
     *
     * @param artist the album artist
     * @param title the album title
     * @param price the price of the CD
     * @param tracks the number of tracks
     * @param inventoryNumber the inventory identifier
     */
    public CompactDisc(String artist, String title, double price, int tracks, int inventoryNumber)
    {
        super(artist, title, price, tracks);
        this.inventoryNumber = inventoryNumber;
    }

    /**
     * Comparable.
     *
     * You must implement the Comparable interface
     * on objects of type CompactDisc. Compare
     * objects based on the artist, then on the
     * title. Compare each attribute alphabetically.
     *
     */
    @Override
    public int compareTo(CompactDisc otherCD) {
        if (this.getArtist().compareTo(otherCD.getArtist()) == 0) {
            return this.getTitle().compareTo(otherCD.getTitle());
        }
        else return this.getArtist().compareTo(otherCD.getArtist());
    }

    public int getInventoryNumber() {
        return this.inventoryNumber;
    }
    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }


    /**
     * toString.
     *
     * Return a String representation of this
     * instance.
     *
     * Example:
     * CompactDisc[artist=ARTIST, title=TITLE, inventoryNumber=INVENTORYNUMBER]
     */
    @Override
    public String toString() {
        return "CompactDisc[artist=" + getArtist() + ",  title=" +
                getTitle() + ", inventoryNumber=" + getInventoryNumber() + "]";
    }
}
