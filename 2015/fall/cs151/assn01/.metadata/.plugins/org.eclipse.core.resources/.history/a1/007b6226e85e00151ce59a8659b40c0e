/**

   COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

   Classes used to create and manage customer accounts.

   Solves CS151 homework assignment #1

   @author Scot Matson

   @version 1.01 2015/9/18

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
	 * Constructor method.
	 * 
	 * @param name the name of the bank.
	 * @param id the bank identification code.
	 */
	public Bank(String name, int id) 
	{
		this.NAME = name;
		this.ID = id;
	}
	
	/**
	 * Adds a new customer to the bank and gives them an ID.
	 * 
	 * @param p a person.
	 * @return a customer.
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
	 * Establishes a new account for an existing customer.
	 * 
	 * @param customerID the customer ID.
	 * @param pin the account PIN.
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
	 * Gets the customer account.
	 * 
	 * @param customerID the customer ID.
	 * @param pinNumber the account PIN.
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
	 * Authorizes access to a customer account.
	 * 
	 * @param customerID a customer ID.
	 * @param pin an account PIN.
	 * @return true if access was successful.
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
	 * Gets the account balance.
	 * 
	 * @param customerID the customer ID.
	 * @param pin the account PIN.
	 * @return the account balance.
	 * @return an error code.
	 */
	public int displayAccountBalance(Integer customerID, int pin)
	{
		List<Account> accounts = customers.get(customerID);

		// Return the account that the PIN unlocks, if any.
		for (Account a : accounts)
		{
			if (a.compareTo(pin) == 0)
			{
				return a.getBalance();
			}
		}
		return -1;
	}
	
	/**
	 * Returns the bank identification number.
	 * 
	 * @return the bank ID.
	 */
	public int getID()
	{
		return this.ID;
	}
	
	/**
	 * Returns the name of the bank.
	 * 
	 * @return the bank name.
	 */
	public String getName()
	{
		return this.NAME;
	}
	
	/**
	 * Withdrawals funds from an existing customer account.
	 * 
	 * @param cid the customer identification number.
	 * @param pin the account PIN.
	 * @param amount the amount to be withdrawn.
	 * @return true if the withdrawal was successful.
	 */
	public boolean withdrawalFunds(int cid, int pin, int amount)
	{
		boolean isComplete = false;
		Account account = getCustomerAccount(cid, pin);
		if (account != null)
		{
			int result = account.decreaseBalance(amount);
			if (result >= 0)
			{
				isComplete = true;
			}
		}
		return isComplete;
	}
	
	/**
	 * Deposits funds into an existing customer account.
	 * 
	 * @param cid the customer identification number.
	 * @param pin the account PIN.
	 * @param amount the amount to be deposited.
	 * @return true if the deposit was successful.
	 */
	public boolean depositFunds(int cid, int pin, int amount)
	{
		boolean isComplete = false;
		Account account = getCustomerAccount(cid, pin);
		if (account != null)
		{
			account.increaseBalance(amount);
			isComplete = true;
		}
		
		return isComplete;
	}
}
