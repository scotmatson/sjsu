//ID9602502

import java.util.ArrayList;

/**
  In the folder, you are given a Computer class
  You are to write a subclass called Laptop

  The subclass has an additional instance variable
   batteryLife as double

  The condtructor should take the instance variables of the oringinal 
  class plus the new instance variable as parameters
  Provide accessor and mutators for the new instance variable only. Do not redefine the instance
  variables of the super class. 
  Override the toString method to append the new instance variable and value to the 
  return string. Call the super class toString. Do not repeat the work of concatenating
  the super class instance variables
  
  In the main method of Problem5, create an ArrayList of Laptop
  Instantiate and add 3 objects of type Laptop to
  the ArrayList. Then use a loop to call the toString method of each object and 
  print the result
  
  Submit the .java files for your subclass and  Problem5.java
 */
public class Problem5
{
    public static void main(String[] args)
    {
        ArrayList<Laptop> LTList = new ArrayList<Laptop>();
        LTList.add(new Laptop("Dell", 43423, 45.4));
        LTList.add(new Laptop("Apple", 56456, 76.8));
        LTList.add(new Laptop("Chromebook", 973, 10.45));

        for (Laptop lt : LTList) {
            System.out.println(lt.toString());
        }



    }
}
