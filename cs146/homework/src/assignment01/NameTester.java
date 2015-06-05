package assignment01;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 Tests the functionality of constructing, setting, and getting a name.

 Solves CS147 Homework Assignment #01

 @author Scot Matson
 @version 1.00 2015/06/05
 */
public class NameTester
{
   public static void main(String[] args)
   {
      NameFinder name = new NameFinder("Scot", "Matson");
      System.out.printf("First Name: %s\n", name.getFirstName());
      System.out.printf(" Last Name: %s\n", name.getLastName());
      System.out.printf(" Full Name: %s\n\n", name.getFullName());

      name.setFirstName("Zaphod");
      name.setLastName("BeebleBrox");
      System.out.printf("First Name: %s\n", name.getFirstName());
      System.out.printf(" Last Name: %s\n", name.getLastName());
      System.out.printf(" Full Name: %s\n\n", name.getFullName());

      name.setFullName("Frank", "Frazetta");
      System.out.printf("First Name: %s\n", name.getFirstName());
      System.out.printf(" Last Name: %s\n", name.getLastName());
      System.out.printf(" Full Name: %s\n\n", name.getFullName());
   }
}
