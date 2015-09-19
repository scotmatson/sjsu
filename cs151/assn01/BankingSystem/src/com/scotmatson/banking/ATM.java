/**
 * 
 */
package com.scotmatson.banking;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM implements Scannable<Card> {
	
	Scanner in = new Scanner(System.in);
	private Bank bank;
	private int maxWithdrawal; // Although - never runs out of cash.
	private int userInput;
	private int bankID;
	private int customerID;
	private int accountID;
	private Date cardExpiration;
	
	public ATM (Bank bank, int maxWithdrawal)
	{
		this.bank = bank;
		this.maxWithdrawal = maxWithdrawal;
	}
	
	/**
	 * 
	 */
	@Override
	public void scan(Card card) {
		int cardNumber = card.getNumber();
		this.accountID = cardNumber / 100;
		cardNumber %= 100;
		
		this.customerID = cardNumber / 100;
		cardNumber %= 100;
		
		this.bankID = cardNumber;
		
		this.cardExpiration = card.getExpiration();
		
		System.out.println("Scanned");
	}	
	
	/**
	 * 
	 */
	public boolean validateCard()
	{
		boolean isValid = false;

		// Validate Bank Affiliation.
		if (bank.getID() == this.bankID)
		{	
			// Validate card expiration date.
			Calendar calendar = Calendar.getInstance();
			Date now = calendar.getTime();	
			if (now.before(this.cardExpiration))
			{
				// Validate user credentials.
				int pin = getCustomerPIN();
				isValid = bank.authorizeAccountAcccess(customerID, pin);
			}
		}
		return isValid;
	}
	
	/**
	 * 
	 */
	public void beginTransaction() 
	{

		userInput = printATMMenu();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCustomerPIN()
	{
		System.out.print("Enter your PIN: ");
		int pin = -1;
		try 
		{
			pin = in.nextInt();
		}
		catch(InputMismatchException e)
		{
		    	System.out.println("Invalid user entry.");
		    	// Flush the Scanner
		    	in.next();
		}
		return pin;
	}
	
	public int printATMMenu()
	{
		return -1;
	}
	
	/**
	 * Flushes stored values from ATM memory
	 * preventing further user interaction.
	 */
	public void endTransaction()
	{
		userInput 		= -1;
		bankID 			= -1;
		customerID 		= -1;
		accountID 		= -1;
		cardExpiration  = null;
		
		System.out.println("End Transaction.");
		System.out.println("Your card has been returned.");
	}
	
	public 
	
	/**
	 * 
	 */
	public void makeDeposit(int amount)
	{
		int cid = card.getNumber();
		int 
		bank.depositFunds(cid, pin, amount);
	}
	
	/**
	 * 
	 */
	public void makeWithdrawal(int amount)
	{
		bank.withdrawalFunds(this.customerID, this.pin, amount)
	}
}
