package chapter04;

import java.util.ArrayList;
import java.util.Collections;

public class Example003 {

	public static void main(String[] args)
	{
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("Uruguay");
		countries.add("Thailand");
		countries.add("Belgium");
		Collections.sort(countries);
		
		for (String country : countries)
		{
			System.out.println(country);
		}
	}
}
