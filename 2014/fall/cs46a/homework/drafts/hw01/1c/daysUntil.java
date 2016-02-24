
/**
 * Write a description of class daysUntil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class daysUntil
{
    public static void main(String[] args) {
        Day schoolStart = new Day(2013, 8, 21);
        Day yearEnd = new Day(2014, 1, 1);
        System.out.println(yearEnd.daysFrom(schoolStart));
    }
}
