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
		// Combining the digits of each ID to build a card number.
		StringBuilder sb = new StringBuilder();
		sb.append(bank.getID());
		sb.append(customer.getID());
		sb.append(account.getID());
		String s = sb.toString();
		this.number = Integer.parseInt(s);
		
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
	public Card (Bank bank, Customer customer, Account account, Date expiration) 
	{
		this.number = bank.getID() + customer.getID() + account.getID();
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