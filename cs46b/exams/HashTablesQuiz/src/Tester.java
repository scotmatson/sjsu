public class Tester
{
	public static void main(String[] args)
	{
		Inventory i = new Inventory();
		i.addAlbum(new Album("LCD Soundsystem", "Sound of Silver"));
		i.addAlbum(new Album("Arcade Fire", "Reflektor"));
		
		System.out.println("Actual: " + i.size());
		System.out.println("Expected: 2");
		
		System.out.printf("Actual: %.2f%n", i.getLoadFactor());
		System.out.printf("Expected: 0.09%n");
		
		i.addAlbum(new Album("Steve Reich", "Different Trains"));
		i.addAlbum(new Album("Return to Forever", "Return to Forever"));
		
		System.out.println("Actual: " + i.contains(new Album("Return to Forever", "Return to Forever")));
		System.out.println("Expected: true");
		
		System.out.println("Actual: " + i.contains(new Album("Arcade Fire", "Reflektor")));
		System.out.println("Expected: true");
		
		System.out.println("Actual: " + i.size());
		System.out.println("Expected: 4");
		
		System.out.println("Actual: " + i.contains(new Album("xxx", "xxx")));
		System.out.println("Expected: false");
		
		System.out.printf("Actual: %.2f%n", i.getLoadFactor());
		System.out.printf("Expected: 0.17%n");
		
		i.addAlbum(new Album("Jeff Buckley", "Sketches for My Lover the Drunk"));
		System.out.println("Actual: " + i.contains(new Album("Jeff Buckley", "Sketches for My Lover the Drunk")));
		System.out.println("Expected: true");
	}
}