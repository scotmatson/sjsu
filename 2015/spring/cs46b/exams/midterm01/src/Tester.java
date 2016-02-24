import java.util.Arrays;

public class Tester
{

    public static void main(String[] args)
    {
        CompactDisc[] cds = new CompactDisc[4];
        cds[0] = new CompactDisc("Weezer", "Pinkerton", 7.99, 11, 12345);
        cds[1] = new CompactDisc("Weezer", "Weezer", 7.99, 8, 2222);
        cds[2] = new CompactDisc("Jeff Buckley", "Grace", 9.99, 10, 333);
        cds[3] = new CompactDisc("Jeff Buckley", "Sketches for My Lover the Drunk", 12.99, 12, 4444);

        System.out.println("Actual: " + cds[1].toString());
        System.out.println("Expected: CompactDisc[artist=Weezer, title=Weezer, inventoryNumber=2222]");

        System.out.println("Actual: " + cds[0].getArtist());
        System.out.println("Expected: Weezer");

        System.out.println("Actual: " + cds[2].getTitle());
        System.out.println("Expected: Grace");

        Arrays.sort(cds);

        System.out.println("Actual: " + cds[0].toString());
        System.out.println("Expected: CompactDisc[artist=Jeff Buckley, title=Grace, inventoryNumber=333]");

        System.out.println("Actual: " + cds[1].toString());
        System.out.println("Expected: CompactDisc[artist=Jeff Buckley, title=Sketches for My Lover the Drunk, inventoryNumber=4444]");


        System.out.println("Actual: " + cds[2].getTitle());
        System.out.println("Expected: Pinkerton");

        System.out.println("Actual: " + cds[3].getTitle());
        System.out.println("Expected: Weezer");
    }

}