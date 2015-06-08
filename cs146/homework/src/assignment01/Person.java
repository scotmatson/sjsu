package assignment01;

/**
 Created by scot on 6/7/15.
 */
public class Person
{
   String firstName;
   String lastName;

   Person (String fn, String ln)
   {
      firstName = fn;
      lastName = ln;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public String getFullName()
   {
      return firstName + " " + lastName;
   }
}
