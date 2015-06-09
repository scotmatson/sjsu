/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved

 Helper class for the NameFinderDemo.java class.

 Solves CS147 Homework Assignment #01

 @author Scot Matson
 @version 1.00 2015/6/5
 */
package assignment01;

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
