/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 Class to store and locate instances of a given name.

 Solves CS147 Homework Assignment #01

 @author Scot Matson
 @version 1.00 2015/6/5
 */
package assignment01;

public class NameFinder
{

   private String firstName;
   private String lastName;

   /**
    Constructor for the name finder class.

    @param first the first name.
    @param last the last name.
    */
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

   /**
    Sets the last name.

    @param lastName the last name.
    */
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   /**
    Gets the first name.

    @return the first name.
    */
   public String getFirstName()
   {
      return firstName;
   }

   /**
    Sets the first name.

    @param firstName the first name.
    */
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   /**
    Constructs the full name by concatenating the firstName and lastName
    instance variables.

    @return the full name.
    */
   public String getFullName() {
      return getFirstName() + " " + getLastName();
   }

   /**
    Sets the first and last name.

    @param first the first name.
    @param last the last name.
    */
   public void setFullName(String first, String last) {
      setFirstName(first);
      setLastName(last);
   }
}
