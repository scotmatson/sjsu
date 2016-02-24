public class Tester
{
    public static void main(String[] args)
    {
        Album a = Album.fromFile("KidA.album");
        Album b = Album.fromFile("SoundOfSilver.album");

        System.out.println("Actual: " + a.getTrackAt(3).getName());
        System.out.println("Expected: How to Disappear Completely");

        System.out.println("Actual: " + b.getTrackAt(2).getName());
        System.out.println("Expected: North American Scum");

        a.removeTrackAt(3);
        System.out.println("Actual: " + a.getTrackAt(3).getName());
        System.out.println("Expected: Treefingers");

        b.addTrackAt(2, new Track("ccc", "ddd"));
        System.out.println("Actual: " + b.getTrackAt(2).getName());
        System.out.println("Expected: ddd");
    }
}