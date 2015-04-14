public class Track
{
    private String artist;
    private String name;

    public Track(String artist, String name)
    {
        this.artist = artist;
        this.name = name;
    }

    public String getArtist(){ return artist; }
    public String getName(){ return name; }

    public void setArtist(String artist){ this.artist = artist; }
    public void setName(String name){ this.name = name; }

    @Override
    public String toString()
    {
        return artist + " - " + name;
    }
}