//ID9602502
/**
  In the folder, you are given a Computer class
  A Computer has a brand and a clock speed
  You are to modify the class to implement Comparable interface. 
  A Computer is ordered first by clock speed and then by 
  brand
  Then in the main method of Problem1, declare two objects of your class. 
  Use the compareTo method to determine which is smaller and then print the instance variables 
  of the smallest object

  Submit both the class you modified and Problem1.java files
*/
public class Problem1
{
    public static void main(String[] args)
    {
        Computer comp1 = new Computer("Dell", 3400);
        Computer comp2 = new Computer("Apple", 6800);
        if (comp1.compareTo(comp2) < 0) System.out.println(comp1.getBrand() + "\n" + comp1.getClockSpeed());
        else System.out.println(comp2.getBrand() + "\n" + comp2.getClockSpeed());
    }


}
