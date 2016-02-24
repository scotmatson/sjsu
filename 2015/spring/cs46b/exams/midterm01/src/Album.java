/**
 *
 * Album.
 *
 * This abstract class holds the basic information
 * for an album of music.
 *
 */
public abstract class Album
{
    private String title;
    private String artist;
    private String[] tracks;

    private double price;

    public Album(String artist, String title, double price, int tracks)
    {
        this.artist = artist;
        this.title = title;
        this.price = price;
        this.tracks = new String[tracks];
    }

    public String getTitle() { return this.title; }
    public String getArtist() { return this.artist; }
    public double getPrice() { return this.price; }
    public int getTrackCount() { return tracks.length; }

    public String getTrack(int trackNumber)
    {
        if( trackNumber >= 0 && trackNumber < tracks.length )
        {
            return tracks[trackNumber];
        }
        return "";
    }

    public void setTrack(int trackNumber, String name)
    {
        if( trackNumber >= 0 && trackNumber < tracks.length )
        {
            tracks[trackNumber] = name;
        }
    }

    @Override
    public String toString()
    {
        return "Album[artist=" + this.artist + ", title=" + this.title + "]";
    }
}