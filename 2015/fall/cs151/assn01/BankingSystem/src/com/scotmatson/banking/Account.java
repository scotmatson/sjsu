/**
 * 
 * COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.
 * 
 * Classes to create and store information about accounts.
 * 
 * Solves CS151 homework assignment #1
 * 
 * @author Scot Matson
 * 
 * @version 1.01 2015/9/18
 * 
 */
package com.scotmatson.banking;

public class Account implements Comparable<Integer>
{
   private final String TYPE;
   private final int ID;
   private int pin;
   private int balance;

   /**
    * Constructor method.
    * 
    * @param type
    *           the type of account.
    * @param id
    *           the account numerical identifier.
    * @param pin
    *           the account authorization code.
    * @param balance
    *           the current account balance.
    */
   public Account(String type, int id, int pin, int balance)
   {
      this.TYPE = type;
      this.ID = id;
      this.pin = pin;
      this.balance = balance;
   }

   /**
    * Returns the account type.
    * 
    * @return the account type.
    */
   public String getType()
   {
      return this.TYPE;
   }

   /**
    * Returns the account id.
    * 
    * @return the account id.
    */
   public int getID()
   {
      return this.ID;
   }

   /**
    * Returns the account balance.
    * 
    * @return the account balance.
    */
   public int getBalance()
   {
      return this.balance;
   }

   /**
    * Sets the account PIN.
    * 
    * @param pin
    *           the new account PIN.
    */
   public void setPin(int pin)
   {
      this.pin = pin;
   }

   /**
    * Compares the stored account PIN to a given user PIN to securely authorize
    * account access.
    */
   @Override
   public int compareTo(Integer pin)
   {
      if (this.pin == pin.intValue())
      {
         return 0;
      }
      return -1;
   }

   /**
    * Deposits additional funds into the account.
    * 
    * @param amount
    *           the amount to be deposited.
    */
   public void increaseBalance(int amount)
   {
      // No limitations, go ahead and give yourself
      // all the free money you want.
      this.balance += amount;
   }

   /**
    * Withdrawals funds from the account.
    * 
    * @param amount
    *           the amount to be withdrawn from the account.
    * @return a positive or negative value indicating if the transaction was
    *         successful.
    */
   public int decreaseBalance(int amount)
   {
      // A negative balance will not be processed.
      int difference = this.balance - amount;
      if (difference >= 0)
      {
         this.balance -= amount;
      }

      return difference;
   }
}