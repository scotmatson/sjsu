package examples;

public class Ex48 implements Filter {

	public static void main(String[] args)
	{
		Filter filter = new Ex48();
		String[] words = new String[10];
		words[0] = "Burrito";
		words[1] = "Horse";
		words[2] = "Sniff";
		words[3] = "Butt";
		words[4] = "Sashsa";
		words[5] = "Noogie";
		words[6] = "Norse";
		words[7] = "Chalet";
		words[8] = "Kirby";
		words[9] = "Grope";
		String[] filteredWords = filter(words, filter);
		for (int i = 0; i < filteredWords.length; ++i)
			if (filteredWords[i] != null) {
				System.out.println("Word " + (i + 1) + " " +  filteredWords[i]);
			}
	}
	
	public static String[] filter(String[] a, Filter f)
	{
		String[] caught = new String[a.length];
		int caughtWordCounter = 0;
		for (int i = 0; i < a.length; ++i)
		{
			if (f.accept(a[i]))
			{
				caught[caughtWordCounter] = a[i];
				++caughtWordCounter;
			}
		}
		return caught;
	}

	public boolean accept(String x) {
		return (x.length() == 6);
	}
}
