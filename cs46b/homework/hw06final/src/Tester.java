public class Tester
{
    public static void main(String[] args)
    {
        Album a = Album.fromFile("KidA.album");
        Album b = Album.fromFile("SoundOfSilver.album");

        System.out.println("Actual: " + a.getTrackAt(4).getName());
        System.out.println("Expected: Treefingers");

        System.out.println("Actual: " + b.getTrackAt(2).getName());
        System.out.println("Expected: North American Scum");

        a.removeTrackAt(3);
        System.out.println("Actual: " + a.getTrackAt(5).getName());
        System.out.println("Expected: In Limbo");

        b.addTrackAt(2, new Track("ccc", "ddd"));
        System.out.println("Actual: " + b.getTrackAt(2).getArtist());
        System.out.println("Expected: ccc");

        MusicLibrary ml = new MusicLibrary();
        ml.addAlbum(a);

        System.out.println("Actual: " + ml.count());
        System.out.println("Expected: 1");

        System.out.println("Actual: " + ml.getAlbum("sdfsdf"));
        System.out.println("Expected: null");

        ml.addAlbum(b);

        System.out.println("Actual: " + ml.count());
        System.out.println("Expected: 2");

        ml.addAlbum(b);

        System.out.println("Actual: " + ml.count());
        System.out.println("Expected: 2");

        System.out.println("Actual: " + ml.getAlbum("Kid A").getArtist());
        System.out.println("Expected: Radiohead");

        ml.removeAlbum("Kid A");
        System.out.println("Actual: " + ml.getAlbum("Kid A"));
        System.out.println("Expected: null");

        System.out.println("Actual: " + ml.getAlbum("Sound of Silver").getArtist());
        System.out.println("Expected: LCD Soundsystem");
    }
}