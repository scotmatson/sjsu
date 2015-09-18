/**
 * Key to access an ATM.
 */
package com.scotmatson.banking;

import java.util.Calendar;
import java.util.Date;

public class Card {
	private final int number;
	private final Date expiration;
	private final String name;
	
	/**
	 * 
	 * @param bank
	 * @param customer
	 */
	public Card (Bank bank, Customer customer, Account account)
	{
		this.number = bank.getID() + customer.getID() + account.getID();
		this.name = customer.getFirstName() + " " + customer.getLastName();
		
		// New card expire 1 year from their issued date.
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1);
		expiration = cal.getTime();
	}
	
	/**
	 * 
	 * @param bank
	 * @param customer
	 * @param expiration
	 */
	public Card (Bank bank, Customer customer, Date expiration) 
	{
		this.number = bank.getID() + customer.getID();
		this.expiration = expiration;
		this.name = customer.getFirstName() + " " + customer.getLastName();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumber()
	{
		return this.number;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getExpiration()
	{
		return this.expiration;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
}