import java.util.Arrays;

public class Tester2
{
    public static void main(String[] args)
    {
        DigitalAlbum[] albums = new DigitalAlbum[5];
        albums[0] = new DigitalAlbum("Weezer", "Pinkerton", 7.99, 11, "aaa");
        albums[1] = new DigitalAlbum("Weezer", "Weezer", 7.99, 8, "bbb");
        albums[2] = new DigitalAlbum("Jeff Buckley", "Grace", 9.99, 10, "ccc");
        albums[3] = new DigitalAlbum("Jeff Buckley", "Sketches for My Lover the Drunk", 12.99, 12, "ddd");
        albums[4] = new DigitalAlbum("Weezer", "Weezer", 7.99, 8, "xyz");

        System.out.println("Actual: " + albums[1].toString());
        System.out.println("Expected: DigitalAlbum[artist=Weezer, title=Weezer, link=bbb]");

        System.out.println("Actual: " + albums[0].getArtist());
        System.out.println("Expected: Weezer");

        System.out.println("Actual: " + albums[2].getTitle());
        System.out.println("Expected: Grace");

        Arrays.sort(albums);

        System.out.println("Actual: " + albums[0].toString());
        System.out.println("Expected: DigitalAlbum[artist=Jeff Buckley, title=Grace, link=ccc]");

        System.out.println("Actual: " + albums[1].toString());
        System.out.println("Expected: DigitalAlbum[artist=Jeff Buckley, title=Sketches for My Lover the Drunk, link=ddd]");

        System.out.println("Actual: " + albums[4].toString());
        System.out.println("Expected: DigitalAlbum[artist=Weezer, title=Weezer, link=xyz]");

        System.out.println("Actual: " + albums[2].getTitle());
        System.out.println("Expected: Pinkerton");

        System.out.println("Actual: " + albums[3].getTitle());
        System.out.println("Expected: Weezer");

        Arrays.sort(albums, albums[0].getTrackCountComparator());

        System.out.println("Actual: " + albums[0].toString());
        System.out.println("Expected: DigitalAlbum[artist=Jeff Buckley, title=Sketches for My Lover the Drunk, link=ddd]");

        System.out.println("Actual: " + albums[1].toString());
        System.out.println("Expected: DigitalAlbum[artist=Weezer, title=Pinkerton, link=aaa]");

    }

}