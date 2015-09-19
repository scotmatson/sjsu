/**
 * Manages customer accounts.
 */
package com.scotmatson.banking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Bank 
{
	private final String NAME;
	private final int ID;
	private HashMap<Integer, List<Account>> customers = new HashMap<>();

	Random random = new Random();
	
	/**
	 * 
	 * @param name
	 * @param id
	 */
	public Bank(String name, int id) 
	{
		this.NAME = name;
		this.ID = id;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public Customer addCustomer(Person p)
	{
		String fName = p.getFirstName();
		String lName = p.getLastName();
		int cid = random.nextInt(90) + 10;
		
		// Makes a customer out of a Person
		Customer customer = new Customer(fName, lName, cid);
		// Create an customer accounts shell.
		List<Account> accounts = null;
	
		customers.put(cid, accounts);
		
		return customer;
	}
	
	/**
	 * 
	 * @param customerID
	 * @param account
	 */
	public void addCustomerAccount(int customerID, int pin)
	{
		int accountID = random.nextInt(90) + 10;
		Account account = new Account("CHECKING", accountID, pin, 100);
		
		// Obtain customer accounts.
		List<Account> accounts = customers.get(customerID);
		
		// Assign a new account or add to an existing list.
		if (accounts != null)
		{
			accounts.add(account);
			customers.put(customerID, accounts);
		}
		else
		{
			accounts = new ArrayList<Account>();
			accounts.add(account);
			customers.put(customerID, accounts);
		}
	}
	
	/**
	 * 
	 * @param customerID
	 * @param pinNumber
	 */
	public Account getCustomerAccount(Integer customerID, int pin)
	{
		List<Account> accounts = customers.get(customerID);

		// Return the account that the PIN unlocks, if any.
		for (Account a : accounts)
		{
			if (a.compareTo(pin) == 0)
			{
				return a;
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param customerID
	 * @param pin
	 * @return
	 */
	public boolean authorizeAccountAcccess(Integer customerID, int pin)
	{
		List<Account> accounts = customers.get(customerID);

		// Return the account that the PIN unlocks, if any.
		for (Account a : accounts)
		{
			if (a.compareTo(pin) == 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getID()
	{
		return this.ID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return this.NAME;
	}
	
	/**
	 * 
	 * @param uid
	 * @param pin
	 * @param amount
	 */
	public boolean withdrawalFunds(int uid, int pin, int amount)
	{
		boolean isComplete = false;
		Account account = getCustomerAccount(uid, pin);
		if (account != null)
		{
			account.decreaseBalance(amount);
			isComplete = true;
		}
		return isComplete;
	}
	
	/**
	 * 
	 * @param uid
	 * @param pin
	 * @param amount
	 * @return
	 */
	public boolean depositFunds(int uid, int pin, int amount)
	{
		boolean isComplete = false;
		Account account = getCustomerAccount(uid, pin);
		if (account != null)
		{
			account.increaseBalance(amount);
			isComplete = true;
		}
		
		return isComplete;
	}
}
