
/**
 * Helper class to interact Strings with an ArrayList.
 * 
 * @author (Scot Matson) 
 * @version (2014-10-23)
 */
import java.util.ArrayList;

public class ArrayListOfStrings
{
   private ArrayList<String> list;
   
   /**
    * Constructor method that instantiates a new ArrayList
    */
   ArrayListOfStrings () {
       list = new ArrayList<String>();
   }
   
   public String toString()
   {
       return list.toString();
   }
   
   /**
    * Adds this string to the array list of strings
    * @param text The string to be added.
    */
   public void add(String text) {
       list.add(text);
   }
   
   /**
    * Replaces every element in the list with a version
    * of the String in which the first character is uppercase.
    */
   public void firstToUpperCase() {
       for (int i = 0; i < list.size(); ++i) {
           String theFirstLetter = list.get(i).substring(0, 1);
           String theRest = list.get(i).substring(1);
           list.set(i, theFirstLetter.toUpperCase() + theRest);
       }
   }
   
   /**
    * Swaps the element at index1 with the element at index2.
    * @param index1 Element to be swapped.
    * @param index2 Element to be swapped.
    */
   public void swap(int index1, int index2) {
       if ((index1 >= 0 && index1 < list.size()) &&
           (index2 >= 0 && index2 < list.size())) {
               String swap = list.get(index1);
               list.set(index1, list.get(index2));
               list.set(index2, swap);
       }
   }
   
   /**
    * Returns a new array list containing only those Strings that in end lowercase e.
    * @return endsWithE A list of strings that end with the letter 'e'.
    */
   public ArrayList<String> endsWithE() {
       ArrayList<String> eSuffix = new ArrayList<String>();
       for (String listItem : list) {
           if (listItem.substring(listItem.length()-1).compareTo("e") == 0) {
               eSuffix.add(listItem);
           }
       }
       return eSuffix;
   }
}
