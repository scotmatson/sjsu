//ID9602502

import java.util.ArrayList;

/**
  This Problem2 is an ArrayList manager. It manages an ArrayList 
  of Computer objects.
  You need to provide the instance variable for Problem2 and complete the constructor
  Then implement the add method which adds an item to the ArrayList for 
  this Problem2 manager
  Next implement the contains method. The contains method returns true if an 
  item with the given brand exists in the 
  ArrayList of Problem2 and false otherwise. Also return false if the ArrayList is empty

  Note that you will not be able to use the ArrayList's contain method for this

  You will upload Problem2.java
*/
public class Problem2
{
    //provide instance variable
    ArrayList<Computer> compObj;
    public Problem2()
    {
        //finish constructor
        compObj = new ArrayList<Computer>();
    }
    
    /**
     * Adds a Computerto this Problem2 manager
     * @param item the item to add
     */
    public void add(Computer item)
    {
        compObj.add(item);
    }
    
    public boolean contains(String brand)
    {
      for (int i = 0; i < compObj.size(); ++i) {
          if (brand.compareTo(compObj.get(i).getBrand()) == 0) {
              return true;
          }
      }
      return false;
    }
    
    
}
