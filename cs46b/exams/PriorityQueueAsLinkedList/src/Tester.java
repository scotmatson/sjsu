public class Tester
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
		
		sq.add(p[0]);
		System.out.println("Actual: " + sq.size());
		System.out.println("Expected: 1");
		
		System.out.println("Actual: " + sq.remove());
		System.out.println("Expected: Package[address=a, shippingPriority=1]");

		System.out.println("Actual: " + sq.size());
		System.out.println("Expected: 0");
		
		sq.add(p[1]);
		sq.add(p[2]);
		
		System.out.println("Actual: " + sq.size());
		System.out.println("Expected: 2");
		
		System.out.println("Actual: " + sq.remove());
		System.out.println("Expected: Package[address=b, shippingPriority=3]");
		
		//for( Package tmp : p ) sq.add(tmp);
		sq.add(p[3]);
		sq.add(p[4]);
		sq.add(p[5]);
		sq.add(p[6]);
		
		System.out.println("Actual: " + sq.size());
		System.out.println("Expected: 5");

        // The priority is wrong here....
		System.out.println("Actual: " + sq.remove().getPriority());
		System.out.println("Expected: 3");
		
		System.out.println("Actual: " + sq.size());
		System.out.println("Expected: 4");
		
		System.out.println("Actual: " + sq.remove().getPriority());
		System.out.println("Expected: 2");

		System.out.println("Actual: " + sq.remove().getPriority());
		System.out.println("Expected: 1");

		System.out.println("Actual: " + sq.size());
		System.out.println("Expected: 2");

		sq.remove();
		Package tmp = sq.remove();
		System.out.println("Actual: " + tmp.getPriority());
		System.out.println("Expected: 0");

		System.out.println("Actual: " + tmp.toString());
		System.out.println("Expected: Package[address=d, shippingPriority=0]");

	}
}