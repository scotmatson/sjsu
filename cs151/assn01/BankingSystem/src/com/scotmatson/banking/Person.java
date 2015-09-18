package com.scotmatson.banking;

public class Person 
{
	private String firstName;
	private String lastName;
	
	/**
	 * 
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 */
	public Person (String firstName, String lastName) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLastName()
	{
		return this.lastName;
	}
}
