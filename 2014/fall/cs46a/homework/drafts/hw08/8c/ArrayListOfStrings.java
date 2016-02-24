
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
       
   }
   
   /**
    * Swaps the element at index1 with the element at index2.
    * @param index1 Element to be swapped.
    * @param index2 Element to be swapped.
    */
   public void swap(int index1, int index2) {
       
   }
   
   /**
    * Returns a new array list containing only those Strings that in end lowercase e.
    * @return endsWithE A list of strings that end with the letter 'e'.
    */
   public ArrayList<String> endsWithE() {
       return list;
   }
}
