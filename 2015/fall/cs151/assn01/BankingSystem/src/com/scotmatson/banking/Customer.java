/**
 * 
 * COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.
 * 
 * Classes to create and store information about customers.
 * 
 * Solves CS151 homework assignment #1
 * 
 * @author Scot Matson
 * 
 * @version 1.01 2015/9/18
 * 
 */
package com.scotmatson.banking;

public class Customer extends Person
{
   private final int ID;

   /**
    * Constructor method.
    * 
    * @param customerID
    *           the customer ID.
    * @param firstName
    *           the customer's first name.
    * @param lastName
    *           the customer's last name.
    */
   public Customer(String fName, String lName, int cid)
   {
      super(fName, lName);
      this.ID = cid;
   }

   /**
    * Returns the customer ID.
    * 
    * @return the customer ID.
    */
   public int getID()
   {
      return this.ID;
   }
}