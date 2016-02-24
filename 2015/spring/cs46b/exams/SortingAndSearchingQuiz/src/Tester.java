import java.util.ArrayList;

public class Tester
{
    public static void main(String[] args)
    {
        Album a = new Album("Radiohead", "Kid A");
        a.addTrack(new Track("Radiohead", "Everything in Its Right Place"));
        a.addTrack(new Track("Radiohead", "Kid A"));
        a.addTrack(new Track("Radiohead", "The National Anthem"));
        a.addTrack(new Track("Radiohead", "How to Disappear Completely"));
        a.addTrack(new Track("Radiohead", "Treefingers"));
        a.addTrack(new Track("Radiohead", "Optimistic"));
        a.addTrack(new Track("Radiohead", "In Limbo"));
        a.addTrack(new Track("Radiohead", "Idioteque"));
        a.addTrack(new Track("Radiohead", "Morning Bell"));
        a.addTrack(new Track("Radiohead", "Motion Picture Soundtrack"));

        ArrayList<Track> sorted = a.getTracksSortedByName();
        System.out.println("Actual: " + sorted.get(1).getName());
        System.out.println("Expected: How to Disappear Completely");
        System.out.println("Actual: " + sorted.get(2).getName());
        System.out.println("Expected: Idioteque");

        System.out.println("Actual: " + a.findTrack("aaa"));
        System.out.println("Expected: null");
        System.out.println("Actual: " + a.findTrack("Morning Bell").toString());
        System.out.println("Expected: Radiohead - Morning Bell");
    }
}