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
		int cid = random.nextInt(100);
		
		Customer customer = new Customer(fName, lName, cid);
		List<Account> customerAccounts = null;
		customers.put(customer.getID(), customerAccounts);
		
		return customer;
	}
	
	/**
	 * 
	 * @param customerID
	 * @param account
	 */
	public void addCustomerAccount(int customerID, int pin)
	{
		int accountID = random.nextInt(100);
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
}
