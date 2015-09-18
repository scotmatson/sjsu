/**
 * Record of customer information.
 */
package com.scotmatson.banking;

public class Customer extends Person
{
	private final int ID;

	/**
	 * 
	 * @param customerID
	 * @param firstName
	 * @param lastName
	 */
	public Customer (String fName, String lName, int cid) 
	{
		super(fName, lName);
		this.ID = cid;
	}

	/**
	 * 
	 * @return
	 */
	public int getID()
	{
		return this.ID;
	}
}