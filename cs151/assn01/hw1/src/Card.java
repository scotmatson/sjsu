/**
 * 
 * COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.
 * 
 * Classes to store and access digital information.
 * 
 * Solves CS151 homework assignment #1
 * 
 * @author Scot Matson
 * 
 * @version 1.01 2015/9/18
 * 
 */
import java.util.Calendar;
import java.util.Date;

public class Card
{
   private final int number;
   private final Date expiration;
   private final String name;

   /**
    * Constructor method.
    * 
    * @param bank
    *           the affiliated bank.
    * @param customer
    *           the card holder.
    */
   public Card(Bank bank, Customer customer, Account account)
   {
      // Combining the digits of each ID to build a card number.
      StringBuilder sb = new StringBuilder();
      sb.append(bank.getID());
      sb.append(customer.getID());
      sb.append(account.getID());
      String s = sb.toString();
      this.number = Integer.parseInt(s);

      this.name = customer.getFirstName() + " " + customer.getLastName();

      // New cards expire 2 year from their issued date.
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.YEAR, 2);
      expiration = cal.getTime();
   }

   /**
    * Constructor method.
    * 
    * @param bank
    *           the affiliated bank.
    * @param customer
    *           the card holder.
    * @param expiration
    *           user-defined card expiration date.
    */
   public Card(Bank bank, Customer customer, Account account, Date expiration)
   {
      // Combining the digits of each ID to build a card number.
      StringBuilder sb = new StringBuilder();
      sb.append(bank.getID());
      sb.append(customer.getID());
      sb.append(account.getID());
      String s = sb.toString();
      this.number = Integer.parseInt(s);

      this.name = customer.getFirstName() + " " + customer.getLastName();
      this.expiration = expiration;

   }

   /**
    * Returns the card number.
    * 
    * @return the card number.
    */
   public int getNumber()
   {
      return this.number;
   }

   /**
    * Returns the card expiration date.
    * 
    * @return the card expiration date.
    */
   public Date getExpiration()
   {
      return this.expiration;
   }

   /**
    * Returns the card holder's name.
    * 
    * @return the card holder's name.
    */
   public String getName()
   {
      return this.name;
   }
}
