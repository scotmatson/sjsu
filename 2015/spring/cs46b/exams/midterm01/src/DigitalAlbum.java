import java.util.Comparator;

/**
 *
 * DigitalAlbum.
 *
 * This class is a child class of Album. It represents
 * an album that is delivered as a digital download.
 *
 * You must inherit Album, implement the constructor,
 * implement the Comparable interface, and override toString.
 *
 * For this class you must also implement the getTrackCountComparator
 * method, which returns an instance of a Comparator that
 * compares albums based on the number of tracks.
 *
 */
public class DigitalAlbum extends Album implements Comparable<DigitalAlbum>
{
    private String link;

    public String getLink()
    {
        return this.link;
    }

    /**
     * Constructor.
     *
     * Initialize the super class instance. set
     * the link attribute.
     *
     * @param artist the album artist
     * @param title the album title
     * @param price the price of the CD
     * @param tracks the number of tracks
     * @param link the download link
     */
    public DigitalAlbum(String artist, String title, double price, int tracks, String link)
    {
        super(artist, title, price, tracks);
        this.link = link;
    }

    /**
     * Comparable.
     *
     * You must implement the Comparable interface
     * on objects of type DigitalAlbum. Compare
     * objects based on the artist, then on the
     * title, then on link. Compare each attribute alphabetically.
     *
     */
    @Override
    public int compareTo(DigitalAlbum otherDA) {
        if (this.getArtist().compareTo(otherDA.getArtist()) == 0) {
            return this.getTitle().compareTo(otherDA.getTitle());
        }
        else return this.getArtist().compareTo(otherDA.getArtist());
    }

    /**
     * toString.
     *
     * Return a String representation of this
     * instance.
     *
     * Example:
     * DigitalAlbum[artist=ARTIST, title=TITLE, link=LINK]
     */
    @Override
    public String toString() {
        return "DigitalAlbum[artist=" + getArtist() + ", title=" + getTitle() + ", link=" + getLink() + "]";
    }

    /**
     * getTrackCountComparator.
     *
     * You must create an inner class that implements
     * Comparator on DigitalAlbum, then return
     * an instance of that class.
     *
     * You must compare albums based on the number
     * of tracks. The album with more tracks should
     * come first.
     *
     * @return
     */
    public Comparator<DigitalAlbum> getTrackCountComparator()
    {
        class TrackCompare implements Comparator<DigitalAlbum> {

            @Override
            public int compare(DigitalAlbum o1, DigitalAlbum o2) {
                return (o1.getTrackCount() >= o2.getTrackCount()) ? 1 : -1;
            }
        }

        return new TrackCompare();
    }

    /**
     * Mica code Snippet
     */
//    public class trackCountComparator implements Comparator<DigitalAlbum>
//    {
//        public int compare(DigitalAlbum first, DigitalAlbum second){
//            return - Integer.compare(first.getTrackCount(), second.getTrackCount());
//        }
//    }




}
