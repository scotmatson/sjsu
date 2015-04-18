import java.util.ArrayList;

public class Album
{
    private String artist;
    private String name;

    private ArrayList<Track> tracks;

    public Album(String artist, String name)
    {
        this.artist = artist;
        this.name = name;

        tracks = new ArrayList<Track>();
    }

    public String getArtist(){ return artist; }
    public String getName(){ return name; }

    public void setArtist(String artist){ this.artist = artist; }
    public void setName(String name){ this.name = name; }

    public void addTrack(Track t) { tracks.add(t); }
    public Track getTrackAt(int index) { return tracks.get(index); }

    /**
     * Use selection sort to sort the tracks
     * by name. Return a new, sorted ArrayList
     * of tracks.
     *
     * @return an ArrayList containing the tracks sorted by name, or null if no tracks exist
     */
    public ArrayList<Track> getTracksSortedByName()
    {
        ArrayList sortedTracks = new ArrayList<>();

        if (tracks.size() == 0) { return null; }
        if (tracks.size() == 1) { return tracks; }
        else {
            for (int i = 0; i < tracks.size() - 1; i++) {
                int min = i;
                for (int j = i + 1; j < tracks.size(); j++) {
                    if (tracks.get(j).getName().compareTo(tracks.get(min).getName()) < 0) {
                        min = j;
                    }
                }
                if (min != i) {
                    Track temp = tracks.get(min);
                    tracks.set(min, tracks.get(i));
                    tracks.set(i, temp);
                }
            }
        }

        return tracks;
    }

    /**
     * Use binary search to find a track
     * in the ArrayList. You must add and
     * use a recursive helper method to
     * properly implement binary search.
     *
     * @param name the track name for which to search
     * @return the Track if found or null otherwise
     */
    public Track findTrack(String name)
    {

        return binarySearchTrack(tracks, 0, tracks.size()-1, name);
    }

    private static Track binarySearchTrack(ArrayList<Track> t, int low, int high, String trackName) {
        // Partial code borrowed from Cai Horstmann's Big Java
        if (low <= high) {
            int mid = (low + high) / 2;

            if (t.get(mid).getName().compareTo(trackName) == 0) {
                return t.get(mid);
            }
            else if (t.get(mid).getName().compareTo(trackName) < 0) {
                return binarySearchTrack(t, mid + 1, high, trackName);
            }
            else {
                return binarySearchTrack(t, low, mid - 1, trackName);
            }
        }
        else {
            return null;
        }
    }
}
