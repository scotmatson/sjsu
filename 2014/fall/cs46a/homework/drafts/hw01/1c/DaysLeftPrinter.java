
/**
 * Write a description of class DaysLeftPrinter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DaysLeftPrinter
{
   public static void main(String[] args)
   {
       //put your code here
       Day today = new Day();
       Day thanksgiving = new Day(2014, 11, 27);
       System.out.println(thanksgiving.daysFrom(today));
       
       System.out.println(today.toString()); //do not change this line
       //DO NOT put code here
   }
}

