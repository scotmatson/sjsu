import java.util.Iterator;

public class Tester2
{

	public static void main(String[] args)
	{
		Package[] p = new Package[11];
		p[0] = new Package("a", 1);
		p[1] = new Package("b", 3);
		p[2] = new Package("c", 1);
		p[3] = new Package("d", 0);
		p[4] = new Package("e", 3);
		p[5] = new Package("f", 1);
		p[6] = new Package("g", 2);
		p[7] = new Package("h", 3);
		p[8] = new Package("i", 1);
		p[9] = new Package("j", 0);
		p[10] = new Package("k", 0);
		
		ShippingQueue sq = new ShippingQueue();
		
		sq.add(p[10]); // k, 0
		sq.add(p[9]); // j, 0
		sq.add(p[8]); // i, 1
		sq.add(p[7]); // h, 3
		sq.add(p[6]); // g, 2

		Iterator<Package> i = sq.iterator();

		System.out.println("Actual: " + i.hasNext());
		System.out.println("Expected: true");

		System.out.println("Actual: " + i.next());
		System.out.println("Expected: Package[address=h, shippingPriority=3]");

		System.out.println("Actual: " + i.hasNext());
		System.out.println("Expected: true");

		System.out.println("Actual: " + i.next());
		System.out.println("Expected: Package[address=g, shippingPriority=2]");

		i.next();
		i.next();
		i.next();
		
		System.out.println("Actual: " + i.hasNext());
		System.out.println("Expected: false");
    }
}