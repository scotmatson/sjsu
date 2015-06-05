/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 Class to store and locate instances of a given name.

 Solves CS 147 Homework Assignment #01

 @author Scot Matson
 @version 1.00 2015/6/5
 */
package assignment01;

public class NameFinder
{

   private String firstName;
   private String lastName;

   NameFinder (String first, String last)
   {
      firstName = first;
      lastName = last;
   }

   /**
    Returns the last name set by the user.

    @return the last name.
    */
   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
}
