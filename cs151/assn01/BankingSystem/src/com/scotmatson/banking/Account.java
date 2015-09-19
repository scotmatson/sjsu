/**
 * Record of account information
 */
package com.scotmatson.banking;

public class Account implements Comparable<Integer> {
	
	
	
	private final String TYPE;
	private final int ID;
	private int pin;
	private int balance;
	
	/**
	 * 
	 * @param type
	 * @param id
	 * @param pin
	 * @param balance
	 */
	public Account (String type, int id, int pin, int balance) {
		this.TYPE = type;
		this.ID = id;
		this.pin = pin;
		this.balance = balance;
	}
	
	/**
	 * 
	 * @return the account type.
	 */
	public String getType()
	{
		return this.TYPE;
	}
	
	/**
	 * 
	 * @return the account number.
	 */
	public int getID()
	{
		return this.ID;
	}
	
	/**
	 * 
	 * @return the account balance.
	 */
	public int getBalance()
	{
		return this.balance;
	}
	
	/**
	 * 
	 * @param pin
	 */
	public void setPin(int pin)
	{
		this.pin = pin;
	}

	@Override
	public int compareTo(Integer pin) {
		if (this.pin == pin.intValue())
		{
			return 0;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param amount
	 * @return
	 */
	public void increaseBalance(int amount)
	{
		this.balance += amount;
	}
	
	/**
	 * 
	 * @param amount
	 * @return
	 */
	public void decreaseBalance(int amount)
	{
		this.balance -= amount;
	}
}
